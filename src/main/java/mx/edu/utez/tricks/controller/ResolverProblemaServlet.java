package mx.edu.utez.tricks.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.tricks.Problema;
import mx.edu.utez.tricks.dao.ProblemaDAO;

import java.io.IOException;

@WebServlet("/ResolverProblemaServlet")
public class ResolverProblemaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el siguiente problema de la cola
        Problema problema = ProblemaDAO.getInstance().obtenerSiguienteProblema();

        if (problema != null) {
            // Mover problema al historial
            ProblemaDAO.getInstance().moverProblemaAHistorial(problema);
        }

        // Redirigir a la página de historial
        response.sendRedirect("historial.jsp");
    }
}