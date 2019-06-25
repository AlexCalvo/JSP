<%-- 
    Document   : pelicula
    Created on : 22-jun-2019, 17:35:01
    Author     : Hp
--%>

<%@page import="entity.Rating"%>
<%@page import="entity.Language"%>
<%@page import="entity.Category"%>
<%@page import="entity.Actor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Actor> listaActores = (List)request.getAttribute("listaActores");
            List<Category> listaCategorias = (List)request.getAttribute("listaCategorias");
            List<Language> listaLenguages = (List)request.getAttribute("listaLanguages");
            List<Rating> listaRating = (List)request.getAttribute("listaRating");
            
        %>
        
        <h1>Crear pelicula</h1>
        <form action="AddServlet">
            
        FilmId:<input type="number" name="id" disabled>
        Titulo:<input type="text" name="title">
        Descripcion:<input type="text" name="description">
        ReleaseYear:<input type="number" name="releaseYear">
        RentalDuration:<input type="number" name="rentalDuration">
        RentalRate:<input type="text" name="rentalRate">
        F_length:<input type="number" name="fLength">
        ReplacementCost:<input type="text" name="replacementCost">
        SpecialFeatures:<input type="text" name="specialFeatures">
        
        ListaActores:<select name="actor">
            <%
                for(Actor a :listaActores){
            %>
            <option value="<%= a.getActorId() %>"><%= a.getFirstName() %></option>
             <%
               }
            %>
        </select>
        
        ListaCategorias:<select name="categoria">
            <%
             for(Category c: listaCategorias){  
            %>
            <option value="<%= c.getCategoryId() %>"><%= c.getName() %></option>
            <%
             }   
            %>
        </select>
        
        Languaje:<select name="language">
            <%
                for(Language l : listaLenguages){
            %>
            <option value="<%= l.getLanguageId() %>"><%= l.getName() %>
            <%
                }
            %>
        </select>
        
        Rating:<select name="rating">
            <%
                for(Rating r :listaRating){
            %>
            <option value="<%= r.getRatingId() %>"><%= r.getDescription() %></option>
            <%
                }
            %>
            
        </select>
            <input type="submit" value="crear">
        </form>
    </body>
</html>
