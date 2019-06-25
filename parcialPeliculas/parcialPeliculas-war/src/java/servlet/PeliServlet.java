/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ActorFacade;
import dao.CategoryFacade;
import dao.FilmFacade;
import dao.LanguageFacade;
import dao.RatingFacade;
import entity.Actor;
import entity.Category;
import entity.Film;
import entity.Language;
import entity.Rating;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
@WebServlet(name = "PeliServlet", urlPatterns = {"/PeliServlet"})
public class PeliServlet extends HttpServlet {

    @EJB private FilmFacade filmFacade;
    @EJB private ActorFacade actorFacade;
    @EJB private CategoryFacade categoryFacade;
    @EJB private RatingFacade ratingFacade;
    @EJB private LanguageFacade languageFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String strId = request.getParameter("fId");
        Integer id = new Integer(strId);
        Film f = this.filmFacade.buscarPorId(id);
        request.setAttribute("film", f);
        
        List<Actor> listaActores = this.actorFacade.findAll();
         List<Category> listaCategorias = this.categoryFacade.findAll();
         List<Language> listaLenguages = this.languageFacade.findAll();
         List<Rating> listaRating = this.ratingFacade.findAll();
            
         request.setAttribute("listaActores", listaActores);
         request.setAttribute("listaCategorias", listaCategorias);
         request.setAttribute("listaLanguages", listaLenguages);
         request.setAttribute("listaRating", listaRating);
        
        RequestDispatcher rd = request.getRequestDispatcher("editpelicula.jsp");
        rd.forward(request, response);
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
