package com.example.application.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import javax.annotation.security.PermitAll;

@PageTitle("Doctor Strange | Menu")
@Route(value = "menu")
@PermitAll
@CssImport("../frontend/themes/doctorstrange/styles.css")

public class MenuView extends VerticalLayout {

    public MenuView() {

        addClassName("menu");
        RouterLink iniciarLink = new RouterLink("Iniciar", EscenarioView.class);
        RouterLink opcionesLink = new RouterLink("Opciones", MenuView.class);
        RouterLink salirLink = new RouterLink("Salir", MenuView.class);

        iniciarLink.addClassName("btnMenu1");
        opcionesLink.addClassName("btnMenu2");
        salirLink.addClassName("btnMenu3");

        add(iniciarLink,opcionesLink,salirLink);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");



        }




}
