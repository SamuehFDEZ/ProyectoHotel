package com.hotel;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import java.sql.ResultSet;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FifthController {

    Connection con;
    ResultSet rs;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField contrasenya;

    @FXML
    private TextField nombre;

    @FXML
    private TextField usuario;

    private DialogPane dialog;

    @FXML
    void enter(ActionEvent event) {
        if (nombre.getText().isEmpty() || usuario.getText().isEmpty() ||
                contrasenya.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Debes introducir un nombre, usuario y contraseña");
            alert.showAndWait();
            return;
        }

        try {

            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM Usuario WHERE nombreDeUsuario = 'SamuhFDEZ' AND Nombre = 'Samuel' AND Contrasenya = '123456789'");

            rs = stmt.executeQuery();

            if (usuario.getText().equals("SamuehFDEZ") && nombre.getText().equals("Samuel")
                    && contrasenya.getText().equals("123456789")) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Acceso concedido");
                alert.showAndWait();
                App.setRoot("sixth");
            } else {
                // Usuario y contraseña no coinciden
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Usuario y contraseña incorrectos");
                alert.showAndWait();

                dialog = alert.getDialogPane();
                dialog.getStylesheets().add(
                        getClass().getResource("alert.css").toExternalForm());
                dialog.getStyleClass().add("alert.css");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException x) {
            System.out.println(x.getMessage());
        }
    }

    @FXML
    void salir(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void volver(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void initialize() throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelProyecto", "root", "admini");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}