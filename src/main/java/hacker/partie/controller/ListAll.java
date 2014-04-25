package hacker.partie.controller;

import hacker.partie.model.Sentence;
import hacker.partie.model.SentenceDB;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listall")
public class ListAll extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Sentence> listAll = SentenceDB.findAll();
		Sentence sentence = SentenceDB.createRandom();
		request.setAttribute("listAll", listAll);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("listall.jsp");
		dispatcher.forward(request, response);
	}

}
