<%-- 
    Document   : editCliente
    Created on : 23-jun-2019, 16:09:11
    Author     : Hp
--%>

<%@page import="entity.Poblaciones"%>
<%@page import="entity.Provincias"%>
<%@page import="entity.Callespoblaciones"%>
<%@page import="java.util.List"%>
<%@page import="entity.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar datos del Cliente</h1>
        <%
            Clientes cliente = (Clientes)request.getAttribute("cliente");
            List<Callespoblaciones> listaCalles = (List)request.getAttribute("calles");
            List<Provincias> listaProvincias =(List)request.getAttribute("provincias");
            List<Poblaciones> listaPoblaciones = (List)request.getAttribute("poblaciones");
        %>
        <form action="SaveClienteServlet">
            
            Codigo:<input type="number" name="codigo" value="<%= cliente.getCodigo() %>" disabled><br/>
            Nombre:<input type="text" name="nombre" value="<%= cliente.getNombre() %>"><br/>
            Apellido:<input type="text" name="apellido" value="<%= cliente.getApellido() %>"><br/>
            Apellido2:<input type="text" name="apellido2" value="<%= cliente.getApellido2() %>"><br/>
            Numero:<input type="number" name="numero" value="<%= cliente.getNumero() %>"><br/>
            Piso:<input type="number" name="piso" value="<%= cliente.getPiso() %>"><br/>
            Metros:<input type="number" name="metros" value="<%= cliente.getMetros() %>"><br/>
            
            Calle:<select name="calle">
                <option>Actual:<%= cliente.getCalle().getNombre() %></option>
                <%
                  for(Callespoblaciones c : listaCalles){  
                %>
                <option name="calle" value="<%= c.getIdcalle() %>"><%= c.getNombre() %>
                <%
                  } 
                %>
            </select><br/>
            
            CodigoProvincia:<select name="provincia">
                 <%
                  for(Provincias p : listaProvincias){  
                %>
                <option name="provincia" value="<%= p.getCodigoprovincia() %>"><%= p.getProvincia() %>
                 <%
                  }
                %>
                
            </select><br/>
            
            CodigoPoblacion:<select name="poblacion">
                <%
                  for(Poblaciones po : listaPoblaciones){  
                %>
                <option name="poblacion" value="<%= po.getCodigopoblacion() %>"><%= po.getPoblacion() %>
                 <%
                  }
                %> 
            </select><br/>
            <input hidden="true" name="codigo" value="<%= cliente.getCodigo() %>">
            <input type="submit" value="editar"><br/>
            
        </form>
    </body>
</html>
