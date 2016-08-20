/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

/**
 *
 * @author Fabian
 */
public class ServicioExcepcion  extends Exception{

    public ServicioExcepcion(String message) {
        super(message);
    }

    public ServicioExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

    
}
