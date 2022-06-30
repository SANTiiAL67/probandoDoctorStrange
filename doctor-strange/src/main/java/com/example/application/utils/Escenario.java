package com.example.application.utils;

public class Escenario{
    private String nombreEscenario;
    private int numMonedas, numJugadores, numMovimientos, energiaVital;
    private String imagen;
    public Escenario() {
    }

    public Escenario(String nombreEscenario) {
        this.nombreEscenario=nombreEscenario;
    }



    public Escenario(String nombreEscenario, int numMonedas, int numJugadores, int numMovimientos, int energiaVital, String imagen) {
        this.nombreEscenario = nombreEscenario;
        this.numMonedas = numMonedas;
        this.numJugadores = numJugadores;
        this.numMovimientos = numMovimientos;
        this.energiaVital = energiaVital;
        this.imagen = imagen;
    }

    public int getNumMonedas() {
        return numMonedas;
    }

    public void setNumMonedas(int numMonedas) {
        this.numMonedas = numMonedas;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public int getNumMovimientos() {
        return numMovimientos;
    }

    public void setNumMovimientos(int numMovimientos) {
        this.numMovimientos = numMovimientos;
    }

    public int getEnergiaVital() {
        return energiaVital;
    }

    public void setEnergiaVital(int energiaVital) {
        this.energiaVital = energiaVital;
    }

    public String getNombreEscenario() {
        return nombreEscenario;
    }

    public void setNombreEscenario(String nombreEscenario) {
        this.nombreEscenario = nombreEscenario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
