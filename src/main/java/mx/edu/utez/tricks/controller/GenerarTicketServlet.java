package mx.edu.utez.tricks.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/GenerarTicketServlet")
public class GenerarTicketServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Generar ID aleatorio
        int id = new Random().nextInt(100000);

        // Pasar el ID generado al formulario
        request.setAttribute("idTicket", id);

        // Redirigir al formulario de problema
        request.getRequestDispatcher("formulario-problema.jsp").forward(request, response);
    }
}