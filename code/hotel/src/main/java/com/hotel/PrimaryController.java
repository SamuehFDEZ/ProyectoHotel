package com.hotel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PrimaryController {

    Usuario user = new Usuario();

    Connection con;
    ResultSet rs;

    @FXML
    private TextField usuario;

    @FXML
    private TextField contrasenya;

    @FXML
    private TextField nombre;

    private DialogPane dialog;

    @FXML
    void salir(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void logIn(ActionEvent event) throws SQLException, IOException {

        if (nombre.getText().isEmpty() || usuario.getText().isEmpty() ||
                contrasenya.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Debes introducir un nombre, usuario y contraseña");
            alert.showAndWait();
            return;
        }

        try {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM Usuario WHERE nombreDeUsuario = ? AND Nombre = ? AND Contrasenya = ?");
            stmt.setString(1, usuario.getText());
            stmt.setString(2, nombre.getText());
            stmt.setString(3, contrasenya.getText());

            rs = stmt.executeQuery();

            if (rs.next()) {
                // Usuario y contraseña coinciden
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Acceso concedido");
                alert.showAndWait();
                Usuario.getInstance().setNombreDeUsuario(usuario.getText());
                App.setRoot("third");
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
    void signUp(ActionEvent event) throws IOException {
        App.setRoot("secondary");

    }

    @FXML
    void entrarAdmin(ActionEvent event) throws IOException {
        App.setRoot("fifth");

    }

    @FXML
    void initialize() throws SQLException {

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelProyecto", "root", "admini");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}