package hacker.partie.controller;

import hacker.partie.services.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// super.doGet(request, response);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("sign_in.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// super.doPost(request, response);

		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession(true);
		String sessionId = session.getId();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao crudUserDao = new UserDao();
		
		if (crudUserDao.doLogin(username, password) == true) {
			session.setAttribute("user", username);
			Cookie cookie = new Cookie(username, sessionId);
			response.addCookie(cookie);
			response.sendRedirect("/random");
		} else {
			request.setAttribute("error", "username or password is wrong");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("sign_in.jsp");
			dispatcher.forward(request, response);
		}
	}
}
