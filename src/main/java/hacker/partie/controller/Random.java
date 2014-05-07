package hacker.partie.controller;

import hacker.partie.model.Sentence;
import hacker.partie.model.SentenceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/random")
public class Random extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Sentence sentence = SentenceDB.createRandom();

        Sentence sentence;
        SentenceDB sent = new SentenceDB();
        sentence = sent.createSent();

		request.setAttribute("randomJunk", sentence);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

}
