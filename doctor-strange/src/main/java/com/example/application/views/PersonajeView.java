package com.example.application.views;

import com.example.application.utils.*;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;
@CssImport("../frontend/themes/doctorstrange/styles.css")
@PageTitle("Doctor Strange | Personaje")
@Route(value = "personaje")
@PermitAll

public class PersonajeView extends VerticalLayout implements HasUrlParameter<String> {

    private Button doc, thor, spider, wol, dead, capi, loki, punish, panther, capMar, hulk, iron, btnPartida;
    private Button doc2, thor2, spider2, wol2, dead2, capi2, loki2, punish2, panther2, capMar2, hulk2, iron2;
    private HorizontalLayout base, j1p2p3, j2p2p3, personajes, fila, fila2, fila3, coinContainerJ1, coinContainerJ2, columna, columna2, columna3;
    private Image j2p1Img, j2p2Img, j2p3Img, j1p1Img, coin, coin2, j1p2img, j1p3img;

    private VerticalLayout conImg2, conImg1, personajes1, j1Coin, j2Coin, personajes2;
    private Text j1, nombre1, nombre2, numero, afiliacion, afiliacion2, numero2, costeTxt2, j2, costeTxt, coinValueJ1, coinValueJ2;

    private Div j1p2, j1p3, j2p2, j2p3, nombrePersonaje, nombrePersonaje2, numeroPersonaje, numeroPersonaje2, costeContainer2, div2, costeContainer1;

    private Escenario escenario1;
    private List<Superheroe> superheroeList;
    private Jugador jugador1, jugador2;
    private Equipo equipo1, equipo2;

    private ArrayList<Superheroe> superheroesSeleccionados, axuHeroesSeleccionados;
    private MongoDB mongoDB;
    private int screenWidth;


