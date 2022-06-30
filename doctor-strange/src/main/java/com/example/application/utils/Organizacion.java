package com.example.application.utils;


public class Organizacion{
   /* private String nombreOrganizacion;
    private ArrayList<String> listaOrganizacion;

    public Organizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
        this.listaOrganizacion = listarSuperheroes(nombreOrganizacion);
    }

    //la ventaja va a ser un porcentaje, se puede cambiar
    public int darVentaja(Equipo equipo, Organizacion organizacion) {
        ArrayList<Superheroe> lista = equipo.getListaSuperheroe();
        double numeroOrg = 0;
        int ventaja = 0;
        for (Superheroe superheroe : lista) {
            if (superheroe.getAfiliacion().equals(organizacion.getNombreOrganizacion())) {
                numeroOrg++;
            }
        }
        int n = organizacion.getListaOrganizacion().size();
        ventaja = (int) ((numeroOrg / n) * 10);//el maximo de la ventaja de momento es 10%
        return ventaja;
    }

    public ArrayList<String> listarSuperheroes(String nombre) {
        ArrayList<String> lista = new ArrayList<>();
        switch (nombre) {
            case AVENGERS:
                lista.addAll(List.of(IRONMAN, CAPITANAMERICA, HULK, BLACKPANTHER));
                break;
            case XFORCE:
                lista.addAll(List.of(DEADPOOL));
                break;
            case XMEN:
                lista.addAll(List.of(WOLVERINE));
                break;
            case LEAGUEOFREALMS:
                lista.addAll(List.of(THOR, SPIDERMAN, LOKI));
                break;
            case SAVAGEAVENGERS:
                lista.addAll(List.of(THEPUNISHER));
                break;
            case STRANGEACADEMY:
                lista.addAll(List.of(DOCTORSTRANGE));
                break;
            case AFORCE:
                lista.addAll(List.of(CAPTAINMARVEL));
                break;
        }

        return lista;
    }

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public ArrayList<String> getListaOrganizacion() {
        return listaOrganizacion;
    }*/
}
