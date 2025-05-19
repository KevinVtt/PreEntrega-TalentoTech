package com.talentotech.preentrega.model;

import com.talentotech.preentrega.excepciones.ProductoNuloExcepcion;

public class Comida extends Producto{

    private double grasaNeta;

    public Comida(Long id, String nombre, Double precio, Integer stock, String marca, double grasaNeta) {
        super(id, nombre, precio, stock, marca);
        verificarProductoNulo(nombre, precio, stock, marca, grasaNeta);
        this.grasaNeta = grasaNeta;
    }
    public Comida(Long id, String nombre, Double precio, Integer stock, String marca) {
        super(id, nombre, precio, stock, marca);
    }


    public Comida(double grasaNeta) {
        this.grasaNeta = grasaNeta;
    }

    public double getGrasaNeta() {
        return grasaNeta;
    }

    public void setGrasaNeta(double grasaNeta) {
        this.grasaNeta = grasaNeta;
    }

    protected void verificarProductoNulo(String nombre, double precio, int stock, String marca,double grasaNeta) {
        super.verificarProductoNulo(nombre, precio, stock, marca);
        if(grasaNeta <= 0){
            errores.append(" grasa neta");
        }
        if(!errores.isEmpty()){
            throw new ProductoNuloExcepcion("Los campos nulos son: " + errores.toString().strip().replace(" ",","));
        }
    }

    @Override
    public String toString() {
        return super.toString() + " == Tipo Comida == " +
                "grasaNeta " + grasaNeta;
    }
}
