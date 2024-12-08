package mx.edu.utez.tricks.dao;


import mx.edu.utez.tricks.Problema;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class ProblemaDAO {
    private static ProblemaDAO instance;
    private Queue<Problema> colaProblemas;
    private List<Problema> historialProblemas;

    private ProblemaDAO() {
        colaProblemas = new LinkedList<>();
        historialProblemas = new ArrayList<>();
    }

    public static synchronized ProblemaDAO getInstance() {
        if (instance == null) {
            instance = new ProblemaDAO();
        }
        return instance;
    }

    public void agregarProblema(Problema problema) {
        colaProblemas.offer(problema);
    }

    public Problema obtenerSiguienteProblema() {
        return colaProblemas.poll();
    }

    public Queue<Problema> obtenerColaProblemas() {
        return new LinkedList<>(colaProblemas);
    }

    public void moverProblemaAHistorial(Problema problema) {
        historialProblemas.add(problema);
    }

    public List<Problema> obtenerHistorialProblemas() {
        return new ArrayList<>(historialProblemas);
    }
}