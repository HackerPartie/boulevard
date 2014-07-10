package hacker.partie.controller;

import hacker.partie.services.UserDao;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

// @WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("sign_up.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PasswordService passwordService = new DefaultPasswordService();
        String encryptedPassword = passwordService.encryptPassword(password);

        UserDao crudUserDao = new UserDao();

        if (crudUserDao.doRegister(username, encryptedPassword) == true) {
            //response.sendRedirect("login");
            request.setAttribute("message", "yepp, you did it!! Now login!!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("sign_in.jsp");
            dispatcher.forward(request,response);
        } else {
            request.setAttribute("error", "maybe this username is already in use");
            RequestDispatcher dispatcher = request.getRequestDispatcher("sign_up.jsp");
            dispatcher.forward(request,response);
        }

    }
}
