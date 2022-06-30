package com.example.application.views;

import com.example.application.utils.*;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import javax.annotation.security.PermitAll;

@PageTitle("Doctor Strange | Partida")
@Route(value = "partida")
@PermitAll
@CssImport("../frontend/themes/doctorstrange/styles.css")

public class PartidaView extends VerticalLayout implements ComponentEventListener<ClickEvent<Button>> {
    private VerticalLayout containerJ1, containerJ2, verticalVidaEnergiaJ1, verticalVidaEnergiaJ2, verticalBotonesJ1, verticalBotonesJ2;
    private HorizontalLayout personajesJ1, personajesJ2, base, horizontalVidaJ1, horizontalVidaJ2, horizontalEnergiaJ1, horizontalEnergiaJ2, filaUnoBtnJ1, filaDosBtnJ1, filaUnoBtnJ2, filaDosBtnJ2;
    private Image j1p1img, j1p2img, j1p3img, j2p1img, j2p2img, j2p3img, heartImg, heartImg2, enerImg, enerImg2;
    private Button btnIniciar,btnAtaqueUnoJ1, btnAtaqueDosJ1, btnAtaqueUnoJ2, btnAtaqueDosJ2, btnDefensaUnoJ1, btnDefensaDosJ1, btnDefensaUnoJ2, btnDefensaDosJ2, btnj1p1img, btnj1p2img, btnj1p3img, btnj2p1img, btnj2p2img, btnj2p3img;
    private ProgressBar progressBarCoraj1,progressBarCoraj2,progressBarEnerj1,progressBarEnerj2;
    private Jugador jugador1, jugador2;
    private Equipo equipo1, equipo2;
    private Escenario escenario;
    private Superheroe superheroeSeleccionado1, superheroeSeleccionado2;
    //debil es 1 y fuerte 2
    private int movimientoSeleccionado1, movimientoSeleccionado2,turnos;
    //ataque es true y defensa false
    private boolean ataqueDefensa1, ataqueDefensa2;
    private HorizontalLayout horizontalBtn;
    private String resultado;
    private Text text;
    private Div div;
    private MongoDB mongoDB;

    public PartidaView() {
        inicializarYinstanciar();
        accionCombate();
        cambiarDePersonaje();
    }

