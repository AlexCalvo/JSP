/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ActorFacade;
import dao.CategoryFacade;
import dao.FilmFacade;
import entity.Film;
import entity.Language;
import entity.Rating;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditarServlet", urlPatterns = {"/EditarServlet"})
public class EditarServlet extends HttpServlet {

    @EJB private FilmFacade filmFacade; 
    @EJB private ActorFacade actorFacade;
    @EJB private CategoryFacade categoryFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String strId = request.getParameter("id");
        Film f = this.filmFacade.buscarPorId(new Integer(strId));
        
        String titulo = request.getParameter("title");
        String descripcion = request.getParameter("description");
        String releaseYear = request.getParameter("releaseYear");
        String rentalDuration = request.getParameter("rentalDuration");
        String rentalRate = request.getParameter("rentalRate");
        String fLength = request.getParameter("fLength");
        String replacementCost = request.getParameter("replacementCost");
        String specialFeatures = request.getParameter("specialFeatures");
        String actor = request.getParameter("actor");
        String categoria = request.getParameter("categoria");
        String language = request.getParameter("language");
        String rating = request.getParameter("rating");
        
        
        Short rentalD = Short.parseShort(rentalDuration);
        Short fL = Short.parseShort(fLength);
        
        
        f.setDescription(descripcion);
        f.setFLength(fL);
        f.setTitle(titulo);
        f.setReleaseYear(new Integer(releaseYear));
        f.setRentalDuration(rentalD);
        f.setRentalRate(rentalRate);
        f.setReplacementCost(replacementCost);
        f.setSpecialFeatures(specialFeatures);
        
        //Lineas comentadas porque los find no funcionan
//        List<Actor> actorList = new ArrayList<>();
//        Actor a = this.actorFacade.find(new Integer(actor));
//        actorList.add(a);
//        f.setActorList(actorList);
//        
//        List<Category> categoryList = new ArrayList<>();
//        Category c = this.categoryFacade.find(new Integer(categoria));
//        categoryList.add(c);
//        f.setCategoryList(categoryList);
        
        Language languageId = new Language(new Short(language));
        f.setLanguageId(languageId);
        
        Rating ratingId = new Rating(new Short(rating));
        f.setRatingId(ratingId);
        
        //...
        this.filmFacade.edit(f);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("IndexServlet");
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
