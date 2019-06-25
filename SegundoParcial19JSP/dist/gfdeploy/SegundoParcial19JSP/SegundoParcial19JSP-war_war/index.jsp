<%-- 
    Document   : index
    Created on : 23-jun-2019, 13:10:21
    Author     : Hp
--%>

<%@page import="entity.Provincias"%>
<%@page import="entity.Clientes"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Clientes</h1>
    </body>
    <%
        List<Clientes> listaClientes = (List)request.getAttribute("listaClientes");
        List<Provincias> listaProvincias = (List)request.getAttribute("listaProvincias");
    %>
    
    <form action="IndexServlet">
        <select name="provincia">
            <option name="provincia" value="">
                -- Todos --
            </option> 
        <%
            for(Provincias p : listaProvincias){
        %>
        <option name="provincia" value="<%= p.getCodigoprovincia() %>"><%= p.getProvincia() %></option>
        <%
            }
        %>
        </select>
        <input type="submit" value="filtrar">
    </form>
    
    <h1>Listado Clientes</h1>
    <table border ="1">
        <tr>
            <th>Codigo</th>
            <th>Apellido1</th>
            <th>Apellido2</th>
            <th>Nombre</th>
            <th>NombrePoblacion</th>
            <th>NombreProvincia</th>
            <th></th>
            <th></th>
                
        </tr>
        <% 
            for(Clientes c : listaClientes){
        %>
        <tr>
            <td><%= c.getCodigo() %></td>
            <td><%= c.getApellido() %></td>
            <td><%= c.getApellido2() %></td>
            <td><%= c.getNombre() %></td>
            <td><%= c.getCodigopoblacion().getPoblacion() %></td>
            <td><%= c.getCodigoprovincia().getProvincia() %></td>
            <td><a href="AddMedicionServlet?cId=<%= c.getCodigo() %>"><button>Add medicion</button></a></td>
            <td><a href="EditarClienteServlet?cId=<%= c.getCodigo() %>"><button>Editar Cliente</button></a></td>
        </tr>
        <% 
            }
        %>
    </table>
    
</html>
