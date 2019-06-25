<%-- 
    Document   : editar
    Created on : 24-jun-2019, 20:14:35
    Author     : Hp
--%>

<%@page import="entity.Offices"%>
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
        <h1>Editar datos del empleado</h1>
        <%
            Employees e = (Employees)request.getAttribute("e");
            List<Employees> listaEmpleados = (List)request.getAttribute("listaEmpleados");
            List<Offices> listaOffices = (List)request.getAttribute("listaOffices");
        %>
        <form action="EditarServlet">
            numero:<input type="number" name="numero" value="<%= e.getEmployeenumber() %>" disabled><br/>
        nombre:<input type="text" name="nombre" value="<%= e.getFirstname() %>"><br/>
        apellido:<input type="text" name="apellido" value="<%= e.getLastname() %>"><br/>
        extension:<input type="text" name="extension" value="<%= e.getExtension() %>"><br/>
        email:<input type="text" name="email" value="<%= e.getEmail() %>"><br/>
        jobTitle:<input type="text" name="jobtitle" value="<%= e.getJobtitle() %>"><br/>
        
        officeCode:<select name="oficina">
            <!--<option>Actual:<%= e.getOfficecode().getCity() %></option>-->
            <%
                for(Offices o : listaOffices){
            %>
            <option name="oficina" value="<%= o.getOfficecode() %>"><%= o.getCity() %></option>
            <%
                }
            %>
        </select>
        
        reportsTo:<select name="jefe">
            <!--<option>Actual:<%= e.getReportsto().getLastname() %></option>-->
            <%
                for(Employees jefe : listaEmpleados){
            %>
            <option name="jefe" value="<%= jefe.getEmployeenumber() %>"><%= jefe.getLastname() %></option>
            <%
                }
            %>
        </select>
        <input hidden="true" name="numero" value="<%= e.getEmployeenumber() %>">
        <input type="submit" value="Editar">
    </form>
        
    </body>
</html>
