package com.example.application.views;

import com.example.application.utils.Escenario;
import com.example.application.utils.MongoDB;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Doctor Strange | Escenario")
@Route(value = "escenario")
@PermitAll
@CssImport("../frontend/themes/doctorstrange/styles.css")
public class EscenarioView extends VerticalLayout {

    private ArrayList<Escenario> listaEscenarios;
    private List<Escenario> escenariosRecuperados;
    private int numImagen = 0;
    private MongoDB mongoDB;
    private Image imagenEscenario;

    public EscenarioView() {
        addClassName("escenarioview");
        crearListas();
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.setAlignItems(Alignment.CENTER);
        add(verticalLayout);
        Label titulo = new Label("Selecciona un Escenario");
        titulo.setClassName("tituloEscenario");
        verticalLayout.add(titulo);
        Button btDerecha = new Button("Siguiente"), btIzquierda = new Button("Anterior");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(btIzquierda, btDerecha);
        verticalLayout.add(horizontalLayout);
        Label nombreEscenario = new Label(escenariosRecuperados.get(0).getNombreEscenario());
        nombreEscenario.addClassName("label");
        imagenEscenario.setWidth("600px");
        verticalLayout.add(imagenEscenario);
        verticalLayout.add(nombreEscenario);
        Button buttonNavigate = new Button("Seleccionar Personajes");
        verticalLayout.add(buttonNavigate);
        setSizeFull();


        btDerecha.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {

                numImagen = numImagen + 1;
                if (numImagen < 3) {
                    imagenEscenario.setSrc(escenariosRecuperados.get(numImagen).getImagen());
                    imagenEscenario.setWidth("600px");
                    nombreEscenario.setText(escenariosRecuperados.get(numImagen).getNombreEscenario());

                } else {
                    numImagen = numImagen - 1;
                }
            }
        });
        btIzquierda.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                numImagen = numImagen - 1;
                if (numImagen >= 0) {
                    imagenEscenario.setSrc(escenariosRecuperados.get(numImagen).getImagen());
                    imagenEscenario.setWidth("600px");
                    nombreEscenario.setText(escenariosRecuperados.get(numImagen).getNombreEscenario());
                } else {
                    numImagen = numImagen + 1;
                }
            }
        });
        verticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, horizontalLayout, imagenEscenario, nombreEscenario, buttonNavigate);
        buttonNavigate.addClickListener(e-> buttonNavigate.getUI().ifPresent(ui -> ui.navigate(
                PersonajeView.class, nombreEscenario.getText())
        ));
    }


    private void crearListas() {
        listaEscenarios = new ArrayList<>();
        escenariosRecuperados = new ArrayList<>();
        mongoDB = new MongoDB();
        mongoDB.conectionMongo();
        escenariosRecuperados = mongoDB.rellenarEscenario();
        imagenEscenario = new Image(escenariosRecuperados.get(0).getImagen(), "ff");
    }
}
