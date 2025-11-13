package gestioncentrodeportivo;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    private int id;
    private String nombre;
    private String apellido;
    private String especialidad;

    private List<Usuario> usuariosAsignados;

    public Entrenador(int id, String nombre, String apellido, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.usuariosAsignados = new ArrayList<>(); 
    }

    // Getters
    public int getId() { return id; }
    public String getNombreCompleto() { return nombre + " " + apellido; }

    // Método para gestionar la relación
    public void agregarUsuario(Usuario usuario) {
        this.usuariosAsignados.add(usuario);
    }

    // Método para ver los deportistas del entrenador
    public void mostrarDeportistas() {
        System.out.println("Deportistas a cargo de " + getNombreCompleto() + ":");
        if (usuariosAsignados.isEmpty()) {
            System.out.println("  (Ninguno)");
            return;
        }
        for (Usuario u : usuariosAsignados) {
            System.out.println("  - " + u.getNombreCompleto());
        }
    }
}