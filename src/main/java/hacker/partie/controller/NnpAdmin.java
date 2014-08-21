package hacker.partie.controller;

import hacker.partie.model.ThreePartSentence;
import hacker.partie.services.NnpSentenceDao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/private/nnpadmin")
public class NnpAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	    NnpSentenceDao nnpSentenceDao = new NnpSentenceDao();
		List<ThreePartSentence> listAll = nnpSentenceDao.findAll();
		request.setAttribute("listAll", listAll);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("nnpadmin.jsp");
		dispatcher.forward(request, response);				
	}
	
	   @Override   
	    protected void doPost (HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	                
	        String subject = request.getParameter("subject");
	        String verb = request.getParameter("verb");
	        String complement = request.getParameter("complement");
	        
	        if (validateInput(subject, verb, complement) == true) {
	            ThreePartSentence sentence = new ThreePartSentence(subject, verb, complement);
	            NnpSentenceDao nnpSentenceDao = new NnpSentenceDao();
	            nnpSentenceDao.save(sentence);
	            resetFactory();
	            
	        }
	            response.sendRedirect("nnpadmin");
	    }   
	    private boolean validateInput(String subject, String verb, String complement) {                     
	        
	        if (subject.trim().length() == 0 || verb.trim().length() == 0 || complement.trim().length() == 0) 
	            return false;           
	        else
	            return true;
	    }
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		NnpSentenceDao nnpSentenceDao = new NnpSentenceDao();
		nnpSentenceDao.delete(id);
		resetFactory();
		
		// no need for forward or redirect here, we came here via  an ajax call
	}
	
	   private void resetFactory() {
	        getServletContext().setAttribute("factory", null);
	    }
}