    private void instaciarInicializar() {
        base = new HorizontalLayout();
        UI.getCurrent().getPage().retrieveExtendedClientDetails(receiver -> {
            screenWidth = (int) (receiver.getScreenWidth() * 0.7);
            System.out.println(screenWidth);
            base.setWidth(Integer.toString(screenWidth));
        });
        base.setAlignItems(Alignment.CENTER);
        base.addClassName("base");

        addClassName("personajeView");
        equipo1 = new Equipo();
        equipo2 = new Equipo();
        superheroesSeleccionados = new ArrayList<>();
        axuHeroesSeleccionados = new ArrayList<>();

        afiliacion = new Text("");
        afiliacion2 = new Text("");

        // Creación botones jugador 1

        doc = new Button();
        thor = new Button();
        spider = new Button();
        wol = new Button();
        dead = new Button();
        capi = new Button();
        loki = new Button();
        punish = new Button();
        panther = new Button();
        capMar = new Button();
        hulk = new Button();
        iron = new Button();

        // Creación botones jugador 2 no funcionales hasta que juegue el jugador 1

        doc2 = new Button();
        doc2.setEnabled(false);
        thor2 = new Button();
        thor2.setEnabled(false);
        spider2 = new Button();
        spider2.setEnabled(false);
        wol2 = new Button();
        wol2.setEnabled(false);
        dead2 = new Button();
        dead2.setEnabled(false);
        capi2 = new Button();
        capi2.setEnabled(false);
        loki2 = new Button();
        loki2.setEnabled(false);
        punish2 = new Button();
        punish2.setEnabled(false);
        panther2 = new Button();
        panther2.setEnabled(false);
        capMar2 = new Button();
        capMar2.setEnabled(false);
        hulk2 = new Button();
        hulk2.setEnabled(false);
        iron2 = new Button();
        iron2.setEnabled(false);

        doc2.getStyle().set("opacity", " 0.6");
        thor2.getStyle().set("opacity", " 0.6");
        spider2.getStyle().set("opacity", " 0.6");
        punish2.getStyle().set("opacity", " 0.6");
        hulk2.getStyle().set("opacity", " 0.6");
        iron2.getStyle().set("opacity", " 0.6");
        dead2.getStyle().set("opacity", " 0.6");
        panther2.getStyle().set("opacity", " 0.6");
        capi2.getStyle().set("opacity", " 0.6");
        capMar2.getStyle().set("opacity", " 0.6");
        loki2.getStyle().set("opacity", " 0.6");
        wol2.getStyle().set("opacity", " 0.6");

        // Añadir clases a botones para estilo
        //todo cambiar la imagen y acceso a datos con mongo, debe usarse la misma clase para todos los botones
        doc.addClassName("btnDoc");
        thor.addClassName("btnThor");
        spider.addClassName("btnSpider");
        wol.addClassName("btnWol");

        dead.addClassName("btnDead");
        capi.addClassName("btnCapi");
        loki.addClassName("btnLoki");
        punish.addClassName("btnPunish");

        panther.addClassName("btnPanther");
        capMar.addClassName("btnCapMar");
        hulk.addClassName("btnHulk");
        iron.addClassName("btnIron");

        doc2.addClassName("btnDoc");
        thor2.addClassName("btnThor");
        spider2.addClassName("btnSpider");
        wol2.addClassName("btnWol");

        dead2.addClassName("btnDead");
        capi2.addClassName("btnCapi");
        loki2.addClassName("btnLoki");
        punish2.addClassName("btnPunish");

        panther2.addClassName("btnPanther");
        capMar2.addClassName("btnCapMar");
        hulk2.addClassName("btnHulk");
        iron2.addClassName("btnIron");


        personajes = new HorizontalLayout();
        fila = new HorizontalLayout();
        fila2 = new HorizontalLayout();
        fila3 = new HorizontalLayout();
        personajes1 = new VerticalLayout();

        columna = new HorizontalLayout();
        columna2 = new HorizontalLayout();
        columna3 = new HorizontalLayout();
        personajes2 = new VerticalLayout();


        j1 = new Text("J1");
        coinValueJ1 = new Text("100000");
        coin = new Image("https://i.ibb.co/0Zv999K/coin.png", "");
        coin.setWidth("55px");
        coin.setHeight("55px");

        coinContainerJ1 = new HorizontalLayout();

        coinContainerJ1.addClassName("coinCon");
        coinContainerJ1.add(coin, coinValueJ1);


        j1Coin = new VerticalLayout();
        j1Coin.add(j1, coinContainerJ1);
        j1Coin.setClassName("txt");


        fila.add(doc, thor, spider, wol);
        fila2.add(dead, capi, loki, punish);
        fila3.add(panther, capMar, hulk, iron);


        costeTxt = new Text("");
        costeContainer1 = new Div();
        costeContainer1.add(costeTxt);
        costeContainer1.setClassName("costePersonaje");

        personajes1.add(j1Coin, fila, fila2, fila3, costeContainer1);

        j2 = new Text("J2");
        coinValueJ2 = new Text("100000");
        coin2 = new Image("https://i.ibb.co/0Zv999K/coin.png", "");
        coin2.setWidth("55px");
        coin2.setHeight("55px");

        coinContainerJ2 = new HorizontalLayout();

        coinContainerJ2.addClassName("coinCon2");
        coinContainerJ2.add(coin2, coinValueJ2);

        j2Coin = new VerticalLayout();
        j2Coin.add(j2, coinContainerJ2);
        j2Coin.setClassName("txt");


        columna.add(doc2, thor2, spider2, wol2);
        columna2.add(dead2, capi2, loki2, punish2);
        columna3.add(panther2, capMar2, hulk2, iron2);


        costeTxt2 = new Text("");
        costeContainer2 = new Div();
        costeContainer2.setVisible(false);
        costeContainer2.add(costeTxt2);
        costeContainer2.setClassName("costePersonaje2");


        personajes2.add(j2Coin, columna, columna2, columna3, costeContainer2);

        j2p1Img = new Image("https://i.ibb.co/WybhkLD/loki-Select.png", "ff");
        j1p1Img = new Image("https://i.ibb.co/WybhkLD/loki-Select.png", "empty");
        j2p1Img.getStyle().set("transform", "scaleX(-1)");

        j1p1Img.setWidth("300px");
        j2p1Img.setWidth("300px");



        j2p1Img.setMaxWidth("300px");
        j2p1Img.setMaxWidth("300px");

        j2p1Img.setMinWidth("300px");
        j2p1Img.setMinWidth("300px");



        conImg2 = new VerticalLayout();
        conImg1 = new VerticalLayout();
        nombre1 = new Text("Doctor Strange");
        nombre2 = new Text("Doctor Strange");
        numero = new Text("80");
        numero2 = new Text("80");

        nombrePersonaje = new Div();
        nombrePersonaje2 = new Div();

        numeroPersonaje = new Div();
        numeroPersonaje2 = new Div();

        numeroPersonaje.add(numero);
        numeroPersonaje2.add(numero2);

        nombrePersonaje.add(nombre1);
        nombrePersonaje2.add(nombre2);

        numeroPersonaje.setClassName("numeroP1");
        numeroPersonaje2.setClassName("numeroP2");

        nombrePersonaje.setClassName("nombreP1");
        nombrePersonaje2.setClassName("nombreP2");

        j1p2 = new Div();
        j1p3 = new Div();

        j2p2 = new Div();
        j2p3 = new Div();

        j1p2img = new Image("https://www.metared.org/content/dam/metared/black.png", "empty");
        j1p3img = new Image("https://www.metared.org/content/dam/metared/black.png", "empty");

        j2p2Img = new Image("https://www.metared.org/content/dam/metared/black.png", "empty");
        j2p3Img = new Image("https://www.metared.org/content/dam/metared/black.png", "empty");

        j1p2img.setWidth("62px");
        j1p3img.setWidth("62px");
        j1p2img.setHeight("80px");
        j1p3img.setHeight("80px");
        j1p2.add(j1p2img);
        j1p3.add(j1p3img);

        j2p2Img.setWidth("62px");
        j2p3Img.setWidth("62px");
        j2p2Img.setHeight("80px");
        j2p3Img.setHeight("80px");
        j2p2.add(j2p2Img);
        j2p3.add(j2p3Img);

        j1p2p3 = new HorizontalLayout();
        j1p2p3.add(j1p2, j1p3);
        j1p2p3.addClassName("j1p2p3");
        j1p2p3.setJustifyContentMode(JustifyContentMode.CENTER);

        j2p2p3 = new HorizontalLayout();
        j2p2p3.add(j2p2, j2p3);
        j2p2p3.addClassName("j2p2p3");
        j2p2p3.setJustifyContentMode(JustifyContentMode.CENTER);

        conImg1.add(j1p2p3, j1p1Img, nombrePersonaje, numeroPersonaje);
        conImg2.add(j2p2p3, j2p1Img, nombrePersonaje2, numeroPersonaje2);
        jugador1 = new Jugador(escenario1,"Arena",escenario1.getNumMonedas());
        jugador2 = new Jugador(escenario1,"Macaco",escenario1.getNumMonedas());
        System.out.println("Monedas jugador" + jugador1.getNum_monedas_jugador());
        base.add(personajes1, conImg1, conImg2, personajes2);
        add(base);
        setClassName("personajeView");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
    }

