<%-- 
    Document   : index
    Created on : 24-jun-2019, 11:06:44
    Author     : Hp
--%>

<%@page import="entity.Customers"%>
<%@page import="entity.Orders"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista pedidos</h1>
        <%
            List<Orders> listaOrders = (List)request.getAttribute("listaOrders");
        %>
    </body>
    
    <table border="1">
        <tr>
            <th>orderNumber</th>
            <th>orderDate</th>
            <th>requiredDate</th>
            <th>shippedDate</th>
            <th>status</th>
            <th>comments</th>
            <th>customerNumber</th>
            <th>customerName</th>
            <th>city</th>
            <th></th>
        </tr>
        <%
           for(Orders o : listaOrders){ 
                Customers c = o.getCustomernumber();
        %>
        <tr>
            <td><%= o.getOrdernumber() %></td>
            <td><%= o.getOrderdate() %></td>
            <td><%= o.getRequireddate() %></td>
            <td><%= o.getShippeddate() %></td>
            <td><%= o.getStatus() %></td>
            <td><%= o.getComments() %></td>
            <td><%= c.getCustomernumber() %></td>
            <td><%= c.getCustomername() %></td>
            <td><%= c.getCity() %></td>
            <td><a href="PedidoServlet?oId=<%= o.getOrdernumber() %>">Editar</a></td>
        </tr>
        <%
            }
        %>
    </table>
        
</html>
