package com.talentotech.preentrega.model;

import com.talentotech.preentrega.excepciones.ProductoNuloExcepcion;

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
        verificarProductoNulo(nombre,precio,stock,marca,litros);
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

    protected void verificarProductoNulo(String nombre, double precio, int stock, String marca,double litros) {
        super.verificarProductoNulo(nombre, precio, stock, marca);
        if(litros <= 0){
            errores.append(" litros");
        }
        if(!errores.isEmpty()){
            throw new ProductoNuloExcepcion("Los campos nulos son: " + errores.toString().strip().replace(" ",", "));
        }
    }


}
