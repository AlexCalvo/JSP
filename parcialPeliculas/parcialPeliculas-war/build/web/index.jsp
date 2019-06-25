<%-- 
    Document   : index
    Created on : 22-jun-2019, 11:14:52
    Author     : Hp
--%>

<%@page import="entity.Category"%>
<%@page import="entity.Film"%>
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
            List<Film> listaPeliculas = (List)request.getAttribute("listaPeliculas");
            List<Category> listaCategorias = (List)request.getAttribute("listaCategorias");
            String patron = request.getParameter("patron");
        %>
        <h2>Filtrar por categoria</h2>
        <form action="ActoresServlet">
            <%
                for(Category c : listaCategorias){
                    
            %>
            <input type="checkbox" name="categoria" value="<%= c.getCategoryId() %>"><%= c.getName() %><br/>
            <%
                }
            %>
            <input type="submit" value="Filtrar">
        </form>
        <h1>Lista de peliculas</h1>
        
        <a href="servlet">Nueva Pelicula</a>
        
       
               
        <form action="IndexServlet">
        <input type="text" name="patron" value="<%=patron%>" />
        <input type="submit" value="Filtrar"/>
        
        <table border="1">
            <tr>
                <th>id</th>
                <th>title</th>
                <th>description</th>
                <th></th>
                <th></th>
            </tr>
            <%
                for(Film f : listaPeliculas){
            %>
            <tr>
                <td><%= f.getFilmId() %></td>
                <td><%=f.getTitle() %></td>
                <td><%=f.getDescription() %></td>
                <td><a href="EliminarServlet?fId=<%=f.getFilmId()%>">Eliminar</td>
                <td><a href="PeliServlet?fId=<%= f.getFilmId() %>">Editar</td>
            </tr>
            <%
                }
            %>
        </table>
    </form>
    </body>
</html>
