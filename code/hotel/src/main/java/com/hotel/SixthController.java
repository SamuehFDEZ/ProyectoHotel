package com.hotel;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SixthController {

    Connection con;

    ResultSet rs;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<ReservaTableView, Integer> cvvTable;

    @FXML
    private TableColumn<ReservaTableView, String> fechaCaducidadTable;

    @FXML
    private TableColumn<ReservaTableView, String> fechaFinTable;

    @FXML
    private TableColumn<ReservaTableView, String> fehaInicioTable;

    @FXML
    private TableColumn<ReservaTableView, Integer> idResTable;

    @FXML
    private TableColumn<ReservaTableView, String> nombreDeUsuarioTable;

    @FXML
    private TableColumn<ReservaTableView, String> nombreHotelTable;

    @FXML
    private TableColumn<ReservaTableView, Integer> numPersonasTable;

    @FXML
    private TableColumn<ReservaTableView, String> numTarjetaTable;

    @FXML
    private TableColumn<ReservaTableView, String> regimenTable;

    @FXML
    private TableView<ReservaTableView> table;

    ObservableList<ReservaTableView> listaReservaTableView;

    @FXML
    void volver(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void salir(MouseEvent event) {
        Platform.exit();
    }
    
    @FXML
    void initialize() {

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelProyecto", "root", "admini");
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM Reserva",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // Para poder desplazarse
            rs = stmt.executeQuery();
            rs.first();

            // Define el OrbservableList con un objeto de FXCollections
            listaReservaTableView = FXCollections.observableArrayList();
            ReservaTableView.llenarReservaTableView(listaReservaTableView); // Cargo la tabla
                                                                            // tablaEmpleados.setItems(listaEmpleados);
            table.setItems(listaReservaTableView);
            idResTable.setCellValueFactory(new PropertyValueFactory<ReservaTableView, Integer>("idRes"));
            numPersonasTable.setCellValueFactory(new PropertyValueFactory<ReservaTableView, Integer>("numPersonas"));
            fehaInicioTable.setCellValueFactory(new PropertyValueFactory<ReservaTableView, String>("fehaInicio"));
            fechaFinTable.setCellValueFactory(new PropertyValueFactory<ReservaTableView, String>("fechaFin"));
            regimenTable.setCellValueFactory(new PropertyValueFactory<ReservaTableView, String>("regimen"));
            numTarjetaTable.setCellValueFactory(new PropertyValueFactory<ReservaTableView, String>("numTarjeta"));
            cvvTable.setCellValueFactory(new PropertyValueFactory<ReservaTableView, Integer>("cvv"));
            fechaCaducidadTable
                    .setCellValueFactory(new PropertyValueFactory<ReservaTableView, String>("fechaCaducidad"));
            nombreDeUsuarioTable
                    .setCellValueFactory(new PropertyValueFactory<ReservaTableView, String>("nombreDeUsuario"));
            nombreHotelTable.setCellValueFactory(new PropertyValueFactory<ReservaTableView, String>("nombreHotel"));

            ListChangeListener<ReservaTableView> selectorTablaReservaTableView = new ListChangeListener<ReservaTableView>() {

                public void onChanged(ListChangeListener.Change<? extends ReservaTableView> e) {
                    ponerReservaTableViewSeleccionado();
                }

                public final ReservaTableView getTablaReservaTableViewsSeleccionado() {
                    if (table != null) {
                        List<ReservaTableView> tabla = table.getSelectionModel().getSelectedItems();
                        if (tabla.size() == 1) {
                            final ReservaTableView ReservaTableViewSeleccionado = (ReservaTableView) tabla.get(0);
                            return ReservaTableViewSeleccionado;
                        }
                    }
                    return null;
                }

                public final void ponerReservaTableViewSeleccionado() {
                    int h;
                    final ReservaTableView ReservaTableView = getTablaReservaTableViewsSeleccionado();
                    h = listaReservaTableView.indexOf(ReservaTableView);
                    if (ReservaTableView != null) {
                        numPersonasTable.setText(String.valueOf(com.hotel.Reserva.getNumPers()));
                        fehaInicioTable.setText(com.hotel.Reserva.getFechaIni());
                        fechaFinTable.setText(com.hotel.Reserva.getFechaFin());
                        regimenTable.setText(com.hotel.Reserva.getRegimen());
                        numTarjetaTable.setText(Banco.getNumTarjeta());
                        cvvTable.setText(String.valueOf(com.hotel.Banco.getCvv()));
                        fechaCaducidadTable.setText(Banco.getFechaCaducidad());
                        nombreDeUsuarioTable.setText(Usuario.getInstance().getNombreDeUsuario());
                        nombreHotelTable.setText(Hotel.getInstance().getNombreHotel());

                    }
                }
            };

            ObservableList<ReservaTableView> tablaReservaTableView = table.getSelectionModel().getSelectedItems();
            tablaReservaTableView.addListener(selectorTablaReservaTableView);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}