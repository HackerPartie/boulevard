package hacker.partie.services;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"/private/*"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) 
    		throws IOException, ServletException {
        
    	// by default a filter can work with any type of object, not only HTTP 
    	// so we have to cast the parameters ito HttpServlet objects to use our well know HTTP stuff
    	HttpServletRequest request = (HttpServletRequest) servletRequest;
    	HttpServletResponse response = (HttpServletResponse) servletResponse;
        
    	HttpSession session = request.getSession();
    	
    	// if we don't have a valid user in the session, redirect to startpage via HTTP 302
        if (session.getAttribute("sessionUser") == null) {
        	response.sendRedirect(request.getContextPath() + "/titelblatt");
        } else {
        	filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
