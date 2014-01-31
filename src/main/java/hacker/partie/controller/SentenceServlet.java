package hacker.partie.controller;

import hacker.partie.model.Sentence;
import hacker.partie.model.SentenceDB;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sentence")
public class SentenceServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Sentence sentence = SentenceDB.createRandom();
		System.out.println(sentence);
		
		// this does not work in the jsp  
		request.setAttribute("boulevardTitle", sentence);
		
		// send a string to the jsp containaing our 
		String randomTitle = sentence.getObject() + " "
				+ sentence.getVerb() + " "
				+ sentence.getComplement();
		
		request.setAttribute("boulevardHeader", randomTitle);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}
	

}
