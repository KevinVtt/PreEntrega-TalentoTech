package com.talentotech.preentrega.model;

import com.talentotech.preentrega.excepciones.StockInsuficienteException;

public class LineaPedido {

    private Producto producto;
    private int cantidad;

    public LineaPedido() {
    }

    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double totalPedido(){
        return (double) producto.getPrecio() * cantidad;
    }

    public void disminuirStock(){
        if(verificarStock()) producto.setStock(producto.getStock() - cantidad);

    }

    public boolean verificarStock(){
        if(producto.getStock() <= cantidad){
            throw new StockInsuficienteException("El stock es insuficiente!");
        }
        return true;
    }

    @Override
    public String toString() {
        return " LineaPedido{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                '}' + " Total del producto: " + totalPedido();
    }
}
