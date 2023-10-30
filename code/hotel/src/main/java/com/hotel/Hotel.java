package com.hotel;

/**
 * Clase Hotel
 * 
 * @version 1.0
 * 
 */
public class Hotel {
    private static String nombreHotel;
    private static Hotel instance;

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
     * Método que adquiere un valor al nombre de hotel
     * 
     * @since 1.0
     * @param nombreHotel nombre del hotel
     */
    public void setNombreHotel(String nombreHotel) {
        Hotel.nombreHotel = nombreHotel;
    }

    /**
     * Constructor de la clase hotel
     * 
     * @since 1.0
     * 
     */
    public Hotel() {
        Hotel.nombreHotel = "";
    }

    /**
     * Método que obtiene la instancia de la clase hotel
     * 
     * @since 1.0
     * @return devuelve la instancia
     */
    public static Hotel getInstance() {
        if (instance == null) {
            instance = new Hotel();
        }
        return instance;
    }
}