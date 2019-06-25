<%-- 
    Document   : pedidos
    Created on : 29-abr-2019, 11:06:16
    Author     : guzman
--%>

<%@page import="java.util.List"%>
<%@page import="customerapp.entity.PurchaseOrder"%>
<%@page import="customerapp.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Customer cliente = (Customer)request.getAttribute("cliente");
    List<PurchaseOrder> listaPedidos = cliente.getPurchaseOrderList();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de pedidos del cliente</title>
                
    </head>
    <body>
        <h1>Listado de pedidos del cliente: <%= cliente.getName() %></h1>
        <%
            if (listaPedidos == null || listaPedidos.isEmpty()) {
        %>
            Este cliente no tiene pedidos
        <%        
                
            } else {
%>
            <table border="1">
                <tr>
                    <th>NUM.</th>
                    <th>FECHA</th>                    
                    <th>PRODUCTO</th>                    
                    <th>CANTIDAD</th>                                        
                </tr>
<%
                for (PurchaseOrder po: cliente.getPurchaseOrderList()) {
        %>
                <tr>
                    <td><%= po.getOrderNum() %></td>
                    <td><%= po.getSalesDate() %></td>
                    <td><%= po.getProductId().getDescription() %></td>
                    <td><%= po.getQuantity() %></td>
                </tr>
        <%
                }
%>
            </table>
<%
            }
        %>
        
    </body>
</html>
