package com.empresa;

import com.empresa.App;
import javafx.fxml.FXML;

import java.io.IOException;

public class CreditosController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

}
