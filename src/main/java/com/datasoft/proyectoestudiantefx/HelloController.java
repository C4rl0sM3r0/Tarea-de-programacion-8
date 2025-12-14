package com.datasoft.proyectoestudiantefx;

import com.datasoft.proyectoestudiantefx.modelo.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML private TextField txtNombres;
    @FXML private TextField txtApellidos;
    @FXML private TextField txtEdad;
    @FXML private TextField txtEmail;

    @FXML private TableView<Estudiante> tablaEstudiantes;
    @FXML private TableColumn<Estudiante, String> colNombres;
    @FXML private TableColumn<Estudiante, String> colApellidos;
    @FXML private TableColumn<Estudiante, Integer> colEdad;
    @FXML private TableColumn<Estudiante, String> colEmail;

    private ObservableList<Estudiante> listaEstudiantes =
            FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colNombres.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getNombres()));

        colApellidos.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getApellidos()));

        colEdad.setCellValueFactory(data ->
                new SimpleObjectProperty<>(data.getValue().getEdad()));

        colEmail.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getEmail()));

        tablaEstudiantes.setItems(listaEstudiantes);
    }

    @FXML
    private void guardarEstudiante() {
        try {
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String email = txtEmail.getText();

            Estudiante nuevo = new Estudiante(nombres, apellidos, edad, email);
            listaEstudiantes.add(nuevo);
            limpiarCampos();

        } catch (NumberFormatException e) {
            mostrarError("La edad debe ser un número válido.");
        }
    }

    private void limpiarCampos() {
        txtNombres.clear();
        txtApellidos.clear();
        txtEdad.clear();
        txtEmail.clear();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }
}
