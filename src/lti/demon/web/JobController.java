package lti.demon.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lti.demon.bean.JobBean;
import lti.demon.bean.RequirementBean;
import lti.demon.service.JobService;
import lti.demon.service.JobServiceImp;


@WebServlet(name = "Job", urlPatterns = {"/Daemon.job" })
public class JobController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JobService service=JobServiceImp.getService();
		
		HttpSession session=request.getSession();
		
		String skill=request.getParameter("skill");
		String jobId=request.getParameter("jobid");
		String email=(String) session.getAttribute("Email");
		
		
		if(jobId!=null) {
			
			JobBean job =new JobBean();
			job.setJobId(Integer.parseInt(jobId));
			job.setEmail(email);
			job.setStatus("Applied");
			
			if(service.applyJob(job)) {
				
				response.sendRedirect("status.jsp?job=success");
				
			}else {
				response.sendRedirect("status.jsp?job=failure");
			}
			
			
			
		}
		
		else if(skill!= null) {
			
			List<RequirementBean> results=service.searchJob(skill);
			
			request.setAttribute("Results",results );
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/results.jsp");
			rd.forward(request, response);
			
		}
		
		else {
		
		
		List<RequirementBean> recomend=service.getRecommendations(email);
		
		request.setAttribute("Recommend", recomend);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/recomend.jsp");
		rd.forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
