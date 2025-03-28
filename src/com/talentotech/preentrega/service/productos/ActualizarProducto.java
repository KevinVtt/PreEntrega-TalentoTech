package com.talentotech.preentrega.service.productos;

import com.talentotech.preentrega.model.Bebida;
import com.talentotech.preentrega.model.Comida;
import com.talentotech.preentrega.model.Producto;

import java.util.List;

abstract public class ActualizarProducto {

    public void actualizarProducto(Producto productoLista, Producto nuevoProducto) {
        productoLista.setNombre(nuevoProducto.getNombre());
        productoLista.setPrecio(nuevoProducto.getPrecio());
        productoLista.setStock(nuevoProducto.getStock());
        productoLista.setMarca(nuevoProducto.getMarca());
    }

    public void agregarProducto(List<Producto> listaProducto, Producto agregarNuevoProducto){
        listaProducto.add(agregarNuevoProducto);
    }

    public abstract Bebida actualizarBebida(Bebida nuevoProducto);

    public abstract Comida actualizarComida(Comida nuevoProducto);

}
