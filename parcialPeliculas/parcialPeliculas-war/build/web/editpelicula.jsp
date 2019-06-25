<%-- 
    Document   : editpelicula
    Created on : 22-jun-2019, 23:13:00
    Author     : Hp
--%>

<%@page import="entity.Film"%>
<%@page import="entity.Rating"%>
<%@page import="entity.Language"%>
<%@page import="entity.Actor"%>
<%@page import="entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Pelicula</h1>
    </body>
    <%
            Film film = (Film)request.getAttribute("film");
            List<Actor> listaActores = (List)request.getAttribute("listaActores");
            List<Category> listaCategorias = (List)request.getAttribute("listaCategorias");
            List<Language> listaLenguages = (List)request.getAttribute("listaLanguages");
            List<Rating> listaRating = (List)request.getAttribute("listaRating");
            
        %>
        
        <h1>Editar pelicula</h1>
        <form action="EditarServlet">
            
        FilmId:<input type="number" name="id" value="<%= film.getFilmId() %>" disabled>
        Titulo:<input type="text" name="title" value="<%= film.getTitle() %>">
        Descripcion:<input type="text" name="description" value="<%= film.getDescription() %>">
        ReleaseYear:<input type="number" name="releaseYear" value="<%= film.getReleaseYear() %>">
        RentalDuration:<input type="number" name="rentalDuration" value="<%= film.getRentalDuration() %>">
        RentalRate:<input type="text" name="rentalRate" value="<%= film.getRentalRate() %>" >
        F_length:<input type="number" name="fLength" value="<%= film.getFLength() %>">
        ReplacementCost:<input type="text" name="replacementCost" value="<%= film.getReplacementCost() %>">
        SpecialFeatures:<input type="text" name="specialFeatures" value="<%= film.getSpecialFeatures() %>">
        
      
        
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
            <input hidden="true" name="id" value="<%= film.getFilmId()%>">
            <input type="submit" value="editar">
        </form>
</html>
