package hacker.partie.controller;

import hacker.partie.model.Favourite;
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
import javax.servlet.http.HttpSession;

@WebServlet("/top10")
public class Top10 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {

        FavouriteDao favouriteDao = new FavouriteDao();
        List<Favourite> listAll = favouriteDao.top10();

        request.setAttribute("listAll", listAll);

        RequestDispatcher dispatcher = request
            .getRequestDispatcher("top10.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {

   
            // return the random as default
            String subject = request.getParameter("subject");
            String verb = request.getParameter("verb");
            String complement = request.getParameter("complement");
            ThreePartSentence previousRandom = new ThreePartSentence(subject, verb, complement);
            request.setAttribute("randomJunk", previousRandom);
            
            // save the random is it is not an abuse
            Boolean validVote = isValidVote(request, previousRandom);
            request.setAttribute("validVote", validVote);

            RequestDispatcher dispatcher = request.getRequestDispatcher("random.jsp");
            dispatcher.forward(request, response);
            
            // response.sendRedirect("titelblatt");
    }
    
    private boolean isValidVote(HttpServletRequest request, ThreePartSentence sentence ) {
        
        HttpSession session = request.getSession();
        int votes;
        
        if (session.getAttribute("votes") == null) 
            votes = 0;
        else 
            votes = (int)session.getAttribute("votes");

        if (votes > 5 )
            return false;
        else {
            Favourite favourite = new Favourite(sentence, 0);
            FavouriteDao favouriteDao = new FavouriteDao();
            favouriteDao.insertOrUpdate(favourite);
            votes +=1;
            session.setAttribute("votes", votes);
            return  true;
        }
    }
}
