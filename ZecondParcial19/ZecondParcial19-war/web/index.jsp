<%-- 
    Document   : index
    Created on : 24-jun-2019, 19:23:00
    Author     : Hp
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Employees"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista Empleados</h1>
        <%
            List<Employees> listaEmpleados = (List)request.getAttribute("listaEmpleados");
            String filtro = (String)request.getAttribute("filtro");
            
        %>
        
        <form action="IndexServlet">
        Filtro:<input type="text" name="filtro" value="<%=filtro%>">
        <input type="submit" value="Filtrar">
        
        
        <table border="1">
            <tr>
                <th>number</th>
                <th>nombre</th>
                <th>apellido</th>
                <th>extension</th>
                <th>email</th>
                <th>officeCode</th>
                <th>reportsTo</th>
                <th>jobTitle</th>
                <th></th>
            </tr>
            <%
               for(Employees e : listaEmpleados){ 
                    Employees jefe = e.getReportsto();
            %>
            <tr>
                <td><%= e.getEmployeenumber() %></td>
                <td><%= e.getFirstname() %></td>
                <td><%= e.getLastname() %></td>
                <td><%= e.getExtension() %></td>
                <td><%= e.getEmail() %></td>
                <td><%= e.getOfficecode().getOfficecode() %></td>
                <td><%= jefe %></td>
                <td><%= e.getJobtitle() %></td>
                <td><a href="EmpleadoServlet?eId=<%= e.getEmployeenumber() %>">Editar</a></td>
            </tr>
            <%
                }
            %>
        </table>
        </form>
    </body>
</html>
