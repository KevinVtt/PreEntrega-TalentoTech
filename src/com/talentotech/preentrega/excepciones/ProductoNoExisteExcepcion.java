package com.talentotech.preentrega.excepciones;

public class ProductoNoExisteExcepcion extends RuntimeException {
    public ProductoNoExisteExcepcion(String message) {
        super(message);
    }
}
