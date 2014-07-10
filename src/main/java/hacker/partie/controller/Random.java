package hacker.partie.controller;

import hacker.partie.model.Messages;
import hacker.partie.model.SvcSentence;
import hacker.partie.services.SvcSentenceDao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/titelblatt"})
public class Random extends HttpServlet {

	private static final long serialVersionUID = 1L;
	boolean hasAlreadyBeenLoaded;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

		// we look for a boolean called hasAlreadyBeenLoaded in the session
		// if present it means we don't have to display the welcome message			
		HttpSession session = request.getSession();
			
		if (session.getAttribute("hasAlreadyBeenLoaded") == null) {			
			request.setAttribute("welcomeMessage", Messages.WELCOME);			 
			hasAlreadyBeenLoaded = true;
			session.setAttribute("hasAlreadyBeenLoaded", hasAlreadyBeenLoaded);
		}
		
		SvcSentence sentence = SvcSentenceDao.createRandom();
		request.setAttribute("randomJunk", sentence);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("random.jsp");
		dispatcher.forward(request, response);
		
	}

}
