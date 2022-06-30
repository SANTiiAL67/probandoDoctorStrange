package com.example.application.utils;

import java.util.ArrayList;


public class Superheroe {
    private String aliasSuperheroe, identidadSecreta, origen, afiliacion;
    private Integer coste, mediaPoder;
    private ArrayList<String> ataque, defensa;
    private ArrayList<Integer> parrillaPoderes;
    private Escenario escenario;
    private String imgCompleto, imgFace;
    private Integer energiaVital, energiaMovimiento;


    public Superheroe() {
    }

    public Superheroe(String aliasSuperheroe, String identidadSecreta, String origen, String afiliacion, Integer coste, ArrayList<String> ataque, ArrayList<String> defensa, ArrayList<Integer> parrillaPoderes, Escenario escenario, String imgCompleto, String imgFace, int mediaPoder) {
        this.aliasSuperheroe = aliasSuperheroe;
        this.identidadSecreta = identidadSecreta;
        this.origen = origen;
        this.afiliacion = afiliacion;
        this.coste = coste;
        this.ataque = ataque;
        this.defensa = defensa;
        this.parrillaPoderes = parrillaPoderes;
        this.escenario = escenario;
        this.imgCompleto = imgCompleto;
        this.imgFace = imgFace;
        this.mediaPoder = mediaPoder;
        this.energiaVital = 0;
        this.energiaMovimiento = 80;
    }

    public Superheroe(String aliasSuperheroe, String identidadSecreta, String origen, String afiliacion, Integer coste, ArrayList<String> ataque, ArrayList<String> defensa, int habilidadLucha,int proyeccionenergia,int resistencia,int velocidad,int fuerza,int inteligencia, Escenario escenario, String imgCompleto, String imgFace, int mediaPoder) {
        this.aliasSuperheroe = aliasSuperheroe;
        this.identidadSecreta = identidadSecreta;
        this.origen = origen;
        this.afiliacion = afiliacion;
        this.coste = coste;
        this.ataque = ataque;
        this.defensa = defensa;
        this.parrillaPoderes = new ArrayList<>();
        parrillaPoderes.add(habilidadLucha);
        parrillaPoderes.add(proyeccionenergia);
        parrillaPoderes.add(resistencia);
        parrillaPoderes.add(velocidad);
        parrillaPoderes.add(fuerza);
        parrillaPoderes.add(inteligencia);
        this.escenario = escenario;
        this.imgCompleto = imgCompleto;
        this.imgFace = imgFace;
        this.mediaPoder = mediaPoder;
        this.energiaVital = 0;
        this.energiaMovimiento = 80;
    }

    public Integer getEnergiaMovimiento() {
        return energiaMovimiento;
    }

    public void setEnergiaMovimiento(Integer energiaMovimiento) {
        this.energiaMovimiento = energiaMovimiento;
    }

    public Integer getEnergiaVital() {
        return energiaVital;
    }

    public void setEnergiaVital(Integer energiaVital) {
        this.energiaVital = energiaVital;
    }

    public String getImgCompleto() {
        return imgCompleto;
    }

    public void setImgCompleto(String imgCompleto) {
        this.imgCompleto = imgCompleto;
    }

    public String getImgFace() {
        return imgFace;
    }

    public Integer getMediaPoder() {
        return mediaPoder;
    }

    public void setMediaPoder(Integer mediaPoder) {
        this.mediaPoder = mediaPoder;
    }

    public void setImgFace(String imgFace) {
        this.imgFace = imgFace;
    }

    public String getAliasSuperheroe() {
        return aliasSuperheroe;
    }

    public void setAliasSuperheroe(String aliasSuperheroe) {
        this.aliasSuperheroe = aliasSuperheroe;
    }

    public String getIdentidadSecreta() {
        return identidadSecreta;
    }

    public void setIdentidadSecreta(String identidadSecreta) {
        this.identidadSecreta = identidadSecreta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    public Integer getCoste() {
        return coste;
    }

    public void setCoste(Integer coste) {
        this.coste = coste;
    }

    public ArrayList<String> getAtaque() {
        return ataque;
    }

    public void setAtaque(ArrayList<String> ataque) {
        this.ataque = ataque;
    }

    public ArrayList<String> getDefensa() {
        return defensa;
    }

    public void setDefensa(ArrayList<String> defensa) {
        this.defensa = defensa;
    }

    public ArrayList<Integer> getParrillaPoderes() {
        return parrillaPoderes;
    }

    public void setParrillaPoderes(ArrayList<Integer> parrillaPoderes) {
        this.parrillaPoderes = parrillaPoderes;
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }
}
