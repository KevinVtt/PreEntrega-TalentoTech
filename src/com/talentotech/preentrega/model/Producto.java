package com.talentotech.preentrega.model;

import com.talentotech.preentrega.excepciones.ProductoNuloExcepcion;

public abstract class Producto {

    protected Long id;
    protected String nombre;
    protected Double precio;
    protected Integer stock;
    protected String marca;
    protected StringBuilder errores = new StringBuilder();

    public Producto() {
    }

    public Producto(Long id,String nombre, Double precio, Integer stock,String marca) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    protected void verificarProductoNulo(String nombre, double precio, int stock, String marca){
        if(nombre.isEmpty()){
            errores.append(" nombre");
        }
        if (precio <= 0) {
            errores.append(" precio");
        }
        if(stock <= 0){
            errores.append(" stock");
        }
        if(marca.isEmpty()){
            errores.append(" marca");
        }
    }

    @Override
    public String toString() {
        return
                "ID: " + id +
                " Nombre del producto: " + nombre+
                " Precio: " + precio +
                " Stock: " + stock +
                " Marca: " + marca;
    }
}
