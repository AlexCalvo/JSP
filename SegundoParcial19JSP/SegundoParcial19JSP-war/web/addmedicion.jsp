<%-- 
    Document   : addmedicion
    Created on : 23-jun-2019, 15:33:11
    Author     : Hp
--%>

<%@page import="entity.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Clientes c = (Clientes)request.getAttribute("cliente");
        %>
        <h1>Introduce el valor de la medicion</h1>
        <form action="SaveMedicionServlet">
        KW:<input type="number" name="kw">
        <input hidden="true" name="cliente" value="<%= c.getCodigo() %>">
        <input type="submit" value="add">
        </form>
    </body>
</html>
