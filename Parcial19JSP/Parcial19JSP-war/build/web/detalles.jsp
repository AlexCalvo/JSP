<%-- 
    Document   : detalles
    Created on : 24-jun-2019, 16:36:55
    Author     : Hp
--%>

<%@page import="entity.Products"%>
<%@page import="java.util.List"%>
<%@page import="entity.Orders"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Orders o = (Orders)request.getAttribute("order");
            List<Products> listaProductos = (List)request.getAttribute("listaProductos");
        %>
        
        <h1>Anadir detalles</h1>
        
        <form action="CrearDetallesServlet">
        orderNumber:<input type="number" name="orderNumber" value="<%= o.getOrdernumber() %>" disabled><br/>
        
        productCode:<select name="producto">
            <option>--Todos--</option>
            <%
                for(Products p : listaProductos){
            %>
            <option name="producto" value="<%= p.getProductcode() %>"><%= p.getProductname() %></option>
            <%
                }
            %>
        </select><br/>
        
        quantityOrdered:<input type="number" name="cantidad" value=""><br/>
        priceEach:<input type="number" name="precio" value=""><br/>
        orderLineNumber:<input type="text" name="oln" value=""><br/>
        <input hidden="true" name="odId" value="<%= o.getOrdernumber() %>">
        <input type="submit" value="Crear">
        </form>
    </body>
</html>
