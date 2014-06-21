package hacker.partie.controller;

import hacker.partie.model.Sentence;
import hacker.partie.services.SentenceDao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("add.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override	
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				
		String subject = request.getParameter("subject");
		String verb = request.getParameter("verb");
		String complement = request.getParameter("complement");
		
		if (validateInput(subject, verb, complement) == true) {
			Sentence sentence = new Sentence(subject, verb, complement);
			SentenceDao.save(sentence);
			response.sendRedirect("/listall");
		}
		else
			response.sendRedirect("/add");
	}
	
	private boolean validateInput(String subject, String verb, String complement) {						
		
		if (subject.trim().length() == 0 || verb.trim().length() == 0 || complement.trim().length() == 0) 
			return false;			
		else
			return true;
	}

}
