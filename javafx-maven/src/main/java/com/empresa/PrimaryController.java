package com.empresa;

import java.io.IOException;

import com.empresa.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    String username="admin";
    String password="admin";
    @FXML
    private Label lbMensaje;

    @FXML
    private TextField txtCodigoDos;

    @FXML
    private TextField txtCodigo;

    @FXML
    private void switchToSecondary() throws IOException {

        lbMensaje.setText("Error en la contraseña");
        //txtCodigoDos.setText(txtCodigo.getText());
        /*if(txtCodigo.getText().equals("101"))
            App.setRoot("secondary");
        else
            System.out.println("No existe el codigo");*/
    }
    @FXML
    private void switchToCreditos() throws IOException {

        App.setRoot("creditos");

    }
}
