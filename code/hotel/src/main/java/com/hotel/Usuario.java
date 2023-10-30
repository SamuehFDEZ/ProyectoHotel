package com.hotel;

/**
 * Clase de Usuario
 * 
 * @version 1.0
 * 
 */
public class Usuario {
    private static String nombreDeUsuario;
    private static Usuario instance;

    /**
     * Método que obtiene el nombre de Usuario
     * 
     * @since 1.0
     * @return devuelve el nombre
     */
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    /**
     * Método que adquiere el nombre de usuario
     * 
     * @since 1.0
     * @param nombreDeUsuario nombre de usuario
     */
    public void setNombreDeUsuario(String nombreDeUsuario) {
        Usuario.nombreDeUsuario = nombreDeUsuario;
    }

    /**
     * Constructor de la clase Usuario
     * 
     * @since 1.0
     * 
     */
    public Usuario() {
        Usuario.nombreDeUsuario = "";
    }

    /**
     * Método que obtiene la instancia de la clase Usuario
     * 
     * @since 1.0
     * @return devuelve la instancia
     */
    public static Usuario getInstance() {
        if (instance == null) {
            instance = new Usuario();
        }
        return instance;
    }

}