    private void inicializarYinstanciar() {
        jugador1 = (Jugador) ComponentUtil.getData(UI.getCurrent(), "jugador1");
        jugador2 = (Jugador) ComponentUtil.getData(UI.getCurrent(), "jugador2");
        btnIniciar=new Button("LUCHAR");
        turnos = 0;
        System.out.println(jugador1.getAlias_jugador());
        System.out.println(jugador2.getAlias_jugador());
        equipo1 = jugador1.getEquipo();
        equipo2 = jugador2.getEquipo();
        conectarMongo(jugador1.getEscenario().getNombreEscenario());
        this.getElement().getStyle().set("background-image", escenario.getImagen());
        inicializarcombate();

        containerJ1 = new VerticalLayout();
        containerJ2 = new VerticalLayout();
        containerJ1.getStyle().set("margin-right","120px");
        containerJ2.getStyle().set("margin-left","120px");

        verticalVidaEnergiaJ1 = new VerticalLayout();
        verticalVidaEnergiaJ2 = new VerticalLayout();

        horizontalVidaJ1 = new HorizontalLayout();
        horizontalVidaJ2 = new HorizontalLayout();

        heartImg = new Image("https://i.ibb.co/RCJ9Lsk/heart.png", "");
        heartImg.setWidth("30px");
        heartImg2 = new Image("https://i.ibb.co/RCJ9Lsk/heart.png", "");
        heartImg2.setWidth("30px");

        enerImg = new Image("https://cdn-icons-png.flaticon.com/512/2983/2983973.png", "");
        enerImg.setWidth("30px");
        enerImg2 = new Image("https://cdn-icons-png.flaticon.com/512/2983/2983973.png", "");
        enerImg2.setWidth("30px");
        progressBarCoraj1 = new ProgressBar();
        progressBarCoraj1.setValue(1);
        progressBarCoraj1.setWidth("250px");

        progressBarCoraj2 = new ProgressBar();
        progressBarCoraj2.setValue(1);
        progressBarCoraj2.setWidth("250px");

        progressBarEnerj1 = new ProgressBar();
        progressBarEnerj1.setValue(1);
        progressBarEnerj1.setWidth("250px");

        progressBarEnerj2 = new ProgressBar();
        progressBarEnerj2.setValue(1);
        progressBarEnerj2.setWidth("250px");

        horizontalVidaJ1.add(heartImg);
        horizontalVidaJ2.add(heartImg2);

        horizontalEnergiaJ1 = new HorizontalLayout();
        horizontalEnergiaJ2 = new HorizontalLayout();

        horizontalEnergiaJ1.add(enerImg);
        horizontalEnergiaJ2.add(enerImg2);

        verticalVidaEnergiaJ1.add(horizontalVidaJ1,progressBarCoraj1);
        verticalVidaEnergiaJ1.add(horizontalEnergiaJ1,progressBarEnerj1);

        verticalVidaEnergiaJ2.add(horizontalVidaJ2,progressBarCoraj2);
        verticalVidaEnergiaJ2.add(horizontalEnergiaJ2,progressBarEnerj2);

        base = new HorizontalLayout();
        personajesJ1 = new HorizontalLayout();
        personajesJ2 = new HorizontalLayout();


        j1p1img = new Image(equipo1.getListaSuperheroe().get(0).getImgCompleto(), "");
        j1p2img = new Image(equipo1.getListaSuperheroe().get(1).getImgCompleto(), "");
        j1p3img = new Image(equipo1.getListaSuperheroe().get(2).getImgCompleto(), "");

        j2p1img = new Image(equipo2.getListaSuperheroe().get(0).getImgCompleto(), "");
        j2p2img = new Image(equipo2.getListaSuperheroe().get(1).getImgCompleto(), "");
        j2p3img = new Image(equipo2.getListaSuperheroe().get(2).getImgCompleto(), "");

        j1p1img.setWidth("190px");
        j1p1img.getStyle().set("cursor","pointer");
        j1p2img.setWidth("160px");
        j1p2img.getStyle().set("cursor","pointer");
        j1p3img.setWidth("160px");
        j1p3img.getStyle().set("cursor","pointer");

        j2p1img.setWidth("190px");
        j2p1img.getStyle().set("cursor","pointer");
        j2p2img.setWidth("160px");
        j2p2img.getStyle().set("cursor","pointer");
        j2p3img.setWidth("160px");
        j2p3img.getStyle().set("cursor","pointer");




        verticalBotonesJ1 = new VerticalLayout();
        verticalBotonesJ2 = new VerticalLayout();

        filaUnoBtnJ1 = new HorizontalLayout();
        filaDosBtnJ1 = new HorizontalLayout();

        filaUnoBtnJ2 = new HorizontalLayout();
        filaDosBtnJ2 = new HorizontalLayout();


        btnAtaqueUnoJ1 = new Button(equipo1.getListaSuperheroe().get(0).getAtaque().get(0));
        btnAtaqueDosJ1 = new Button(equipo1.getListaSuperheroe().get(0).getAtaque().get(1));
        btnDefensaUnoJ1 = new Button(equipo1.getListaSuperheroe().get(0).getDefensa().get(0));
        btnDefensaDosJ1 = new Button(equipo1.getListaSuperheroe().get(0).getDefensa().get(1));

        btnAtaqueUnoJ2 = new Button(equipo2.getListaSuperheroe().get(0).getAtaque().get(0));
        btnAtaqueDosJ2 = new Button(equipo2.getListaSuperheroe().get(0).getAtaque().get(1));
        btnDefensaUnoJ2 = new Button(equipo2.getListaSuperheroe().get(0).getDefensa().get(0));
        btnDefensaDosJ2 = new Button(equipo2.getListaSuperheroe().get(0).getDefensa().get(1));



        btnj1p1img = new Button();
        btnj1p2img = new Button();
        btnj1p3img = new Button();
        btnj2p1img = new Button();
        btnj2p2img = new Button();
        btnj2p3img = new Button();
        VerticalLayout vlFila = new VerticalLayout();
        VerticalLayout vlFila1 = new VerticalLayout();

        filaUnoBtnJ1.add(btnAtaqueUnoJ1, btnAtaqueDosJ1);
        filaUnoBtnJ2.add(btnAtaqueUnoJ2, btnAtaqueDosJ2);
        vlFila.add(new Text("ATAQUE"),filaUnoBtnJ1,new Text("DEFENSA"),filaDosBtnJ1);

        filaDosBtnJ1.add(btnDefensaUnoJ1, btnDefensaDosJ1);
        filaDosBtnJ2.add(btnDefensaUnoJ2, btnDefensaDosJ2);
        vlFila1.add(new Text("ATAQUE"),filaUnoBtnJ2,new Text("DEFENSA"),filaDosBtnJ2);

        filaUnoBtnJ1.setSizeFull();
        filaUnoBtnJ2.setSizeFull();

        filaDosBtnJ1.setSizeFull();
        filaDosBtnJ2.setSizeFull();

        horizontalBtn = new HorizontalLayout();
        verticalBotonesJ1.add(vlFila);
        verticalBotonesJ1.addClassName("btnJ1");

        verticalBotonesJ2.add(vlFila1);
        verticalBotonesJ2.addClassName("btnJ2");

        horizontalBtn.add(verticalBotonesJ1, verticalBotonesJ2);


        //TODO Adam si puedes haz en los estilos una clase baton de movimiento fuerte y uno de movimento debil aunque sea simplemente un cambio de color de las letras

        btnAtaqueUnoJ1.addClassName("botones1");
        btnAtaqueUnoJ2.addClassName("botones1");
        btnAtaqueDosJ1.addClassName("botones1");
        btnAtaqueDosJ2.addClassName("botones1");

        btnDefensaUnoJ1.addClassName("botones2");
        btnDefensaUnoJ2.addClassName("botones2");
        btnDefensaDosJ2.addClassName("botones2");
        btnDefensaDosJ1.addClassName("botones2");


        personajesJ1.add( j1p2img, j1p3img,j1p1img);
        personajesJ2.add(j2p2img, j2p3img,j2p1img );

        //TODO donde esta el texto cambiarlo por un boton de iniciar combate
        text = new Text("");
        div = new Div();
        div.add(text);
        div.addClassName("div");

        containerJ1.add(verticalVidaEnergiaJ1, personajesJ1);
        containerJ2.add(verticalVidaEnergiaJ2, personajesJ2);
        containerJ2.addClassName("heartImg2");
        base.add(containerJ1, containerJ2);



        add(div, base, horizontalBtn);
        add(btnIniciar);
        setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

    }

