package com.empresa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static com.empresa.archivos.GestionArchivos.crearArchivo;
import static com.empresa.archivos.GestionArchivos.leerArchivo;

public class PrimaryController {

    @FXML
    private Label lbMensaje;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    List<Persona> lista = new ArrayList();;

    @FXML
    private void switchToSecondary() throws IOException {

        if(txtUserName.getText().equals("admin") && txtPassword.getText().equals("admin"))
            App.setRoot("secondary");
        else
            System.out.println("No existe el codigo");
    }
    @FXML
    private void switchToCreditos() throws IOException {

        App.setRoot("creditos");

    }

    @FXML
    private void addItem() throws IOException {

        Persona persona = new Persona(Integer.parseInt(txtId.getText()),txtNombre.getText());
        lista.add(persona);
        txtId.setText("");
        txtNombre.setText("");

        List<String> lineas = new ArrayList();
        lineas=leerArchivo("c:\\archivos\\prueba.txt");

        for (Object elemento :lineas ){

            System.out.println( elemento); //Casteo o convertir
        }

        /*Persona personaUno = new Persona(1,"Juan");
        Persona personaDos = new Persona(4,"Jose");
        Persona personaTres = new Persona(6,"Pablo");
        listaPersonas = new ArrayList();
        listaPersonas.add(personaUno);
        listaPersonas.add(personaDos);
        listaPersonas.add(personaTres);
        listaPersonas.add(new Persona(9,"Pedro"));*/


    }

    @FXML
    private void mostrarItems() throws IOException {

        for (Object elemento :lista ){

            System.out.println( ((Persona)elemento).getNombre()  ); //Casteo o convertir
        }


    }
}
