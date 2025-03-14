package com.example.tuto_bar_bottom;
public class Alarma {
    private String nombre;
    private String fecha;
    private String hora;

    public Alarma(String nombre, String fecha, String hora) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
}


