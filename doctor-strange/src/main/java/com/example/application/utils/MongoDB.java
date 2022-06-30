package com.example.application.utils;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MongoDB {

    private MongoClient client = null;
    private MongoDatabase db = null;
    private Escenario escenarioSeleccionado;
    private List<Superheroe> allHeroes;
    private String nombre,contrasena,nombre1,contrasena1;

    public void conectionMongo() {
        client = MongoClients.create("mongodb+srv://AnaPozo:AnaPozo@cluster0.nnpyi.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        db = client.getDatabase("DoctorStrange");
    }

    public Escenario obtenerEscenario(String nombreEscenario) {
        String imagen = "";
        int monedasIniciales = 0, numJugadores = 0, numMovimientos = 0, energiaVital = 0;
        MongoCollection<Document> collection = db.getCollection("Escenarios");
        Document findDocument = new Document("_id", nombreEscenario);

        for (Document document : collection.find(findDocument)) {
            monedasIniciales = document.getInteger("Monedas_iniciales");
            numJugadores = document.getInteger("Numero_jugadores");
            numMovimientos = document.getInteger("Numero_movimientos");
            energiaVital = document.getInteger("Energia_vital");
            imagen = document.getString("Imagen");
        }


        escenarioSeleccionado = new Escenario(nombreEscenario, monedasIniciales, numJugadores, numMovimientos, energiaVital,
                imagen);
        return escenarioSeleccionado;
    }

    public List<Escenario> rellenarEscenario() {
        String imagen = "", nombreEscenario = "";
        int monedasIniciales = 0, numJugadores = 0, numMovimientos = 0, energiaVital = 0;
        MongoCollection<Document> collection = db.getCollection("Escenarios");
        List<Document> escenarios = new ArrayList<>();
        List<Escenario> escenariosFinal = new ArrayList<>();

        collection.find().iterator().forEachRemaining(escenarios::add);

        for (int i = 0; i < escenarios.size(); i++) {
            Document document = escenarios.get(i);
            nombreEscenario = document.getString("_id");
            monedasIniciales = document.getInteger("Monedas_iniciales");
            numJugadores = document.getInteger("Numero_jugadores");
            numMovimientos = document.getInteger("Numero_movimientos");
            energiaVital = document.getInteger("Energia_vital");
            imagen = document.getString("Imagen");
            Escenario escenarioSeleccionado = new Escenario(nombreEscenario, monedasIniciales, numJugadores, numMovimientos, energiaVital,
                    imagen);
            escenariosFinal.add(escenarioSeleccionado);
        }
        return escenariosFinal;
    }

    public List<Superheroe> allHeroes() {
        String identidadSecreta = null,origen= null,afiliacion= null,aliasSuperheroe=null;
        Integer coste = null;
        String img=null;
        String imgFace=null;
        int mediaPoder=0;
        ArrayList<String> ataque = null,defensa = null;
        List<Document> superheroes = new ArrayList<>();
        allHeroes = new ArrayList<>();

        MongoCollection<Document> collection = db.getCollection("SuperHeroesEnteros");

        collection.find().iterator().forEachRemaining(superheroes::add);

        for (int i = 0; i < superheroes.size(); i++) {
            Document document = superheroes.get(i);
            aliasSuperheroe = document.getString("_id");
            identidadSecreta = document.getString("identidadsecreta");
            origen = document.getString("origen");
            afiliacion = document.getString("afiliacion");

            Document docParrillapoderes = new Document((Map<String, Object>) document.get("parrillapoderes"));
            img = document.getString("img_completo");
            imgFace = document.getString("img_cara");
            int a =docParrillapoderes.getInteger("habilidadLucha");
            int b =docParrillapoderes.getInteger("proyeccionEnergia");
            int c =docParrillapoderes.getInteger("resistencia");
            int d =docParrillapoderes.getInteger("velocidad");
            int e =docParrillapoderes.getInteger("fuerza");
            int f =docParrillapoderes.getInteger("inteligencia");

            coste = (int) ((10000 / 3) * ((a+b+c+d+e+f) / 30.0));
            mediaPoder = a+b+c+d+e+f/6;
            Document docMovimientos = new Document((Map<String, Object>) document.get("movimientos"));
            ataque = (ArrayList) docMovimientos.get("ataque");
            defensa = (ArrayList) docMovimientos.get("defensa");

            Superheroe superheroe = new Superheroe(aliasSuperheroe,identidadSecreta,origen,afiliacion,coste,ataque,defensa,a,b,c,d,e,f,escenarioSeleccionado,img,imgFace,mediaPoder);
            allHeroes.add(superheroe);
        }
        return allHeroes;
    }

    public void usuario1(){
        nombre=null;contrasena=null;nombre1=null;contrasena1=null;
        MongoCollection<Document> collection = db.getCollection("usuario");
        Document findDocument = new Document("nombre", "Ana");

        for (Document document : collection.find(findDocument)) {
            nombre = document.getString("email");
            contrasena = document.getString("password");
        }

    }

    public void superheroe(){
        MongoCollection<Document> collection = db.getCollection("superheroes");
        Document findDocument = new Document("superheroes", "valor de la key del el array superheroe");

        for (Document document : collection.find(findDocument)) {
            Document document1 = new Document("Object","0");
        }
    }

    public void usuario2(){
        nombre1=null;contrasena1=null;
        MongoCollection<Document> collection = db.getCollection("usuarios");
        Document findDocument = new Document("usuario", "hafehgefajhgkaefgjh");
        for (Document document : collection.find(findDocument)) {
            nombre1 = document.getString("email");
            contrasena1 = document.getString("password");
        }
        setNombre1(nombre1);
        setContrasena1(contrasena1);
        System.out.println(nombre1+" "+contrasena1);
    }

    public void subirJugador(){

    }

    public Jugador getJugador(){

        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getContrasena1() {
        return contrasena1;
    }

    public void setContrasena1(String contrasena1) {
        this.contrasena1 = contrasena1;
    }

    public List<Superheroe> getAllHeroes() {
        return allHeroes;
    }
    public void setAllHeroes(List<Superheroe> allHeroes) {
        this.allHeroes = allHeroes;
    }
}