    public void cambiarDePersonaje(){
        j1p1img.addClickListener(new ComponentEventListener<ClickEvent<Image>>() {
            @Override
            public void onComponentEvent(ClickEvent<Image> imageClickEvent) {
                superheroeSeleccionado1 = equipo1.getListaSuperheroe().get(0);
                btnAtaqueUnoJ1.setText(equipo1.getListaSuperheroe().get(0).getAtaque().get(0));
                btnAtaqueDosJ1.setText(equipo1.getListaSuperheroe().get(0).getAtaque().get(1));
                btnDefensaUnoJ1.setText(equipo1.getListaSuperheroe().get(0).getDefensa().get(0));
                btnDefensaDosJ1.setText(equipo1.getListaSuperheroe().get(0).getDefensa().get(1));
                progressBarCoraj1.setValue((double)(equipo1.getListaSuperheroe().get(0).getEnergiaVital())/((double)escenario.getEnergiaVital()));
                progressBarEnerj1.setValue(((double)equipo1.getListaSuperheroe().get(0).getEnergiaMovimiento())/80);
            }
        });
        j1p2img.addClickListener(new ComponentEventListener<ClickEvent<Image>>() {
            @Override
            public void onComponentEvent(ClickEvent<Image> imageClickEvent) {
                superheroeSeleccionado1 = equipo1.getListaSuperheroe().get(1);
                btnAtaqueUnoJ1.setText(equipo1.getListaSuperheroe().get(1).getAtaque().get(0));
                btnAtaqueDosJ1.setText(equipo1.getListaSuperheroe().get(1).getAtaque().get(1));
                btnDefensaUnoJ1.setText(equipo1.getListaSuperheroe().get(1).getDefensa().get(0));
                btnDefensaDosJ1.setText(equipo1.getListaSuperheroe().get(1).getDefensa().get(1));
                progressBarCoraj1.setValue((double)(equipo1.getListaSuperheroe().get(1).getEnergiaVital())/((double)escenario.getEnergiaVital()));
                progressBarEnerj1.setValue(((double)equipo1.getListaSuperheroe().get(1).getEnergiaMovimiento())/80);
            }
        });
        j1p3img.addClickListener(new ComponentEventListener<ClickEvent<Image>>() {
            @Override
            public void onComponentEvent(ClickEvent<Image> imageClickEvent) {
                superheroeSeleccionado1 = equipo1.getListaSuperheroe().get(2);
                btnAtaqueUnoJ1.setText(equipo1.getListaSuperheroe().get(2).getAtaque().get(0));
                btnAtaqueDosJ1.setText(equipo1.getListaSuperheroe().get(2).getAtaque().get(1));
                btnDefensaUnoJ1.setText(equipo1.getListaSuperheroe().get(2).getDefensa().get(0));
                btnDefensaDosJ1.setText(equipo1.getListaSuperheroe().get(2).getDefensa().get(1));
                progressBarCoraj1.setValue((double)(equipo1.getListaSuperheroe().get(2).getEnergiaVital())/((double)escenario.getEnergiaVital()));
                progressBarEnerj1.setValue(((double)equipo1.getListaSuperheroe().get(2).getEnergiaMovimiento())/80);
            }
        });
        j2p1img.addClickListener(new ComponentEventListener<ClickEvent<Image>>() {
            @Override
            public void onComponentEvent(ClickEvent<Image> imageClickEvent) {
                superheroeSeleccionado2 = equipo2.getListaSuperheroe().get(0);
                btnAtaqueUnoJ2.setText(equipo2.getListaSuperheroe().get(0).getAtaque().get(0));
                btnAtaqueDosJ2.setText(equipo2.getListaSuperheroe().get(0).getAtaque().get(1));
                btnDefensaUnoJ2.setText(equipo2.getListaSuperheroe().get(0).getDefensa().get(0));
                btnDefensaDosJ2.setText(equipo2.getListaSuperheroe().get(0).getDefensa().get(1));
                progressBarCoraj2.setValue((double)(equipo2.getListaSuperheroe().get(0).getEnergiaVital())/((double)escenario.getEnergiaVital()));
                progressBarEnerj2.setValue(((double)equipo2.getListaSuperheroe().get(0).getEnergiaMovimiento())/80);
            }
        });
        j2p2img.addClickListener(new ComponentEventListener<ClickEvent<Image>>() {
            @Override
            public void onComponentEvent(ClickEvent<Image> imageClickEvent) {
                superheroeSeleccionado2 = equipo2.getListaSuperheroe().get(1);
                btnAtaqueUnoJ2.setText(equipo2.getListaSuperheroe().get(1).getAtaque().get(0));
                btnAtaqueDosJ2.setText(equipo2.getListaSuperheroe().get(1).getAtaque().get(1));
                btnDefensaUnoJ2.setText(equipo2.getListaSuperheroe().get(1).getDefensa().get(0));
                btnDefensaDosJ2.setText(equipo2.getListaSuperheroe().get(1).getDefensa().get(1));
                progressBarCoraj2.setValue((double)(equipo2.getListaSuperheroe().get(1).getEnergiaVital())/((double)escenario.getEnergiaVital()));
                progressBarEnerj2.setValue(((double)equipo2.getListaSuperheroe().get(1).getEnergiaMovimiento())/80);
            }
        });
        j2p3img.addClickListener(new ComponentEventListener<ClickEvent<Image>>() {
            @Override
            public void onComponentEvent(ClickEvent<Image> imageClickEvent) {
                superheroeSeleccionado2 = equipo2.getListaSuperheroe().get(2);
                btnAtaqueUnoJ2.setText(equipo2.getListaSuperheroe().get(2).getAtaque().get(0));
                btnAtaqueDosJ2.setText(equipo2.getListaSuperheroe().get(2).getAtaque().get(1));
                btnDefensaUnoJ2.setText(equipo2.getListaSuperheroe().get(2).getDefensa().get(0));
                btnDefensaDosJ2.setText(equipo2.getListaSuperheroe().get(2).getDefensa().get(1));
                progressBarCoraj2.setValue((double)(equipo2.getListaSuperheroe().get(2).getEnergiaVital())/((double)escenario.getEnergiaVital()));
                progressBarEnerj2.setValue(((double)equipo2.getListaSuperheroe().get(2).getEnergiaMovimiento())/80);
            }
        });
    }

