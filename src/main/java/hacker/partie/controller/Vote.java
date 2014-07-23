package hacker.partie.controller;

import hacker.partie.model.Favourite;
import hacker.partie.model.ThreePartSentence;
import hacker.partie.services.FavouriteDao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vote")
public class Vote extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	    FavouriteDao favouriteDao = new FavouriteDao();
		List<Favourite> listAll = favouriteDao.findFav();
		
		request.setAttribute("listAll", listAll);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("vote.jsp");
		dispatcher.forward(request, response);				
	}
	
	   @Override   
	    protected void doPost (HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	                
	        String subject = request.getParameter("subject");
	        String verb = request.getParameter("verb");
	        String complement = request.getParameter("complement");
	        
	        if (validateInput(subject, verb, complement) == true) {
	            Favourite sentence = new Favourite(new ThreePartSentence(subject, verb, complement), 0);
	            FavouriteDao favouriteDao = new FavouriteDao();
	            favouriteDao.saveFav(sentence);
	        }
	            response.sendRedirect("titelblatt");
	    }   
	    private boolean validateInput(String subject, String verb, String complement) {                     
	        
	        if (subject.trim().length() == 0 || verb.trim().length() == 0 || complement.trim().length() == 0) 
	            return false;           
	        else
	            return true;
	    }
}
