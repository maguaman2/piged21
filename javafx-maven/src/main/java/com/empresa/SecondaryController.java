package com.empresa;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController implements Initializable {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtEmail;

    @FXML
    private CheckBox chkEstado;

    @FXML
    private TextField txtFind;

    @FXML
    private Label lbValidar;

    @FXML
    private TableView<Client> tbClientes;

    @FXML
    private TableColumn<Client, Integer> colId;

    @FXML
    private TableColumn<Client,String> colNombre;

    @FXML
    private TableColumn<Client, String> colDireccion;

    @FXML
    private TableColumn<Client, String> colTelefono;

    @FXML
    private TableColumn<Client, String> colEmail;

    @FXML
    private TableColumn<Client, Boolean> colEstado;

    ObservableList<Client> obsList = FXCollections.observableArrayList();

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void selectClient() throws IOException {
        ObservableList<Client> row;
        row = tbClientes.getSelectionModel().getSelectedItems();
        if(row.size()>0){
            txtId.setText(""+row.get(0).getId());
            txtNombre.setText(row.get(0).getNombre());
            txtDireccion.setText(row.get(0).getDireccion());
            txtTelefono.setText(row.get(0).getTelefono());
            txtEmail.setText(row.get(0).getEmail());
            chkEstado.setSelected(row.get(0).isEstado());
        }

    }

    @FXML
    private void saveClient() throws IOException {
        if (validarData()) {
            try {
                Client cliente = new Client(
                        txtNombre.getText(),
                        txtDireccion.getText(),
                        txtTelefono.getText(),
                        txtEmail.getText(),
                        chkEstado.isSelected());
                ClientDao clienteDao = new ClientDao();
                clienteDao.insertarUsuario(cliente);
                cargarTableView();
            } catch (Exception ex) {
                System.out.println("Datos mal ingresados" + ex.getMessage());
            }
        }
    }

    private boolean validarData(){
        boolean valida = true;
        lbValidar.setText("");
        if (txtTelefono.getText().matches("^[0-9]{7,10}$")){
            valida = true;
        }else{
            valida = false;
        }
        lbValidar.setText("Telefono es invalido");
        return valida;
    }

    @FXML
    private void deleteClient() throws IOException {
        try {

            ClientDao clienteDao= new ClientDao();
            clienteDao.eliminarCliente(Integer.parseInt(txtId.getText()));
            cargarTableView();
        }catch (Exception ex){
            System.out.println("Datos mal ingresados"+ex.getMessage());
        }

    }

    @FXML
    private void findClient() throws IOException {
        tbClientes.getItems().clear();
        ClientDao clientDao = new ClientDao();
        for (Client cliente:clientDao.buscarClient(txtFind.getText()))
        {
            obsList.add(cliente);
        }
        tbClientes.setItems(obsList);

    }
    @FXML
    private void newClient() throws IOException {
        txtId.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        chkEstado.setSelected(false);
        txtNombre.requestFocus();

    }


    @FXML
    private void updateClient() throws IOException {
        if (validarData()) {
            try {
                Client cliente = new Client(
                        Integer.parseInt(txtId.getText()),
                        txtNombre.getText(),
                        txtDireccion.getText(),
                        txtTelefono.getText(),
                        txtEmail.getText(),
                        chkEstado.isSelected());

                ClientDao clienteDao = new ClientDao();
                clienteDao.actualizarCliente(cliente);
                cargarTableView();
            } catch (Exception ex) {
                System.out.println("Datos mal ingresados" + ex.getMessage());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        System.out.println("Esto se ejecuta al arrancar");
        colId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Client, String>("nombre"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<Client, String>("direccion"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<Client, String>("telefono"));
        colEstado.setCellValueFactory(new PropertyValueFactory<Client, Boolean>("estado"));

        cargarTableView();

    }


    private void cargarTableView(){
        tbClientes.getItems().clear();
        ClientDao clienteDao = new ClientDao();

        for (Client cliente : clienteDao.listar()) {
            obsList.add(cliente);
        }
        tbClientes.setItems(obsList);
    }


}