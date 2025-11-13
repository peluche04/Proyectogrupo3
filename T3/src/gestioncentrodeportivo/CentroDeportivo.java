package gestioncentrodeportivo;

import java.util.ArrayList;
import java.util.List;

public class CentroDeportivo {
    
    // --- Listas Maestras (La Base de Datos Central) ---
    private List<Usuario> usuarios;
    private List<Entrenador> entrenadores;
    private List<Horario> horariosDisponibles;

    // Contadores para IDs automáticos
    private int proximoUsuarioId = 1;
    private int proximoEntrenadorId = 1;
    private int proximoHorarioId = 1;

    public CentroDeportivo() {
        this.usuarios = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.horariosDisponibles = new ArrayList<>();
    }

    // --- MÉTODOS DE INSCRIPCIÓN ---

    public void inscribirUsuario(String nombre, String apellido, int edad, String disciplina) {
        Usuario nuevoUsuario = new Usuario(proximoUsuarioId++, nombre, apellido, edad, disciplina);
        this.usuarios.add(nuevoUsuario);
        // Este mensaje se verá en la consola de NetBeans
        System.out.println("DEPORTISTA INSCRITO: " + nuevoUsuario.getNombreCompleto());
    }

    public void inscribirEntrenador(String nombre, String apellido, String especialidad) {
        Entrenador nuevoEntrenador = new Entrenador(proximoEntrenadorId++, nombre, apellido, especialidad);
        this.entrenadores.add(nuevoEntrenador);
        System.out.println("ENTRENADOR INSCRITO: " + nuevoEntrenador.getNombreCompleto());
    }

    public void crearHorario(String dia, String inicio, String fin, String lugar) {
         Horario nuevoHorario = new Horario(proximoHorarioId++, dia, inicio, fin, lugar);
         this.horariosDisponibles.add(nuevoHorario);
         System.out.println("HORARIO CREADO: " + nuevoHorario.getInfo());
    }

    // --- MÉTODOS DE ASIGNACIÓN ---

    public boolean asignarEntrenadorAUsuario(int usuarioId, int entrenadorId) {
        Usuario usuario = buscarUsuarioPorId(usuarioId);
        Entrenador entrenador = buscarEntrenadorPorId(entrenadorId);

        if (usuario == null || entrenador == null) {
            System.out.println("ERROR: Usuario o Entrenador no encontrado.");
            return false;
        }

        usuario.setEntrenadorAsignado(entrenador);
        entrenador.agregarUsuario(usuario);
        System.out.println("ASIGNACIÓN: " + usuario.getNombre() + " -> " + entrenador.getNombreCompleto());
        return true;
    }

    public boolean asignarHorarioAUsuario(int usuarioId, int horarioId) {
        Usuario usuario = buscarUsuarioPorId(usuarioId);
        Horario horario = buscarHorarioPorId(horarioId);

        if (usuario == null || horario == null) {
            System.out.println("ERROR: Usuario u Horario no encontrado.");
            return false;
        }

        usuario.setHorarioAsignado(horario);
        System.out.println("HORARIO ASIGNADO: " + usuario.getNombre() + " -> " + horario.getInfo());
        return true;
    }

    // --- MÉTODOS DE REPORTE (para la consola) ---
    public void mostrarEstadoCompleto() {
        System.out.println("\n--- REPORTE GENERAL DEL CENTRO A&M ---");
        System.out.println("\n--- DEPORTISTAS ---");
        if (usuarios.isEmpty()) System.out.println("(No hay deportistas inscritos)");
        for (Usuario u : usuarios) {
            System.out.println(u.toString());
        }

        System.out.println("\n--- ENTRENADORES Y SUS EQUIPOS ---");
        if (entrenadores.isEmpty()) System.out.println("(No hay entrenadores inscritos)");
        for (Entrenador e : entrenadores) {
            e.mostrarDeportistas();
        }
    }


    // --- Métodos privados (Helpers para buscar) ---
    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    public Entrenador buscarEntrenadorPorId(int id) {
        for (Entrenador e : entrenadores) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public Horario buscarHorarioPorId(int id) {
        for (Horario h : horariosDisponibles) {
            if (h.getId() == id) return h;
        }
        return null;
    }
}