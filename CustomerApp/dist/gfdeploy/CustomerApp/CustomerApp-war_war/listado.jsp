<%-- 
    Document   : listado.jsp
    Created on : 18-mar-2019, 12:11:01
    Author     : guzman
--%>

<%@page import="customerapp.entity.MicroMarket"%>
<%@page import="customerapp.entity.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<Customer> clientes = (List)request.getAttribute("listaClientes");
    List<MicroMarket> supermercados = (List)session.getAttribute("listaSupermercados");
    String zip = request.getParameter("supermercado");
    String name = request.getParameter("patron");
    if (name == null) name = "";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Clientes</h1>
        
        <form action="CustomerServlet">
        Supermercado: 
        <select name="supermercado">
            <option name="supermercado" value="" >
                -- Todos --
            </option>            
            <% 
                for (MicroMarket mm: supermercados) {
                    String str = "";
                    if (mm.getZipCode().equals(zip)) {
                        str = "selected";
                    }                    
            %>
            <option name="supermercado" value="<%= mm.getZipCode() %>" <%= str %>  >
                <%= mm.getZipCode() %>
            </option>
            <%
                }
            %>
        </select> 
        <input type="text" name="nombre" value="<%= name %>" />
        <input type="submit" value="Filtrar" />
            
        </form>
        <table border="1">
            <tr>
            <th>
                NOMBRE
            </th>
            <th>
                EMAIL
            </th>
            <th>
                CIUDAD
            </th>
            <th>
                TELEFONO
            </th>           
            <th>
                SUPERMERCADO
            </th>            
            <th>
                TIPO DESCUENTO
            </th>            
            
            <th>
            </th>            
            <th>
            </th>            
            <th>
            </th>            
            
            </tr>
            <%
                for (Customer cliente: clientes) {                
           %> 
           <tr>
           <td>
           <%= cliente.getName() %>
           </td>
           <td>
           <%= cliente.getEmail() %>
           </td>
           <td>
           <%= cliente.getCity() %>
           </td>
           <td>
           <%= cliente.getPhone() %>
           </td>
           <td>
           <%= cliente.getZip().getZipCode() %>
           </td>
           <td>
           <%= cliente.getDiscountCode().getDiscountCode() %>
           </td>
           
           <td>
               <a href="CustomerEditarServlet?id=<%= cliente.getCustomerId() %>">Editar</a>
           </td>
           <td>
               <a href="CustomerBorrarServlet?id=<%= cliente.getCustomerId() %>">Borrar</a>
           </td>
           <td>
               <a href="PedidosServlet?id=<%= cliente.getCustomerId() %>">Ver pedidos</a>
           </td>
           
           </tr>     
           <%
               }
           %>
        </table>
        <a href="cliente.jsp">Nuevo cliente ...</a>
        
    </body>
</html>
