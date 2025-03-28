package com.talentotech.preentrega.excepciones;

public class ProductoYaExisteExcepcion extends RuntimeException {
    public ProductoYaExisteExcepcion(String message) {
        super(message);
    }
}
