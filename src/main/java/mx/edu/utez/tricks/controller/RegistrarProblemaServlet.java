package mx.edu.utez.tricks.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.tricks.Problema;
import mx.edu.utez.tricks.dao.ProblemaDAO;

import java.io.IOException;

@WebServlet("/RegistrarProblemaServlet")
public class RegistrarProblemaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener datos del formulario
        int id = Integer.parseInt(request.getParameter("id"));
        String tipo = request.getParameter("tipo");
        String descripcion = request.getParameter("descripcion");

        // Crear problema
        Problema problema = new Problema(id, tipo, descripcion);

        // Agregar a la cola de problemas
        ProblemaDAO.getInstance().agregarProblema(problema);

        // Redirigir al index
        response.sendRedirect("index.html");
    }
}