    private void crearLista() {
        superheroeList = mongoDB.allHeroes();
    }

    private void accionHover() {
        UI ui = UI.getCurrent();
        new Thread(() -> {
            try {
                Thread.sleep(1);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            //todo acceder a imagenes a través de mongo

            ui.access(() -> doc.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(10).getImgCompleto(), superheroeList.get(10), superheroeList.get(10).getImgFace())));
            ui.access(() -> thor.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(7).getImgCompleto(), superheroeList.get(7), superheroeList.get(7).getImgFace())));
            ui.access(() -> dead.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(11).getImgCompleto(), superheroeList.get(11), superheroeList.get(11).getImgFace())));
            ui.access(() -> punish.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(1).getImgCompleto(), superheroeList.get(1), superheroeList.get(1).getImgFace())));
            ui.access(() -> capi.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(5).getImgCompleto(), superheroeList.get(5), superheroeList.get(5).getImgFace())));
            ui.access(() -> loki.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(0).getImgCompleto(), superheroeList.get(0), superheroeList.get(0).getImgFace())));
            ui.access(() -> spider.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(6).getImgCompleto(), superheroeList.get(6), superheroeList.get(6).getImgFace())));
            ui.access(() -> wol.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(8).getImgCompleto(), superheroeList.get(8), superheroeList.get(8).getImgFace())));
            ui.access(() -> iron.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(9).getImgCompleto(), superheroeList.get(9), superheroeList.get(9).getImgFace())));
            ui.access(() -> capMar.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(3).getImgCompleto(), superheroeList.get(3), superheroeList.get(3).getImgFace())));
            ui.access(() -> panther.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(2).getImgCompleto(), superheroeList.get(2), superheroeList.get(2).getImgFace())));
            ui.access(() -> hulk.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(4).getImgCompleto(), superheroeList.get(4), superheroeList.get(4).getImgFace())));

            ui.access(() -> doc2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(10).getImgCompleto(), superheroeList.get(10), superheroeList.get(10).getImgFace())));
            ui.access(() -> thor2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(7).getImgCompleto(), superheroeList.get(7), superheroeList.get(7).getImgFace())));
            ui.access(() -> dead2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(11).getImgCompleto(), superheroeList.get(11), superheroeList.get(11).getImgFace())));
            ui.access(() -> punish2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(1).getImgCompleto(), superheroeList.get(1), superheroeList.get(1).getImgFace())));
            ui.access(() -> capi2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(5).getImgCompleto(), superheroeList.get(5), superheroeList.get(5).getImgFace())));
            ui.access(() -> loki2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(0).getImgCompleto(), superheroeList.get(0), superheroeList.get(0).getImgFace())));
            ui.access(() -> spider2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(6).getImgCompleto(), superheroeList.get(6), superheroeList.get(6).getImgFace())));
            ui.access(() -> wol2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(8).getImgCompleto(), superheroeList.get(8), superheroeList.get(8).getImgFace())));
            ui.access(() -> iron2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(9).getImgCompleto(), superheroeList.get(9), superheroeList.get(9).getImgFace())));
            ui.access(() -> capMar2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(3).getImgCompleto(), superheroeList.get(3), superheroeList.get(3).getImgFace())));
            ui.access(() -> panther2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(2).getImgCompleto(), superheroeList.get(2), superheroeList.get(2).getImgFace())));
            ui.access(() -> hulk2.getElement().addEventListener("mouseover", e -> hoverAux(superheroeList.get(4).getImgCompleto(), superheroeList.get(4), superheroeList.get(4).getImgFace())));


        }).start();


    }

    private void hoverAux(String imgCompleto, Superheroe superheroe, String imgFace) {

        // Selecciona valores al pasar el ratón del personaje 1 del jugador 1

        System.out.println(axuHeroesSeleccionados.size());
        System.out.println(superheroesSeleccionados.size());

        if (j1p1Img.getAlt().toString().equals("Optional[empty]")) {
            j1p1Img.setSrc(imgCompleto);
            nombre1.setText(superheroe.getAliasSuperheroe());
            afiliacion.setText(superheroe.getAfiliacion());
            costeTxt.setText(String.valueOf(superheroe.getCoste()) + "$");
            numero.setText(String.valueOf(superheroe.getMediaPoder()));
        }

        // Selecciona valores al pasar el ratón del personaje 2 del jugador 1

        if (j1p1Img.getAlt().toString().equals("Optional[full]") && superheroesSeleccionados.size() == 1) {
            j1p2img.setSrc(imgFace);
            nombre1.setText(superheroesSeleccionados.get(0).getAliasSuperheroe() + " | " + superheroe.getAliasSuperheroe());
            afiliacion.setText(superheroesSeleccionados.get(0).getAfiliacion() + " | " + superheroe.getAfiliacion());
            costeTxt.setText(String.valueOf(superheroe.getCoste()) + "$");
            numero.setText(String.valueOf(superheroe.getMediaPoder()));
        }

        // Selecciona valores al pasar el ratón del personaje 3 del jugador 1

        if (j1p1Img.getAlt().toString().equals("Optional[full]") && superheroesSeleccionados.size() == 2) {
            j1p3img.setSrc(imgFace);
            nombre1.setText(superheroesSeleccionados.get(0).getAliasSuperheroe() + " | " + superheroesSeleccionados.get(1).getAliasSuperheroe() + " | " + superheroe.getAliasSuperheroe());
            afiliacion.setText(superheroesSeleccionados.get(0).getAfiliacion() + " | " + superheroesSeleccionados.get(1).getAfiliacion() + " | " + superheroe.getAfiliacion());
            costeTxt.setText(String.valueOf(superheroe.getCoste()) + "$");
            numero.setText(String.valueOf(superheroe.getMediaPoder()));
        }

        // Selecciona valores al pasar el ratón del personaje 1 del jugador 2

        if (j2p1Img.getAlt().toString().equals("Optional[ff]") && axuHeroesSeleccionados.size() == 0 && superheroesSeleccionados.size() == 3) {
            System.out.println("Entrando");
            j2p1Img.setSrc(imgCompleto);
            nombre2.setText(superheroe.getAliasSuperheroe());
            afiliacion2.setText(superheroe.getAfiliacion());
            costeTxt2.setText(String.valueOf(superheroe.getCoste()) + "$");
            numero2.setText(String.valueOf(superheroe.getMediaPoder()));
        }

        // Selecciona valores al pasar el ratón del personaje 2 del jugador 2

        if (j2p1Img.getAlt().toString().equals("Optional[full]") && axuHeroesSeleccionados.size() == 1) {
            System.out.println("Superherores seleccionados aux" + axuHeroesSeleccionados.size());
            System.out.println("Superherores seleccionados" + superheroesSeleccionados.size());
            j2p2Img.setSrc(imgFace);
            nombre2.setText(axuHeroesSeleccionados.get(0).getAliasSuperheroe() + " | " + superheroe.getAliasSuperheroe());
            afiliacion2.setText(axuHeroesSeleccionados.get(0).getAfiliacion() + " | " + superheroe.getAfiliacion());
            costeTxt2.setText(String.valueOf(superheroe.getCoste()) + "$");
            numero2.setText(String.valueOf(superheroe.getMediaPoder()));
        }

        // Selecciona valores al pasar el ratón del personaje 3 del jugador 2

        if (j2p1Img.getAlt().toString().equals("Optional[full]") && axuHeroesSeleccionados.size() == 2) {
            j2p3Img.setSrc(imgFace);
            nombre2.setText(axuHeroesSeleccionados.get(0).getAliasSuperheroe() + " | " + axuHeroesSeleccionados.get(1).getAliasSuperheroe() + " | " + superheroe.getAliasSuperheroe());
            afiliacion2.setText(axuHeroesSeleccionados.get(0).getAfiliacion() + " | " + axuHeroesSeleccionados.get(1).getAfiliacion() + " | " + superheroe.getAfiliacion());
            costeTxt2.setText(String.valueOf(superheroe.getCoste()) + "$");
            numero2.setText(String.valueOf(superheroe.getMediaPoder()));
        }

    }

    private void accionAdd() {
        System.out.println("entrando");
        doc.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(10), doc);
            }
        });
        thor.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(7), thor);
            }
        });

        spider.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(6), spider);

            }
        });
        wol.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(8), wol);

            }
        });
        dead.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(11), dead);

            }
        });
        capi.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(5), capi);

            }
        });
        loki.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(0), loki);

            }
        });
        punish.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(1), punish);

            }
        });
        panther.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(2), panther);

            }
        });
        capMar.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(3), capMar);

            }
        });
        hulk.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(4), hulk);

            }
        });
        iron.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(9), iron);

            }
        });
        doc2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(10), doc2);
            }
        });
        thor2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(7), thor2);
            }
        });

        spider2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(6), spider2);

            }
        });
        wol2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(8), wol2);

            }
        });
        dead2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(11), dead2);

            }
        });
        capi2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(5), capi2);

            }
        });
        loki2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(0), loki2);

            }
        });
        punish2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(1), punish2);

            }
        });
        panther2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(2), panther2);

            }
        });
        capMar2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(3), capMar2);

            }
        });
        hulk2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(4), hulk2);

            }
        });
        iron2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                addAux(superheroeList.get(9), iron2);

            }
        });

    }

    private void addAux(Superheroe superheroe, Button btn) {
        superheroe.setEnergiaVital(escenario1.getEnergiaVital());
        if (superheroesSeleccionados.size() <= 2 && jugador1.getNum_monedas_jugador() >= superheroe.getCoste() && axuHeroesSeleccionados.size() == 0) {
            superheroesSeleccionados.add(superheroe);
            jugador1.setNum_monedas_jugador(jugador1.getNum_monedas_jugador() - superheroe.getCoste());
            coinValueJ1.setText(String.valueOf(jugador1.getNum_monedas_jugador()));
            btn.getStyle().set("opacity", " 0.6");
            if (superheroesSeleccionados.size() <= 1) {
                System.out.println(superheroesSeleccionados.get(0).getAliasSuperheroe());
                j1p1Img.getStyle().set("filter", "drop-shadow(5px 5px 6px white)");
                btn.setEnabled(false);
                j1p1Img.setEnabled(false);
                j1p1Img.setAlt("full");
            } else if (superheroesSeleccionados.size() <= 2) {
                System.out.println(superheroesSeleccionados.get(1).getAliasSuperheroe());
                j1p2img.getStyle().set("filter", "drop-shadow(5px 5px 6px white)");
                btn.setEnabled(false);
                j1p2img.setEnabled(false);
                j1p2img.setAlt("full");
            } else {
                equipo1.setListaSuperheroe(superheroesSeleccionados);
                jugador1.setEquipo(equipo1);

                j1p3img.getStyle().set("filter", "drop-shadow(5px 5px 6px white)");
                j1p3img.setEnabled(false);
                doc.setEnabled(false);
                thor.setEnabled(false);
                spider.setEnabled(false);
                punish.setEnabled(false);
                hulk.setEnabled(false);
                iron.setEnabled(false);
                dead.setEnabled(false);
                panther.setEnabled(false);
                capi.setEnabled(false);
                capMar.setEnabled(false);
                loki.setEnabled(false);
                wol.setEnabled(false);
                doc2.setEnabled(true);
                thor2.setEnabled(true);
                spider2.setEnabled(true);
                punish2.setEnabled(true);
                hulk2.setEnabled(true);
                iron2.setEnabled(true);
                dead2.setEnabled(true);
                panther2.setEnabled(true);
                capi2.setEnabled(true);
                capMar2.setEnabled(true);
                loki2.setEnabled(true);
                wol2.setEnabled(true);

                doc2.getStyle().set("opacity", " 1");
                thor2.getStyle().set("opacity", " 1");
                spider2.getStyle().set("opacity", " 1");
                punish2.getStyle().set("opacity", " 1");
                hulk2.getStyle().set("opacity", " 1");
                iron2.getStyle().set("opacity", " 1");
                dead2.getStyle().set("opacity", " 1");
                panther2.getStyle().set("opacity", " 1");
                capi2.getStyle().set("opacity", " 1");
                capMar2.getStyle().set("opacity", " 1");
                loki2.getStyle().set("opacity", " 1");
                wol2.getStyle().set("opacity", " 1");

                doc.getStyle().set("opacity", " 0.6");
                thor.getStyle().set("opacity", " 0.6");
                spider.getStyle().set("opacity", " 0.6");
                punish.getStyle().set("opacity", " 0.6");
                hulk.getStyle().set("opacity", " 0.6");
                iron.getStyle().set("opacity", " 0.6");
                dead.getStyle().set("opacity", " 0.6");
                panther.getStyle().set("opacity", " 0.6");
                capi.getStyle().set("opacity", " 0.6");
                capMar.getStyle().set("opacity", " 0.6");
                loki.getStyle().set("opacity", " 0.6");
                wol.getStyle().set("opacity", " 0.6");
                costeContainer2.setVisible(true);
                costeContainer1.setVisible(false);


            }
            // btn.setEnabled(false);

        } else if (axuHeroesSeleccionados.size() <= 2 && jugador2.getNum_monedas_jugador() >= superheroe.getCoste() && superheroesSeleccionados.size() == 3) {
            axuHeroesSeleccionados.add(superheroe);
            jugador2.setNum_monedas_jugador(jugador2.getNum_monedas_jugador() - superheroe.getCoste());
            coinValueJ2.setText(String.valueOf(jugador2.getNum_monedas_jugador()));

            if (axuHeroesSeleccionados.size() == 1) {
                j2p1Img.getStyle().set("filter", "drop-shadow(5px 5px 6px white)");
                btn.setEnabled(false);
                System.out.println(axuHeroesSeleccionados.get(0).getAliasSuperheroe());
                j2p1Img.setEnabled(false);
                j2p1Img.setAlt("full");
            } else if (axuHeroesSeleccionados.size() <= 2) {
                j2p2Img.getStyle().set("filter", "drop-shadow(5px 5px 6px white)");
                btn.setEnabled(false);
                System.out.println(axuHeroesSeleccionados.get(1).getAliasSuperheroe());
                j2p2Img.setEnabled(false);
                j2p2Img.setAlt("full");
            } else {
                equipo2.setListaSuperheroe(axuHeroesSeleccionados);
                jugador2.setEquipo(equipo2);
                j2p3Img.getStyle().set("filter", "drop-shadow(5px 5px 6px white)");
                btn.setEnabled(false);
                j2p3Img.setEnabled(false);
                doc2.setEnabled(false);
                thor2.setEnabled(false);
                spider2.setEnabled(false);
                punish2.setEnabled(false);
                hulk2.setEnabled(false);
                iron2.setEnabled(false);
                dead2.setEnabled(false);
                panther2.setEnabled(false);
                capi2.setEnabled(false);
                capMar2.setEnabled(false);
                loki2.setEnabled(false);
                wol2.setEnabled(false);

                doc2.getStyle().set("opacity", " 0.6");
                thor2.getStyle().set("opacity", " 0.6");
                spider2.getStyle().set("opacity", " 0.6");
                punish2.getStyle().set("opacity", " 0.6");
                hulk2.getStyle().set("opacity", " 0.6");
                iron2.getStyle().set("opacity", " 0.6");
                dead2.getStyle().set("opacity", " 0.6");
                panther2.getStyle().set("opacity", " 0.6");
                capi2.getStyle().set("opacity", " 0.6");
                capMar2.getStyle().set("opacity", " 0.6");
                loki2.getStyle().set("opacity", " 0.6");
                wol2.getStyle().set("opacity", " 0.6");
                costeContainer2.setVisible(false);


                btnPartida = new Button("Iniciar Partida");
                btnPartida.addClassName("btnPartida");
                add(btnPartida);
                btnPartida.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
                    @Override
                    public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                        ComponentUtil.setData(UI.getCurrent(),"jugador1",jugador1);
                        ComponentUtil.setData(UI.getCurrent(),"jugador2",jugador2);
                        getUI().ifPresent(ui -> ui.navigate(PartidaView.class));
                    }
                });
            }
            btn.setEnabled(false);

        }

    }


    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        mongoDB = new MongoDB();
        mongoDB.conectionMongo();
        escenario1 = mongoDB.obtenerEscenario(s);
        System.out.println(escenario1.getNombreEscenario());
        //addClassName("personaje-view");
        instaciarInicializar();
        crearLista();
        accionHover();
        accionAdd();
        setSizeFull();
    }
}
