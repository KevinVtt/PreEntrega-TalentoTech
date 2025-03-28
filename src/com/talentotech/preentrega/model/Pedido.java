package com.talentotech.preentrega.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<LineaPedido> listaLineaPedido = new ArrayList<>();

    public List<LineaPedido> getListaLineaPedido() {
        return listaLineaPedido;
    }

    public void setListaLineaPedido(List<LineaPedido> listaLineaPedido) {
        this.listaLineaPedido = listaLineaPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "listaLineaPedido=" + listaLineaPedido +
                '}';
    }

}
