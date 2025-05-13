package com.talentotech.preentrega.model;

public class Bebida extends Producto {

    private double litros;

    public Bebida() {
    }

    public Bebida(Long id, String nombre, Double precio, Integer stock,String marca) {
        super(id, nombre, precio, stock,marca);
    }

    public Bebida(double litros) {
        this.litros = litros;
    }

    public Bebida(Long id, String nombre, Double precio, Integer stock, String marca, double litros) {
        super(id, nombre, precio, stock,marca);
        this.litros = litros;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    @Override
    public String toString() {
        return super.toString() + " === Tipo Bebida == " +
                "litros" + litros;
    }
}
