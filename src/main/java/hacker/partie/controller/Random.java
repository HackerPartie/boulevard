package hacker.partie.controller;

import hacker.partie.model.SvcSentence;
import hacker.partie.services.SvcSentenceDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns={"/", "/random"})
public class Random extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		

        SvcSentence sentence;
        SvcSentenceDao sent = new SvcSentenceDao();
        sentence = sent.createSent();

		request.setAttribute("randomJunk", sentence);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("random.jsp");
		dispatcher.forward(request, response);

	}

}