    private void accionCombate() {
        btnAtaqueUnoJ1.addClickListener(this);
        btnAtaqueDosJ1.addClickListener(this);
        btnAtaqueUnoJ2.addClickListener(this);
        btnAtaqueDosJ2.addClickListener(this);

        btnDefensaUnoJ1.addClickListener(this);
        btnDefensaDosJ1.addClickListener(this);
        btnDefensaUnoJ2.addClickListener(this);
        btnDefensaDosJ2.addClickListener(this);

        btnj1p1img.addClickListener(this);
        btnj1p2img.addClickListener(this);
        btnj1p3img.addClickListener(this);

        btnj2p1img.addClickListener(this);
        btnj2p2img.addClickListener(this);
        btnj2p3img.addClickListener(this);

        btnIniciar.addClickListener(this);

    }

    /*  Energia incial(De movimientos) 80, si el superheroe no tiene energia no se le deja atacar
        las defensas en vez de hacer daño restan daño del ataque del oponente(si la defensa es mayor o igual que el ataque no hace daño)
        ataque debil 15 daño coste 10, ataque fuerte 30 daño coste 25
        defensa debil 10 proteccion coste 10, defensa fuerte 20 proteccion coste 25
    */

    private void combate() {
        System.out.println("hola combate");
        System.out.println(ataqueDefensa1+""+ataqueDefensa2);
        int movimiento1, movimiento2;
        //superheroeSeleccionado1.setEnergiaMovimiento(900000000);
        //superheroeSeleccionado2.setEnergiaMovimiento(900000000);
        if (ataqueDefensa1 && ataqueDefensa2) {
            //ambos atacan
            movimiento1 = calculoDanio(superheroeSeleccionado1,ataqueDefensa1,movimientoSeleccionado1);
            superheroeSeleccionado1.setEnergiaMovimiento(superheroeSeleccionado1.getEnergiaMovimiento() - ((15 * movimientoSeleccionado1) - 5));
            superheroeSeleccionado2.setEnergiaVital(superheroeSeleccionado2.getEnergiaVital() - movimiento1);
            movimiento2 = calculoDanio(superheroeSeleccionado2,ataqueDefensa2,movimientoSeleccionado2);
            superheroeSeleccionado2.setEnergiaMovimiento(superheroeSeleccionado2.getEnergiaMovimiento() - ((15 * movimientoSeleccionado2) - 5));
            superheroeSeleccionado1.setEnergiaVital(superheroeSeleccionado1.getEnergiaVital() - movimiento2);
            resultado = superheroeSeleccionado1.getAliasSuperheroe() + " ha perdido " + (movimiento1) + " de vida y " + superheroeSeleccionado2.getAliasSuperheroe() + " ha perdido " + (movimiento2) + " de vida ";
            text.setText(resultado);
        } else if (!ataqueDefensa1 && !ataqueDefensa2) {
            //ambos defienden, no pasa nada
            resultado = "Ambos han defendido y nadie ha perdido energia vital";
            text.setText(resultado);
        } else if (ataqueDefensa1 && !ataqueDefensa2) {
            //jugador1 ataca, jugador2 defiende
            movimiento1 = calculoDanio(superheroeSeleccionado1,ataqueDefensa1,movimientoSeleccionado1);
            superheroeSeleccionado1.setEnergiaMovimiento(superheroeSeleccionado1.getEnergiaMovimiento() - ((15 * movimientoSeleccionado1) - 5));
            movimiento2 = calculoDanio(superheroeSeleccionado2,ataqueDefensa2,movimientoSeleccionado2);
            superheroeSeleccionado2.setEnergiaMovimiento(superheroeSeleccionado2.getEnergiaMovimiento() - ((15 * movimientoSeleccionado2) - 5));

            System.out.println(movimiento1+" "+movimiento2);

            if ((movimiento1 - movimiento2) >= 0) {
                superheroeSeleccionado2.setEnergiaVital(superheroeSeleccionado2.getEnergiaVital() - (movimiento1 - movimiento2));
                resultado = superheroeSeleccionado2.getAliasSuperheroe() + " ha perdido " + (movimiento1 - movimiento2) + " de vida";
                text.setText(resultado);
            } else {
                //la defensa es mayor
                resultado = superheroeSeleccionado2.getAliasSuperheroe() + " se ha defendido y ha salido ileso";
                text.setText(resultado);
            }
        } else if (!ataqueDefensa1 && ataqueDefensa2) {
            //jugador1 defeinde, jugador2 ataca
            movimiento1 = calculoDanio(superheroeSeleccionado1,ataqueDefensa1,movimientoSeleccionado1);
            superheroeSeleccionado1.setEnergiaMovimiento(superheroeSeleccionado1.getEnergiaMovimiento() - ((15 * movimientoSeleccionado1) - 5));
            movimiento2 = calculoDanio(superheroeSeleccionado2,ataqueDefensa2,movimientoSeleccionado2);
            superheroeSeleccionado2.setEnergiaMovimiento(superheroeSeleccionado2.getEnergiaMovimiento() - ((15 * movimientoSeleccionado2) - 5));

            System.out.println(movimiento1+" "+movimiento2);

            if ((movimiento2 - movimiento1) >= 0) {
                superheroeSeleccionado1.setEnergiaVital(superheroeSeleccionado1.getEnergiaVital() - (movimiento2 - movimiento1));
                resultado = superheroeSeleccionado1.getAliasSuperheroe() + " ha perdido " + (movimiento2 - movimiento1) + " de vida";
                text.setText(resultado);
            } else {
                //la defensa es mayor
                resultado = superheroeSeleccionado1.getAliasSuperheroe() + " se ha defendido y ha salido ileso";
                text.setText(resultado);
            }

        }
        movimientoSeleccionado1=0;
        movimientoSeleccionado2=0;
        if (superheroeSeleccionado1.getEnergiaVital()<0){
            superheroeSeleccionado1.setEnergiaVital(0);
        }
        if (superheroeSeleccionado2.getEnergiaVital()<0){
            superheroeSeleccionado2.setEnergiaVital(0);
        }
        for (int i=0;i<3;i++){
            if (equipo1.getListaSuperheroe().get(i).getAliasSuperheroe().equals(superheroeSeleccionado1.getAliasSuperheroe())){
                equipo1.getListaSuperheroe().set(i,superheroeSeleccionado1);
                progressBarCoraj1.setValue((double)(superheroeSeleccionado1.getEnergiaVital())/((double)escenario.getEnergiaVital()));
                progressBarEnerj1.setValue(((double)superheroeSeleccionado1.getEnergiaMovimiento())/80);
            }
            if (equipo2.getListaSuperheroe().get(i).getAliasSuperheroe().equals(superheroeSeleccionado2.getAliasSuperheroe())){
                equipo2.getListaSuperheroe().set(i,superheroeSeleccionado2);
                progressBarCoraj2.setValue((double)(superheroeSeleccionado2.getEnergiaVital())/((double)escenario.getEnergiaVital()));
                progressBarEnerj2.setValue(((double)superheroeSeleccionado2.getEnergiaMovimiento())/80);
            }
        }

        turnos++;
        if (turnos%5!=0){
            for (int i=0;i<3;i++){
                if ((equipo1.getListaSuperheroe().get(i).getEnergiaMovimiento())<40){
                    equipo1.getListaSuperheroe().get(i).setEnergiaMovimiento(equipo1.getListaSuperheroe().get(i).getEnergiaMovimiento()+40);

                }
                if ((equipo2.getListaSuperheroe().get(i).getEnergiaMovimiento())<40){
                    equipo2.getListaSuperheroe().get(i).setEnergiaMovimiento(equipo2.getListaSuperheroe().get(i).getEnergiaMovimiento()+40);
                }
            }
        }
        terminarPartida();
    }

