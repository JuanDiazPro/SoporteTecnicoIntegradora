<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Problema</title>
</head>
<body>
<h1>Registrar Nuevo Problema</h1>
<form action="RegistrarProblemaServlet" method="post">
    <input type="hidden" name="id" value="${idTicket}">

    <label>Tipo de Problema:</label>
    <select name="tipo" required>
        <option value="">Seleccione un tipo</option>
        <option value="Hardware">Hardware</option>
        <option value="Software">Software</option>
        <option value="Red">Red</option>
        <option value="Impresora">Impresora</option>
    </select><br>

    <label>Descripción:</label>
    <textarea name="descripcion" required></textarea><br>

    <input type="submit" value="Registrar Problema">
</form>
</body>
</html>