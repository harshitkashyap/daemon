package lti.demon.dao;

import java.util.List;

import lti.demon.bean.JobBean;
import lti.demon.bean.LoginBean;
import lti.demon.bean.ProfileBean;
import lti.demon.bean.RegisterBean;
import lti.demon.bean.RequirementBean;

public interface JobDao {
	
	
	String Validate(LoginBean login);
	
	boolean save(RegisterBean user, ProfileBean profile);
	
	ProfileBean getProfile(String email);
	
	List<RequirementBean> getRecommendations(String email);
	
	List<RequirementBean> searchJob(String skill);

	boolean jobStatus(JobBean job);

	void saveJob(JobBean job);
	
	

}
