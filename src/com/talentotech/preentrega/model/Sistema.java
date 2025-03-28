package com.talentotech.preentrega.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sistema {

    private List<Producto> listaProductos = new ArrayList<>();
    private Pedido pedido = new Pedido();

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
