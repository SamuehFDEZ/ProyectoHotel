package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;

/**
 * Clase ReservaTableView
 * 
 * @version 1.0
 */
public class ReservaTableView {
    private int idRes;
    private int numPersonas;
    private String fehaInicio;
    private String fechaFin;
    private String regimen;
    private String numTarjeta;
    private int cvv;
    private String fechaCaducidad;
    private String nombreDeUsuario;
    private String nombreHotel;

    /**
     * Método que obtiene el identificador de la Reserva
     * 
     * @since 1.0
     * @return devuelve el identificador de la Reserva
     */
    public int getIdRes() {
        return idRes;
    }

    /**
     * Método que asigna un valor al identificador de la Reserva
     * 
     * @since 1.0
     * @param idRes identificador de la Reserva
     */
    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    /**
     * Método que obtiene el numero de personas
     * 
     * @since 1.0
     * @return devuelve el numero de personas
     */
    public int getNumPersonas() {
        return numPersonas;
    }

    /**
     * Método que asigna un valor al numero de personas
     * 
     * @since 1.0
     * @param numPersonas numero de personas
     */
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    /**
     * Método que obtiene la fecha de inicio
     * 
     * @since 1.0
     * @return devuelve la fecha de inicio
     */
    public String getFehaInicio() {
        return fehaInicio;
    }

    /**
     * Método que asigna un valor a la fecha de inicio
     * 
     * @since 1.0
     * @param fehaInicio fecha de inicio
     */
    public void setFehaInicio(String fehaInicio) {
        this.fehaInicio = fehaInicio;
    }

    /**
     * Método que obtiene la fecha final
     * 
     * @since 1.0
     * @return devuelve la fecha final
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * Método que asigna un valor a la fecha final
     * 
     * @since 1.0
     * @param fechaFin fecha final
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Método que obtiene el regimen
     * 
     * @since 1.0
     * @return devuelve el regimen
     */
    public String getRegimen() {
        return regimen;
    }

    /**
     * Método que asigna un valor al regimen
     * 
     * @since 1.0
     * @param regimen regimen
     */
    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    /**
     * Método que obtiene el numero de la tarjeta
     * 
     * @since 1.0
     * @return devuelve el numero de la tarjeta
     */
    public String getNumTarjeta() {
        return numTarjeta;
    }

    /**
     * Método que asigna un valor al numero de la tarjeta
     * 
     * @since 1.0
     * @param numTarjeta numero de la tarjeta
     */
    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    /**
     * Método que obtiene el cvv
     * 
     * @since 1.0
     * @return devuelve el cvv
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * Método que asigna un valor al cvv
     * 
     * @since 1.0
     * @param cvv cvv
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * Método que obtiene la fecha de caducidad
     * 
     * @since 1.0
     * @return devuelve la fecha de caducidad
     */
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Método que asigna un valor a la fecha de caducidad
     * 
     * @since 1.0
     * @param fechaCaducidad fecha de caducidad
     */
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     * Método que obtiene el nombre del usuario
     * 
     * @since 1.0
     * @return devuelve el nombre del usuario
     */
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    /**
     * Método que asigna un valor a el nombre del usuario
     * 
     * @since 1.0
     * @param nombreDeUsuario nombre del usuario
     */
    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    /**
     * Método que obtiene el nombre del hotel
     * 
     * @since 1.0
     * @return devuelve el nombre del hotel
     */
    public String getNombreHotel() {
        return nombreHotel;
    }

    /**
     * Método que asigna un valor al nombre del hotel
     * 
     * @since 1.0
     * @param nombreHotel nombre del hotel
     */
    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    /**
     * Constructor de la clase ReservaTableView
     * 
     * @since 1.0
     * @param idRes           identificador de la reserva
     * @param numPersonas     numero de persnas
     * @param fehaInicio      fecha de inicio
     * @param fechaFin        fecha del fin
     * @param regimen         regimen
     * @param numTarjeta      numero de la tarjeta
     * @param cvv             cvv
     * @param fechaCaducidad  fecha de caducidad de la tarjeta
     * @param nombreDeUsuario nombre de usuario
     * @param nombreHotel     nombre del hotel
     */
    public ReservaTableView(int idRes, int numPersonas, String fehaInicio, String fechaFin, String regimen,
            String numTarjeta, int cvv, String fechaCaducidad, String nombreDeUsuario, String nombreHotel) {
        this.idRes = idRes;
        this.numPersonas = numPersonas;
        this.fehaInicio = fehaInicio;
        this.fechaFin = fechaFin;
        this.regimen = regimen;
        this.numTarjeta = numTarjeta;
        this.cvv = cvv;
        this.fechaCaducidad = fechaCaducidad;
        this.nombreDeUsuario = nombreDeUsuario;
        this.nombreHotel = nombreHotel;

    }

    public static void llenarReservaTableView(ObservableList<ReservaTableView> listaReservaTableView) {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://172.17.0.4:3306/hotelProyecto", "root",
                    "admini");
            ResultSet rs;
            PreparedStatement stmt = null;
            stmt = con.prepareStatement("SELECT * FROM Reserva");
            stmt.executeQuery();
            rs = stmt.executeQuery();
            while (rs.next()) {
                listaReservaTableView.add(
                        new ReservaTableView(rs.getInt("idRes"), rs.getInt("numPersonas"), rs.getString("fehaInicio"),
                                rs.getString("fechaFin"), rs.getString("regimen"), rs.getString("numTarjeta"),
                                rs.getInt("cvv"), rs.getString("fechaCaducidad"), rs.getString("nombreDeUsuario"),
                                rs.getString("nombreHotel")));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
    

}