    private int calculoDanio(Superheroe superheroe,boolean tipoMovimiento, int fuerzaMovimiento){
        double poder=0;
        int poderfinal=0;
        if (tipoMovimiento){
            System.out.println(superheroe.getParrillaPoderes().get(4)+" "+superheroe.getParrillaPoderes().get(3)+" "+superheroe.getParrillaPoderes().get(0)+" "+superheroe.getParrillaPoderes().get(1));
            poder= (((superheroe.getParrillaPoderes().get(4)*0.8)+(superheroe.getParrillaPoderes().get(3)*0.25)+(superheroe.getParrillaPoderes().get(0)*0.75)+(superheroe.getParrillaPoderes().get(1)))*15*fuerzaMovimiento)/10;
        } else {
            poder= (((superheroe.getParrillaPoderes().get(5))+(superheroe.getParrillaPoderes().get(3)*0.75)+(superheroe.getParrillaPoderes().get(0)*0.25)+(superheroe.getParrillaPoderes().get(4)*0.2))*15*fuerzaMovimiento)/10;
        }
        System.out.println(poder);
        poderfinal=(int)poder;

        return poderfinal;
    }

    private void conectarMongo(String nombreEscenario) {
        mongoDB = new MongoDB();
        mongoDB.conectionMongo();
        escenario = mongoDB.obtenerEscenario(nombreEscenario);

    }

