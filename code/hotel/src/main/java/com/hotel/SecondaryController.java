package com.hotel;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SecondaryController {
    ResultSet rs;
    Connection con;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField newUser;

    @FXML
    private TextField newPass;

    @FXML
    private TextField newName;

    @FXML
    void logIn(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void signUp(ActionEvent event) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Usuario",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // Para poder desplazarse
            rs = stmt.executeQuery();
            stmt.executeQuery();
            rs = stmt.executeQuery();

            if (newName.getText().isEmpty() || newUser.getText().isEmpty() || newPass.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Necesitas introducir un nombre, usuario y contraseña");
                alert.showAndWait();
                return;
            }

            while (rs.next()) {
                if (newUser.getText().equals(rs.getString("nombreDeUsuario"))) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Este usuario ya está registrado");
                    alert.showAndWait();
                }
            }

            rs.moveToInsertRow();
            rs.updateString("nombreDeUsuario", newUser.getText());
            rs.updateString("Nombre", newName.getText());
            rs.updateString("Contrasenya", newPass.getText());
            rs.insertRow();
            rs.moveToCurrentRow();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Usuario registrado");
            alert.showAndWait();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void salir(MouseEvent event) {
        Platform.exit();
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