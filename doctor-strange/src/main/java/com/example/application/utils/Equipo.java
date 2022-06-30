package com.example.application.utils;

import java.util.ArrayList;

public class Equipo {

    private ArrayList<Superheroe> listaSuperheroe = new ArrayList<Superheroe>();
    private Superheroe superheroe;
    private int numSuperheroes = 0;


    public Equipo() {}

    public Equipo(ArrayList<Superheroe> superheroes) {
        this.listaSuperheroe = superheroes;
    }

    public void añadirSuperheroe(Superheroe superheroe) {
        listaSuperheroe.add(superheroe);
        numSuperheroes++;
    }

    public void borrarSuperheroe(Superheroe superheroe) {
        listaSuperheroe.remove(superheroe);
        numSuperheroes--;
    }

    public void mostrarEquipo() {
        for (Superheroe item : listaSuperheroe) {
            System.out.println(item.getAliasSuperheroe());
        }
    }

    public ArrayList<Superheroe> getListaSuperheroe() {
        return listaSuperheroe;
    }

    public void setListaSuperheroe(ArrayList<Superheroe> listaSuperheroe) {
        this.listaSuperheroe = listaSuperheroe;
    }


    public int getNumSuperheroes() {
        return numSuperheroes;
    }

    public void setNumSuperheroes(int numSuperheroes) {
        this.numSuperheroes = numSuperheroes;
    }

    public Superheroe getSuperheroe() {
        return superheroe;
    }

    public void setSuperheroe(Superheroe superheroe) {
        this.superheroe = superheroe;
    }
}