<%-- 
    Document   : medicion
    Created on : 23-jun-2019, 15:20:13
    Author     : Hp
--%>

<%@page import="entity.Clientes"%>
<%@page import="entity.Mediciones"%>
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
          List<Mediciones> listaMediciones = (List)request.getAttribute("listaMediciones");
          Clientes c = (Clientes)request.getAttribute("cliente");
        %>    
        <h1>Lista Mediciones</h1>
       
        <table border="1">
            <tr>
                <th>FechaHora</th>
                <th>KW</th>
            </tr>
            <%
                for(Mediciones m : listaMediciones){
            %> 
            <tr>
                <td><%= m.getFechahora() %></td>
                <td><%= m.getKw() %></td>
            </tr>
            <%
                }
            %>
        </table>
            <a href="CrearMedicionServlet?id=<%= c.getCodigo() %>">Anadir medicion</a>
    </body>  
</html>
