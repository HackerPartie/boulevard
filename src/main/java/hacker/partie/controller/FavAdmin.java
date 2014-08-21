package hacker.partie.controller;

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

@WebServlet("/private/favadmin")
public class FavAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	    FavouriteDao FavouriteDao = new FavouriteDao();
		List<ThreePartSentence> listAll = FavouriteDao.findAll();
		request.setAttribute("listAll", listAll);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("favadmin.jsp");
		dispatcher.forward(request, response);				
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		FavouriteDao FavouriteDao = new FavouriteDao();
		FavouriteDao.delete(id);
		
		// no need for forward or redirect here, we came here via  an ajax call
	}
	
}
