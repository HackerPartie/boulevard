package hacker.partie.user.servlet;

import hacker.partie.user.dao.CrudUserDao;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

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

        CrudUserDao crudUserDao = new CrudUserDao();
        boolean cu = crudUserDao.doRegister(username, encryptedPassword);

        if (cu == true) {
            //response.sendRedirect("login");
            request.setAttribute("message", "yepp, you did it!! Now login!!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("sign_in.jsp");
            dispatcher.forward(request,response);
        } else {
            request.setAttribute("error", "maybe this username is already in use a long time ago");
            RequestDispatcher dispatcher = request.getRequestDispatcher("sign_up.jsp");
            dispatcher.forward(request,response);
        }

    }
}