package com.talentotech.preentrega.model;

public class Comida extends Producto{

    private double grasaNeta;

    public Comida(Long id, String nombre, Double precio, Integer stock, String marca, double grasaNeta) {
        super(id, nombre, precio, stock, marca);
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

    @Override
    public String toString() {
        return super.toString() + " == Tipo Comida == " +
                "grasaNeta " + grasaNeta;
    }
}
