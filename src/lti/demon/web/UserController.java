package lti.demon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lti.demon.bean.LoginBean;
import lti.demon.bean.ProfileBean;
import lti.demon.bean.RegisterBean;
import lti.demon.service.JobService;
import lti.demon.service.JobServiceImp;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/User.zs")

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String referer = request.getHeader("referer");
		JobService service = JobServiceImp.getService();

		HttpSession session = request.getSession();

		if (referer.contains("Home")) {

			// request comming from home
			LoginBean login = new LoginBean();
			login.setEmail(request.getParameter("email"));
			login.setPassword(request.getParameter("password"));

			String name = service.authenticate(login);
			if (name != null) {

				session.setAttribute("name", name);
				session.setAttribute("Email", login.getEmail());
				
				ProfileBean profile = service.getProfile(login.getEmail());
				session.setAttribute("profile", profile);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/profile.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("Home.jsp?invalid=yes");
			}
		} else if (referer.contains("register")) {
			// request

			RegisterBean register = new RegisterBean();

			register.setAge(Integer.parseInt(request.getParameter("age")));
			register.setCity(request.getParameter("city"));
			register.setEmail(request.getParameter("email"));
			register.setGender(request.getParameter("gender"));
			register.setName(request.getParameter("name"));
			register.setPassword(request.getParameter("password"));
			register.setPhone(Long.parseLong(request.getParameter("phone")));

			session.setAttribute("Register", register);

			response.sendRedirect("resume.jsp");

		} else {
			ProfileBean profile = new ProfileBean();

			profile.setEmail(request.getParameter("email"));
			profile.setExpSal(Double.parseDouble(request.getParameter("salary")));
			profile.setLocation(request.getParameter("location"));
			profile.setRole(request.getParameter("role"));
			profile.setSkill(request.getParameter("skill"));

			RegisterBean user = (RegisterBean) session.getAttribute("Register");

			if (service.persist(user, profile)) {

				session.removeAttribute("Register");
				response.sendRedirect("Home.jsp");
			} else {
				response.sendRedirect("resume.jsp");
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
