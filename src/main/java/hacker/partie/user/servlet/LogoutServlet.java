package hacker.partie.user.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(user)) {
					cookie.setMaxAge(0);
					cookie.setValue(null);
					response.addCookie(cookie);
				}
			}
		}
		session.setAttribute("user", null);
		session.invalidate();

		response.sendRedirect("/random");
	}

}
