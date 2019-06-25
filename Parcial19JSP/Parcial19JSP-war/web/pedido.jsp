<%-- 
    Document   : pedido
    Created on : 24-jun-2019, 11:22:49
    Author     : Hp
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Payments"%>
<%@page import="entity.Orderdetails"%>
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
        <h1>Modificar pedido</h1>
        <%
          Orders order = (Orders)request.getAttribute("order");
          List<Orderdetails> od = (List)request.getAttribute("od");
          List<Payments> payments = (List)request.getAttribute("payments");
          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        %>
        
        <form action="EditarServlet">
        
        orderNumber:<input type="number" name="orderNumber" value="<%= order.getOrdernumber() %>" disabled><br/>
        orderDate:<input type="date" name="orderDate" value="<%= format.format(order.getOrderdate()) %>"><br/>
        requiredDate:<input type="date" name="requiredDate" value="<%= format.format(order.getRequireddate()) %>"><br/>
        shippedDate:<input type="date" name="shippedDate" value="<%= format.format(order.getShippeddate()) %>"><br/>
        status:<input type="text" name="status" value="<%= order.getStatus() %>"><br/>
        comments:<input type="text" name="comments" value="<%= order.getComments() %>"><br/>
        <input hidden="true" name="oId" value="<%= order.getOrdernumber() %>">
        <input type="submit" value="Editar">
        
        </form>
        
        <h1>OrderDetails</h1>
        <table border="1">
            <tr>
                <th>orderNumber</th>
                <th>productCode</th>
                <th>quantityOrdered</th>
                <th>priceEach</th>
                <th>orderLineNumber</th>
            </tr>
            <% 
                for(Orderdetails d : od){
            %>
            <tr>
                <td><%= d.getOrders().getOrdernumber() %></td>
                <td><%= d.getProducts().getProductcode() %></td>
                <td><%= d.getQuantityordered() %></td>
                <td><%= d.getPriceeach() %></td>
                <td><%= d.getOrderlinenumber() %></td>


            </tr>
            <% 
                }
            %>
        </table>
            <a href="OrderDetailsServlet?oId=<%=order.getOrdernumber()%>">Anadir detalle</a>
        
        <h1>Pagos</h1>
        <table border="1">
            <tr>
                <th>customerNumber</th>
                <th>checkNumber</th>
                <th>paymentDate</th>
                <th>amount</th>
            </tr>
            <%
              for(Payments p : payments){  
            %>
            <tr>
                <td><%= p.getCustomers().getCustomernumber() %></td>
                <th><%= p.getPaymentsPK().getChecknumber() %></th>
                <th><%= p.getPaymentdate() %></th>
                <th><%= p.getAmount() %></th>
            </tr>
            <%
              }
            %>
        </table>
    </body>
</html>
