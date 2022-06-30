package com.example.application.views;

import com.example.application.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;

import javax.annotation.security.PermitAll;

@PageTitle("Doctor Strange | Main")
@Route(value = "main")
@RouteAlias(value = "")
@CssImport("../frontend/themes/doctorstrange/styles.css")

@PermitAll
public class MainLayout extends VerticalLayout {
    private final SecurityService securityService;

    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;
        createHeader();
    }

    private void createHeader() {
        addClassName("main");
        // Cambio de view al pulsar botón iniciar
        RouterLink menuLink = new RouterLink("Menu", MenuView.class);
        menuLink.addClassName("btnIniciar");
        add(menuLink);
        setSizeFull();
        setAlignItems(FlexComponent.Alignment.CENTER);



    }


}