    //lo he creado para que no pete
    private void inicializarcombate() {
        ataqueDefensa1 = true;
        ataqueDefensa2 = true;
        superheroeSeleccionado1 = equipo1.getListaSuperheroe().get(0);
        superheroeSeleccionado2 = equipo2.getListaSuperheroe().get(0);
        movimientoSeleccionado1 = 0;
        movimientoSeleccionado2 = 0;
    }


    @Override
    public void onComponentEvent(ClickEvent<Button> event) {
        if (event.getSource() == btnAtaqueUnoJ1) {
            if (superheroeSeleccionado1.getEnergiaMovimiento() >= 10 && superheroeSeleccionado1.getEnergiaVital() > 0) {
                movimientoSeleccionado1 = 1;
                ataqueDefensa1 = true;
            }
        }
        if (event.getSource() == btnAtaqueDosJ1) {
            if (superheroeSeleccionado1.getEnergiaMovimiento() >= 25 && superheroeSeleccionado1.getEnergiaVital() > 0) {
                movimientoSeleccionado1 = 2;
                ataqueDefensa1 = true;
            }
        }
        if (event.getSource() == btnDefensaUnoJ1) {
            if (superheroeSeleccionado1.getEnergiaMovimiento() >= 10 && superheroeSeleccionado1.getEnergiaVital() > 0) {
                movimientoSeleccionado1 = 1;
                ataqueDefensa1 = false;
            }
        }
        if (event.getSource() == btnDefensaDosJ1) {
            if (superheroeSeleccionado1.getEnergiaMovimiento() >= 25 && superheroeSeleccionado1.getEnergiaVital() > 0) {
                movimientoSeleccionado1 = 2;
                ataqueDefensa1 = false;
            }
        }
        if (event.getSource() == btnAtaqueUnoJ2) {
            if (superheroeSeleccionado2.getEnergiaMovimiento() >= 10 && superheroeSeleccionado2.getEnergiaVital() > 0) {
                movimientoSeleccionado2 = 1;
                ataqueDefensa2 = true;

            }
        }
        if (event.getSource() == btnAtaqueDosJ2) {
            if (superheroeSeleccionado2.getEnergiaMovimiento() >= 25 && superheroeSeleccionado2.getEnergiaVital() > 0) {
                movimientoSeleccionado2 = 2;
                ataqueDefensa2 = true;

            }
        }
        if (event.getSource() == btnDefensaUnoJ2) {
            if (superheroeSeleccionado2.getEnergiaMovimiento() >= 10 && superheroeSeleccionado2.getEnergiaVital() > 0) {
                movimientoSeleccionado2 = 1;
                ataqueDefensa2 = false;

            }
        }
        if (event.getSource() == btnDefensaDosJ2) {
            if (superheroeSeleccionado2.getEnergiaMovimiento() >= 25 && superheroeSeleccionado2.getEnergiaVital() > 0) {
                movimientoSeleccionado2 = 2;
                ataqueDefensa2 = false;

            }
        }
        //TODO Adam este boton es el de iniciar partida la funcionalidad ya esta solo hay que colocarlo en la parte grafica
        //Por cierto el string resultado te dice lo uqe ha pasado en el ultimo turno ponlo donde prefieras
        if (event.getSource() == btnIniciar) {
            if (movimientoSeleccionado1!=0&&movimientoSeleccionado2!=0){
                combate();
            }
        }
    }

