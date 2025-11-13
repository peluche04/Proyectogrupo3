package gestioncentrodeportivo;

public class Horario {
    private int id;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private String lugar;

    public Horario(int id, String dia, String horaInicio, String horaFin, String lugar) {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.lugar = lugar;
    }

    // Getters
    public int getId() { return id; }
    public String getInfo() {
        return String.format("%s (%s a %s) en %s", dia, horaInicio, horaFin, lugar);
    }
}