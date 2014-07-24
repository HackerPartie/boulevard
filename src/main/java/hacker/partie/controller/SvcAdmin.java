package hacker.partie.controller;

import hacker.partie.model.ThreePartSentence;
import hacker.partie.services.SvcSentenceDao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/private/svcadmin")
public class SvcAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	    SvcSentenceDao svcSentenceDao = new SvcSentenceDao();
		List<ThreePartSentence> listAll = svcSentenceDao.findAll();
		
		request.setAttribute("listAll", listAll);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("svcadmin.jsp");
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
	            SvcSentenceDao svcSentenceDao = new SvcSentenceDao();
	            svcSentenceDao.save(sentence);
	            resetFactory();
	        }
	            response.sendRedirect("svcadmin");
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
		SvcSentenceDao svcSentenceDao = new SvcSentenceDao();
		svcSentenceDao.delete(id);
		resetFactory();
		
		// no need for redirect here, we issued an ajax call
		// resp.sendRedirect("svcadmin");			
	}
	
	private void resetFactory() {
	    getServletContext().setAttribute("factory", null);
	}
}
