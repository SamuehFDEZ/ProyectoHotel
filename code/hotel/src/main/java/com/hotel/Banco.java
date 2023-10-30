package com.hotel;

/**
 * Clase Banco
 * 
 * @version 1.0
 */
public class Banco {
    private static int cvv;
    private static String numTarjeta;
    private static String fechaCaducidad;

    /**
     * Método que obtiene el cvv
     * 
     * @since 1.0
     * @return
     */
    public static int getCvv() {
        return cvv;
    }

    /**
     * Método que asigna un valor al cvv
     * 
     * @since 1.0
     * @param cvv cvv
     */
    public static void setCvv(int cvv) {
        Banco.cvv = cvv;
    }

    /**
     * Método que obtiene el numero de la tarjeta
     * 
     * @since 1.0
     * @return devuelve el numero de la tarjeta
     */
    public static String getNumTarjeta() {
        return numTarjeta;
    }

    /**
     * Método que asigna un valor al numero de la tarjeta
     * 
     * @since 1.0
     * @param numTarjeta numero de la tarjeta
     */
    public static void setNumTarjeta(String numTarjeta) {
        Banco.numTarjeta = numTarjeta;
    }

    /**
     * Método que obtiene la fecha de caducidad de la tarjeta en cuestión
     * 
     * @since 1.0
     * @return devuelve la fecha de caducidad
     */
    public static String getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Método que asigna un valor a la fecha de caducidad
     * 
     * @since 1.0
     * @param fechaCaducidad devuelve la fecha de caducidad
     */
    public static void setFechaCaducidad(String fechaCaducidad) {
        Banco.fechaCaducidad = fechaCaducidad;
    }

    /**
     * Constructor de la clase Banco
     * 
     */
    public Banco() {
        Banco.cvv = 0;
        Banco.numTarjeta = "";
        Banco.fechaCaducidad = "";
    }
}
