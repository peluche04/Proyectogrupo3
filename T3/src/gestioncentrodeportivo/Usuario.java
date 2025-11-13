package gestioncentrodeportivo;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String disciplina;

    // --- RELACIONES ---
    private Entrenador entrenadorAsignado;
    private Horario horarioAsignado;

    public Usuario(int id, String nombre, String apellido, int edad, String disciplina) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.disciplina = disciplina;
        this.entrenadorAsignado = null; 
        this.horarioAsignado = null;   
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getNombreCompleto() { return nombre + " " + apellido; }

    // Setters para las asignaciones
    public void setEntrenadorAsignado(Entrenador entrenador) {
        this.entrenadorAsignado = entrenador;
    }

    public void setHorarioAsignado(Horario horario) {
        this.horarioAsignado = horario;
    }

    // Método para mostrar el estado del usuario
    @Override
    public String toString() {
        String entrenador = (entrenadorAsignado != null) ? entrenadorAsignado.getNombreCompleto() : "Sin asignar";
        String horario = (horarioAsignado != null) ? horarioAsignado.getInfo() : "Sin asignar";

        return String.format(
            "ID: %d | Deportista: %s | Disciplina: %s | Entrenador: %s | Horario: %s",
            id, getNombreCompleto(), disciplina, entrenador, horario
        );
    }
}
