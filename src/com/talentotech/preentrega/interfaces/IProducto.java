package com.talentotech.preentrega.interfaces;

import com.talentotech.preentrega.model.Producto;

public interface IProducto {
    void agregarProducto(String nombre, double precio, int stock, String marca, double litros);
    Producto actualizarProducto(Producto producto);
}
