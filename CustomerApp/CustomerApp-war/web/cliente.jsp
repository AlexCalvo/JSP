<%-- 
    Document   : cliente
    Created on : 25-mar-2019, 12:05:25
    Author     : guzman
--%>

<%@page import="customerapp.entity.DiscountCode"%>
<%@page import="java.util.List"%>
<%@page import="customerapp.entity.MicroMarket"%>
<%@page import="customerapp.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    boolean esEditar = true;
    Customer cliente = (Customer)request.getAttribute("cliente");
    if (cliente == null) { // Esta situación se da cuando se trata de crear un nuevo cliente
        cliente = new Customer();
        esEditar = false;
    }
    
    String strCustomerid = "", strName = "", strDomicilio1 = "", strDomicilio2 = "";
    String strCiudad = "", strEstado = "", strTelefono = "", strFax = "", strEmail = "";
    String strLimite = "";
    
    if (esEditar) {
        strCustomerid = cliente.getCustomerId().toString();
        strName = cliente.getName();
        strDomicilio1 = cliente.getAddressline1();
        strDomicilio2 = cliente.getAddressline2();
        strCiudad = cliente.getCity();
        strEstado = cliente.getState();
        strTelefono = cliente.getPhone();
        strFax = cliente.getFax();
        strEmail = cliente.getEmail();
        strLimite = cliente.getCreditLimit().toString();
    }
    
    List<MicroMarket> supermercados = (List)session.getAttribute("listaSupermercados");    
    List<DiscountCode> descuentos = (List)session.getAttribute("listaDescuentos");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar cliente</title>
    </head>
    <body>
        <h1>Editar cliente</h1>
        <form action="CustomerGuardarServlet" method="post">
            <input type="hidden" name="id" value="<%= strCustomerid %>" /> <br/>
            Nombre: <input name="nombre" value="<%= strName %>" size="30" maxlength="30" /> <br/>
            Address: <input name="domicilio1" value="<%= strDomicilio1 %>" size="30" maxlength="30" /> 
                     <input name="domicilio2" value="<%= strDomicilio2 %>" size="30" maxlength="30" /><br/>            
            Ciudad: <input name="ciudad" value="<%= strCiudad %>" size="25" maxlength="25" /> <br/>
            Estado: <input name="estado" value="<%= strEstado %>" size="2" maxlength="2" /> <br/>            
            Telefono: <input name="telefono" value="<%= strTelefono %>" size="12" maxlength="12"/> <br/>            
            Fax: <input name="fax" value="<%= strFax %>" size="12" maxlength="12" /> <br/>
            Email: <input name="email" value="<%= strEmail %>" size="40" maxlength="40"/> <br/>            
            Limite de credito: <input name="credito" value="<%= strLimite %>" /> <br/>   
            Supermercado: 
        <select name="mercado">
            <% 
                for (MicroMarket mm: supermercados) {
                    String str = "";
                    if (esEditar && mm.getZipCode().equals(cliente.getZip().getZipCode())) {
                        str = "selected";
                    }                    
            %>
            <option value="<%= mm.getZipCode() %>" <%= str %>  >
                <%= mm.getZipCode() %>
            </option>
            <%
                }
            %>
        </select> <br/>
        Tipo descuento:
        <select name="descuento">
            <% 
                for (DiscountCode dc: descuentos) {
                    String str = "";
                    if (esEditar && dc.getDiscountCode().equals(cliente.getDiscountCode().getDiscountCode())) {
                        str = "selected";
                    }                    
            %>
            <option value="<%= dc.getDiscountCode() %>" <%= str %>  >
                <%= dc.getRate() %>
            </option>
            <%
                }
            %>
        </select> <br/>
            <br/>
            <input type="submit" value="Guardar" />
        </form>
    </body>
</html>
