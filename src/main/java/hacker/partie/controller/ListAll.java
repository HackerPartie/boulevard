package hacker.partie.controller;

import hacker.partie.model.SvcSentence;
import hacker.partie.services.SvcSentenceDaoImpl;

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
		
		List<SvcSentence> listAll = SvcSentenceDaoImpl.findAll();
		request.setAttribute("listAll", listAll);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("listall.jsp");
		dispatcher.forward(request, response);				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));		
		SvcSentenceDaoImpl.delete(id);
		
		doGet(req, resp);			
	}
}
