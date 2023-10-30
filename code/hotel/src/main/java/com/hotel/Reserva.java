package com.hotel;

/**
 * Clase Reserva
 * 
 * @version 1.0
 * 
 */
public class Reserva {

    private static int numPers;
    private static String fechaIni;
    private static String fechaFin;
    private static String regimen;

    /**
     * Constructor de la clase Reserva
     * 
     * @since 1.0
     * 
     */
    public Reserva() {
        Reserva.numPers = 0;
        Reserva.fechaIni = "";
        Reserva.fechaFin = "";
        Reserva.regimen = "";
    }

    /**
     * Método que obtiene el numero de personas
     * 
     * @since 1.0
     * @return devuelve el numero de personas
     */
    public static int getNumPers() {
        return numPers;
    }

    /**
     * Método que asigna un valor entero al numero de personas
     * 
     * @since 1.0
     * @param numPers numero de personas
     */
    public void setNumPers(int numPers) {
        Reserva.numPers = numPers;
    }

    /**
     * Método que obtiene la fecha inicial
     * 
     * @since 1.0
     * @return devuelve la fecha inicial
     */
    public static String getFechaIni() {
        return fechaIni;
    }

    /**
     * Método que asigna un valor a la fecha de inicio
     * 
     * @since 1.0
     * @param fechaIni fecha de inicio
     */
    public void setFechaIni(String fechaIni) {
        Reserva.fechaIni = fechaIni;
    }

    /**
     * Método que obtiene la fecha final
     * 
     * @since 1.0
     * @return devuelve la fecha final
     */
    public static String getFechaFin() {
        return fechaFin;
    }

    /**
     * Método que asigna un valor a la fecha final
     * 
     * @since 1.0
     * @param fechaFin fecha final
     */
    public void setFechaFin(String fechaFin) {
        Reserva.fechaFin = fechaFin;
    }

    /**
     * Método que obtiene el regimen
     * 
     * @since 1.0
     * @return devuelve el regimen
     */
    public static String getRegimen() {
        return regimen;
    }

    /**
     * Método que asigna un valor de String al regimen
     * 
     * @since 1.0
     * @param regimen regimen
     */
    public void setRegimen(String regimen) {
        Reserva.regimen = regimen;
    }
}