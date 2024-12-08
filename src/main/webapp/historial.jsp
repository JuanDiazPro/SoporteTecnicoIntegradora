<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="mx.edu.utez.tricks.Problema" %>
<%@ page import="mx.edu.utez.tricks.dao.ProblemaDAO" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Historial de Problemas</title>
</head>
<body>
<h1>Historial de Problemas Resueltos</h1>

<%
  List<Problema> historial = ProblemaDAO.getInstance().obtenerHistorialProblemas();
%>

<% if (!historial.isEmpty()) { %>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Tipo</th>
    <th>Descripción</th>
  </tr>
  <% for (Problema problema : historial) { %>
  <tr>
    <td><%= problema.getId() %></td>
    <td><%= problema.getTipo() %></td>
    <td><%= problema.getDescripcion() %></td>
  </tr>
  <% } %>
</table>
<% } else { %>
<p>No hay problemas resueltos.</p>
<% } %>
</body>
</html>