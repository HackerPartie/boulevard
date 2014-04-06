package hacker.partie.user.servlet;

import hacker.partie.user.dao.CrudUserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sign_in.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(request, response);

        HttpSession httpSession = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        CrudUserDao crudUserDao = new CrudUserDao();
        Cookie cookie = crudUserDao.doLogin(username, password, httpSession);
        response.addCookie(cookie);
        response.sendRedirect("/sentence");

    }
}