    //TODO Adam aqui podemos hacer que vaya a un view nuevo o desaparezca todo eso como prefieras y que luego haya un mensaje diciendo quien ha ganado y si quieres volver a jugar y te mande al inicio,
    //si quieres haz solo el diseño y ya me ocupo yo de hacer el tema de los navigate y tal
    private void terminarPartida(){
        boolean terminado=false;
        String ganador=null;
        if ((equipo1.getListaSuperheroe().get(0).getEnergiaVital()==0&&equipo1.getListaSuperheroe().get(1).getEnergiaVital()==0&&equipo1.getListaSuperheroe().get(2).getEnergiaVital()==0)||(equipo1.getListaSuperheroe().get(0).getEnergiaMovimiento()==0&&equipo1.getListaSuperheroe().get(1).getEnergiaMovimiento()==0&&equipo1.getListaSuperheroe().get(2).getEnergiaMovimiento()==0)){
            terminado=true;
            ganador="El Judador 2 ha ganado";
        }
        if ((equipo2.getListaSuperheroe().get(0).getEnergiaVital()==0&&equipo2.getListaSuperheroe().get(1).getEnergiaVital()==0&&equipo2.getListaSuperheroe().get(2).getEnergiaVital()==0)||(equipo2.getListaSuperheroe().get(0).getEnergiaMovimiento()==0&&equipo2.getListaSuperheroe().get(1).getEnergiaMovimiento()==0&&equipo2.getListaSuperheroe().get(2).getEnergiaMovimiento()==0)){
            //jugador 2 pierde
            terminado=true;
            ganador="El Jugador 1 ha ganado";
        }
        if (terminado){
            base.setVisible(false);
            div.setVisible(false);
            horizontalBtn.setVisible(false);
            btnIniciar.setVisible(false);
            RouterLink routerLink = new RouterLink("Volver a jugar",MenuView.class);
            Label label = new Label(ganador);
            label.getStyle().set("font-size","60px");
            add(label,routerLink);

        }
    }

}