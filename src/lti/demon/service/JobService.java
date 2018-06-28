package lti.demon.service;

import java.util.List;

import lti.demon.bean.JobBean;
import lti.demon.bean.LoginBean;
import lti.demon.bean.ProfileBean;
import lti.demon.bean.RegisterBean;
import lti.demon.bean.RequirementBean;

public interface JobService {
	
	
	String authenticate(LoginBean login);
	
	boolean persist(RegisterBean user,ProfileBean profile);
	
	ProfileBean getProfile(String email);

	List<RequirementBean> getRecommendations(String email);
	
	List<RequirementBean> searchJob(String skill);
	
	boolean applyJob(JobBean job);
	
}
