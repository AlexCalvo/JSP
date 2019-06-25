<%-- 
    Document   : actores
    Created on : 22-jun-2019, 14:07:04
    Author     : Hp
--%>

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
        %>
        <h1>Actores que han participado en peliculas de esas categorias</h1>
        
        <%
            for(Actor a : listaActores){
        %>
        Nombre:<%=a.getFirstName()%>
        Apellido:<%=a.getLastName()%><br/>
        <%
            }
        %>
    </body>
</html>
