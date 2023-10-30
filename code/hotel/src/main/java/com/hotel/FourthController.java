package com.hotel;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;

public class FourthController {

    Connection con;
    ResultSet rs;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fechaCaducidad;

    @FXML
    private TextField cvv;

    @FXML
    private TextField numTarjeta;

    @FXML
    void interroganteDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("El CVV es el numero de 3 dígitos que hay detrás de la tarjeta de crédito");
        alert.show();
    }

    @FXML
    void interroganteFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    /**
     * Método que genera un numero random entre 0 y 1000
     * 
     * @since 1.0
     * @return devuelve el numero aleatorio como entero
     * @see Random
     */
    public static int generarNumeroAleatorio() {
        return new Random().nextInt(900) + 100;
    }

    /**
     * Método que genera un numero aleatorio de tres cifras
     * 
     * @since 1.0
     * @param event Evento del boton
     *              {@link #generarNumeroAleatorio()}
     */
    @FXML
    void cvvRandom(ActionEvent event) {
        generarNumeroAleatorio();
        cvv.setText(String.valueOf(generarNumeroAleatorio()));
    }

    /**
     * Método que genera un numero String de formato tarjeta de credito
     * 
     * @since 1.0
     * @return devuelve ese numero
     * @see StringBuilder
     *      {@link #generarBloque()}
     */
    public String generarNumero() {
        StringBuilder numero = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            numero.append(generarBloque());
            if (i < 3) {
                numero.append("-");
            }
        }
        return numero.toString();
    }

    /**
     * Método que genera un bloque de cuatro numeros aleatorios para el numero de la
     * tarjeta
     * 
     * @since 1.0
     * @return devuelve el numero en formato de 4 en 4
     * @see Math
     */
    public String generarBloque() {
        int min = 0;
        int max = 9999;
        int numeroAleatorio = (int) (Math.random() * (max - min + 1) + min);
        return String.format("%04d", numeroAleatorio);
    }

    @FXML
    void numTarjetaAuto(ActionEvent event) {
        String numeroGenerado = generarNumero();
        numTarjeta.setText(numeroGenerado);
    }

    /**
     * Método que genera una fecha de caducidad de tarjeta aleatoria
     * 
     * @since 1.0
     * @return devuelve la fecha en formato dd/mm
     * @see Random
     */
    public static String generarNumeroFecha() {
        Random random = new Random();
        int mes = random.nextInt(12) + 1;
        int dia = random.nextInt(31) + 1;
        return String.format("%02d/%02d", dia, mes);
    }

    @FXML
    void fechaRandom(ActionEvent event) {
        String fechaGenerada = generarNumeroFecha();
        fechaCaducidad.setText(fechaGenerada);
    }

    @FXML
    void Cancelar(ActionEvent event) throws IOException {
        App.setRoot("primary");

    }

    @FXML
    void pagar(ActionEvent event) throws SQLException, NumberFormatException {

        try {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM Reserva",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // Para poder desplazarse
            rs = stmt.executeQuery();

            rs.moveToInsertRow();

            rs.updateInt("numPersonas", Reserva.getNumPers());

            rs.updateString("fehaInicio", Reserva.getFechaIni());

            rs.updateString("fechaFin", Reserva.getFechaFin());

            rs.updateString("regimen", Reserva.getRegimen());

            rs.updateString("numTarjeta", numTarjeta.getText());

            rs.updateInt("cvv", Integer.parseInt(cvv.getText()));

            rs.updateString("fechaCaducidad", fechaCaducidad.getText());

            // rs.updateString("nombreDeUsuario", user.getNombreDeUsuario());

            rs.updateString("nombreDeUsuario", Usuario.getInstance().getNombreDeUsuario());

            rs.updateString("nombreHotel", Hotel.getInstance().getNombreHotel());

            rs.insertRow();
            rs.moveToCurrentRow();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Pago realizado con éxito, su reserva se ha completado");
            alert.show();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void salir(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() throws IOException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelProyecto", "root", "admini");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
