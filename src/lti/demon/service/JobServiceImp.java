package lti.demon.service;

import java.util.List;

import lti.demon.bean.JobBean;
import lti.demon.bean.LoginBean;
import lti.demon.bean.ProfileBean;
import lti.demon.bean.RegisterBean;
import lti.demon.bean.RequirementBean;
import lti.demon.dao.JobDao;
import lti.demon.dao.JobDaoJdbcImp;

public class JobServiceImp implements JobService {
	
	private static JobService service;
	
	public static JobService getService() {
		if(service==null)
			service=new JobServiceImp();
		return service;
	}
	
	
	private JobDao dao=JobDaoJdbcImp.getDao();
	
	

	@Override
	public String authenticate(LoginBean login) {
		
		
		String name=dao.Validate(login);
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean persist(RegisterBean user,ProfileBean profile) {
		
		boolean save=dao.save(user, profile);
		return save;
	}

	@Override
	public ProfileBean getProfile(String email) {
		// TODO Auto-generated method stub
		ProfileBean profile=dao.getProfile(email);
		return profile;
	}

	@Override
	public List<RequirementBean> getRecommendations(String email) {
		// TODO Auto-generated method stub
		
		return dao.getRecommendations(email);
	}

	@Override
	public List<RequirementBean> searchJob(String skill) {
		// TODO Auto-generated method stub
		return dao.searchJob(skill);
	}

	@Override
	public boolean applyJob(JobBean job) {
		// TODO Auto-generated method stub
		if(dao.jobStatus(job))
		{
			return false;
		}
		else {
			dao.saveJob(job);
			return true;
		}
		
		
	}

}
