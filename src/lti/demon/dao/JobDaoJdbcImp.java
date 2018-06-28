package lti.demon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import lti.demon.bean.JobBean;
import lti.demon.bean.LoginBean;
import lti.demon.bean.ProfileBean;
import lti.demon.bean.RegisterBean;
import lti.demon.bean.RequirementBean;



public class JobDaoJdbcImp implements JobDao{
	
	private static JobDao dao;
	
	public static JobDao getDao() {
		if(dao==null)
			dao=new JobDaoJdbcImp();
		return dao;
		
	}
	
	
	private Connection getConnected() throws SQLException{
		
		
		Connection conn;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			
			return conn;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
		//String url= "jdbc:oracle:thin:@localhost:1521:XE";
		//DriverManager.registerDriver(new OracleDriver());
		
		//Connection conn=DriverManager.getConnection(url,"jobs","apple");
	
	}

	@Override
	public String Validate(LoginBean login) {
		// TODO Auto-generated method stub
		
		String sal="select uname from user_table where uemail=? and upass=?";
		Connection conn=null;
		
		try {
			conn=getConnected();
			PreparedStatement pstmt=conn.prepareStatement(sal);
			pstmt.setString(1,login.getEmail());
			pstmt.setString(2,login.getPassword());
			
			ResultSet rs =pstmt.executeQuery();
			
			if(rs.next())
				return rs.getString(1);
			else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}

	@Override
	public boolean save(RegisterBean user, ProfileBean profile) {
		
		String sal1="insert into user_table values(?,?,?,?,?,?,?)";
		String sal2="insert into user_profile values(?,?,?,?,?)";
		// TODO Auto-generated method stub
		Connection conn = null;
				
				
		try {
			conn=getConnected();		
			conn.setAutoCommit(false);
			PreparedStatement pstmt1 =conn.prepareStatement(sal1);
			pstmt1.setString(1, user.getName());
			pstmt1.setString(2, user.getEmail());
			pstmt1.setString(3, user.getPassword());
			pstmt1.setString(4, user.getCity());
			pstmt1.setLong(5,user.getPhone());
			pstmt1.setString(6,user.getGender());
			pstmt1.setInt(7, user.getAge());
			
			
			PreparedStatement pstm2=conn.prepareStatement(sal2);
			pstm2.setString(1, profile.getEmail());
			pstm2.setString(2, profile.getLocation());
		
			pstm2.setDouble(3, profile.getExpSal());
			pstm2.setString(4,profile.getSkill());
			pstm2.setString(5, profile.getRole());
			pstmt1.executeUpdate();
			pstm2.executeUpdate();
			
			conn.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public ProfileBean getProfile(String email) {
		// TODO Auto-generated method stub
		
		String sal="select * from user_profile where uemail=?";
		Connection conn=null;
		
		try {
			conn=getConnected();
			PreparedStatement pstm=conn.prepareStatement(sal);
			pstm.setString(1,email);
			ResultSet rs=pstm.executeQuery();
			
			
			if(rs.next()) {
				
				ProfileBean profile=new ProfileBean();
				profile.setEmail(rs.getString(1));
				profile.setLocation(rs.getString(2));
				profile.setRole(rs.getString(5));
				profile.setExpSal(rs.getDouble(3));
				profile.setSkill(rs.getString(4));
				
				return profile;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
				
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}


	@Override
	public List<RequirementBean> getRecommendations(String email) {
		
		List<RequirementBean> recomend=new <RequirementBean>ArrayList();
		String sql="select * from req_table where jtype=? and skills=? and location=? and salary>=?";
		
		try {
			Connection conn=null;
			
			conn=getConnected();
			
			PreparedStatement stm=conn.prepareStatement(sql);

			ProfileBean profile=getProfile(email);
			stm.setString(1,profile.getRole());
			stm.setString(2,profile.getSkill());
			stm.setString(3,profile.getLocation());
			stm.setDouble(4 ,profile.getExpSal());
			// TODO Auto-generated method stub
			
			ResultSet rs=stm.executeQuery();
			
			while(rs.next()) {
				
				RequirementBean req=new RequirementBean();
				
				req.setType(rs.getString(3));
				req.setSkill(rs.getString(7));
				req.setLocation(rs.getString(6));
				req.setSalary(rs.getLong(5));
				req.setId(rs.getInt(1));
				req.setCompany(rs.getString(2));
				
				recomend.add(req);
			}
			
			return recomend;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}


	@Override
	public List<RequirementBean> searchJob(String skill) {
		
		List<RequirementBean> results=new <RequirementBean>ArrayList();
		String sql="select * from req_table where skills=?";
		
		
		
		try {
			Connection conn=null;
			
			conn=getConnected();
			
			PreparedStatement stm=conn.prepareStatement(sql);

			
			stm.setString(1,skill);
			
			ResultSet rs=stm.executeQuery();
			
			while(rs.next()) {
				
				RequirementBean req=new RequirementBean();
				
				req.setType(rs.getString(3));
				req.setSkill(rs.getString(7));
				req.setLocation(rs.getString(6));
				req.setSalary(rs.getLong(5));
				req.setId(rs.getInt(1));
				req.setCompany(rs.getString(2));
				
				results.add(req);
			}
			
			return results;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}


	@Override
	public boolean jobStatus(JobBean job) {
		// TODO Auto-generated method stub
		String sal="select * from job where jobid=? and email=?";
		Connection conn=null;
		
		try {
			conn=getConnected();
			PreparedStatement pstmt=conn.prepareStatement(sal);
			pstmt.setString(2,job.getEmail());
			pstmt.setInt(1,job.getJobId());
			
			ResultSet rs =pstmt.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}


	@Override
	public void saveJob(JobBean job) {
		// TODO Auto-generated method stub
		
		String sql="insert into job values (?,?,?)";
		Connection conn=null;

				
		try {
						
			conn=getConnected();
			
			PreparedStatement stm=conn.prepareStatement(sql);
			
			stm.setInt(2,job.getJobId());
			stm.setString(1, job.getEmail());
			stm.setString(3, job.getStatus());
			
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
