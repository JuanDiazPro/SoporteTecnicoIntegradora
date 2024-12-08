<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.Queue" %>
<%@ page import="mx.edu.utez.tricks.Problema" %>
<%@ page import="mx.edu.utez.tricks.dao.ProblemaDAO" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Problemas Pendientes</title>
</head>
<body>
<h1>Problemas Pendientes</h1>

<%
  Queue<Problema> problemas = ProblemaDAO.getInstance().obtenerColaProblemas();
%>

<% if (!problemas.isEmpty()) { %>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Tipo</th>
    <th>Descripción</th>
    <th>Acción</th>
  </tr>
  <% for (Problema problema : problemas) { %>
  <tr>
    <td><%= problema.getId() %></td>
    <td><%= problema.getTipo() %></td>
    <td><%= problema.getDescripcion() %></td>
    <td>
      <a href="ResolverProblemaServlet">Resolver</a>
    </td>
  </tr>
  <% } %>
</table>
<% } else { %>
<p>No hay problemas pendientes.</p>
<% } %>
</body>
</html>