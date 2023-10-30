package com.hotel;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class ThirdController {

    Connection con;
    ResultSet rs;
    private String capital = "";

    Reserva res = new Reserva();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    protected TextField numeroPeople;

    @FXML
    protected DatePicker fechaEntrada;

    @FXML
    protected ComboBox<String> hotel;

    @FXML
    protected DatePicker fechaSalida;

    @FXML
    protected ComboBox<String> tipoDeRegimen;

    @FXML
    void barcelonaDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void barcelonaFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void balearesDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void balearesFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void valenciaDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void valenciaFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void logroñoDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void logroñoFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void madridDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void madridFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void meridaDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void meridaFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void muricaDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void muricaFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void oviedoDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void oviedoFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void palmaCanariaDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void palmaCanariaFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void pamplonaDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void pamplonaFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void santanderDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void santanderFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void sevillaDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void sevillaFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void santiagoDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void santiagoFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void tenerifeDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void tenerifeFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void toledoDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void toledoFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void valladolidDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void valladolidFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void vitoriaDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void vitoriaFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void zaragozaDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

    }

    @FXML
    void zaragozaFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void Cancelar(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Reserva cancelada");
        alert.showAndWait();
        App.setRoot("primary");
    }

    @FXML
    void barcelona(MouseEvent event) {
        capital = "barcelona";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void logroño(MouseEvent event) {
        capital = "logroño";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void madrid(MouseEvent event) {
        capital = "madrid";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void merida(MouseEvent event) {
        capital = "merida";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void murica(MouseEvent event) {
        capital = "murica";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void oviedo(MouseEvent event) {
        capital = "oviedo";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void palmaDeMallorca(MouseEvent event) {
        capital = "palmaDeMallorca";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void palmasCanaria(MouseEvent event) {
        capital = "palmasCanaria";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void pamplona(MouseEvent event) {
        capital = "pamplona";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void regimenSelector(MouseEvent event) {
        ObservableList<String> lista = FXCollections.observableArrayList();

        lista.addAll("Pensión Completa", "Todo Incluido", "Media Pensión");
        tipoDeRegimen.setItems(lista);
    }

    @FXML
    void reserva(ActionEvent event) throws IOException {
        String dateEntry = fechaEntrada.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String dateExit = fechaSalida.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        if (fechaEntrada.getValue().isAfter(fechaSalida.getValue())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No puedes escoger una fecha de entrada posterior a la fecha de salida");
            alert.showAndWait();
            return;
        }

        if (hotel.getValue() == null || numeroPeople.getText().isEmpty() ||
                fechaEntrada.getValue() == null || fechaSalida.getValue() == null ||
                tipoDeRegimen.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Debes completar todos los campos antes de proceder al pago.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Reserva realizada con éxito, procediendo al pago.");
            alert.showAndWait();
            res.setNumPers(Integer.parseInt(numeroPeople.getText()));
            res.setFechaIni(dateEntry);
            res.setFechaFin(dateExit);

            Hotel.getInstance().setNombreHotel(hotel.getValue());
            res.setRegimen(tipoDeRegimen.getValue());
            App.setRoot("fourth");
        }
    }

    @FXML
    void textNumPeople(ActionEvent event) {
        numeroPeople.getText();
    }

    @FXML
    void santander(MouseEvent event) {
        capital = "santander";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void santiago(MouseEvent event) {
        capital = "santiago";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void sevilla(MouseEvent event) {
        capital = "sevilla";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void tenerife(MouseEvent event) {
        capital = "tenerife";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void toledo(MouseEvent event) {
        capital = "toledo";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void valencia(MouseEvent event) {
        capital = "valencia";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void valladolid(MouseEvent event) {
        capital = "valladolid";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void vitoria(MouseEvent event) {
        capital = "vitoria";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void zaragoza(MouseEvent event) {
        capital = "zaragoza";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ubicación seleccionada");
        alert.showAndWait();
    }

    @FXML
    void hotelSelector(MouseEvent event) {
        ObservableList<String> lista = FXCollections.observableArrayList();

        if (capital.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Selecciona una ubicación");
            alert.showAndWait();
        }

        if (capital.equals("barcelona")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Hotel Arts Barcelona", "Hotel Casa Fuster", "W Barcelona");
            hotel.setItems(lista);
        }
        if (capital.equals("logroño")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Hotel Echaurren", "Hotel Marqués de Vallejo", "Hotel Villa de Ábalos");
            hotel.setItems(lista);
        }

        if (capital.equals("madrid")) {
            lista = FXCollections.observableArrayList();
            lista.addAll(" Gran Meliá Fénix", "Hotel Ritz Madrid", "The Westin Palace Madrid");
            hotel.setItems(lista);
        }
        if (capital.equals("merida")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Hotel Ilunion Mérida Palace", "Hotel Velada Mérida", "Parador de Mérida");
            hotel.setItems(lista);
        }
        if (capital.equals("murica")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Hotel Nelva", "Hotel Occidental Murcia Siete Coronas", "Hotel Tryp Murcia Rincón de Pepe");
            hotel.setItems(lista);
        }
        if (capital.equals("palmasCanaria")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("A Royal Hideaway Hotel", "Hotel Ritz Madrid", "The Westin Palace Madrid");
            hotel.setItems(lista);
        }
        if (capital.equals("oviedo")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Ayre Hotel Oviedo", "Gran Hotel España", "Hotel Barceló Oviedo Cervantes");
            hotel.setItems(lista);
        }
        if (capital.equals("palmaDeMallorca")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Boutique Hotel Calatrava", "GPRO Valparaiso Palace & Spa", "Hotel Nakar");
            hotel.setItems(lista);
        }
        if (capital.equals("pamplona")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Hotel NH Pamplona Iruña Park", "Hotel Palacio Guendulain", "Hotel Tres Reyes");
            hotel.setItems(lista);
        }
        if (capital.equals("tenerife")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Hotel Silken Atlántida", "Hotel Taburiente", "Iberostar Heritage Grand Mencey");
            hotel.setItems(lista);
        }
        if (capital.equals("santander")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Eurostars Hotel Real", "Gran Hotel Sardinero", "Hotel Bahía");
            hotel.setItems(lista);
        }
        if (capital.equals("santiago")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Hotel Eurostars Araguaney", "Hotel Virxe da Cerca", "Parador de Santiago de Compostela");
            hotel.setItems(lista);
        }
        if (capital.equals("sevilla")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Hotel Alfonso XIII", "Hotel Mercer Sevilla", "Hotel Palacio de Villapanés");
            hotel.setItems(lista);
        }
        if (capital.equals("toledo")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Hotel Cigarral El Bosque", "Hotel Eurostars Palacio Buenavista", "Parador de Toledo");
            hotel.setItems(lista);
        }
        if (capital.equals("valencia")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Hotel Las Arenas Balneario Resort", "SH Valencia Palace", "The Westin Valencia");
            hotel.setItems(lista);
        }
        if (capital.equals("valladolid")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("AC Hotel Palacio de Santa Ana", "Hotel NH Valladolid Bálago", "Hotel Olid");
            hotel.setItems(lista);
        }
        if (capital.equals("vitoria")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Gran Hotel Lakua", "Hotel NH Canciller Ayala Vitoria", "Hotel Silken Ciudad de Vitoria");
            hotel.setItems(lista);
        }
        if (capital.equals("zaragoza")) {
            lista = FXCollections.observableArrayList();
            lista.addAll("Hotel Alfonso", "Hotel Palafox", "Hotel Reina Petronila");
            hotel.setItems(lista);
        }

    }

    @FXML
    void interroganteDentro(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.HAND);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Todo Incluido: 100€/la noche" + " " + " " + " " + " " + " " + " " + " " + " "
                + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                + " "
                + " " + " " + " " + " " +
                " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                + "Pension Completa: 75€/la noche" + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " +
                " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                + " " + " " + " " + " " + " " + "Media Pensión: 50€/la noche");
        alert.show();
    }

    @FXML
    void interroganteFuera(MouseEvent event) {
        ((Node) event.getSource()).getScene().setCursor(Cursor.DEFAULT);

    }

    @FXML
    void salir(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() throws IOException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelProyecto", "root", "admini");
            Callback<DatePicker, DateCell> callB = new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker param) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                            LocalDate today = LocalDate.now();
                            setDisable(empty || item.compareTo(today) < 0);

                        }
                    };
                }
            };
            fechaEntrada.setDayCellFactory(callB);
            fechaSalida.setDayCellFactory(callB);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}