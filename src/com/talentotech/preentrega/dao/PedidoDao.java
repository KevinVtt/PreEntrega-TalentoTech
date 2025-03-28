package com.talentotech.preentrega.dao;
import com.talentotech.preentrega.model.LineaPedido;
import com.talentotech.preentrega.model.Pedido;
import com.talentotech.preentrega.model.Producto;
import com.talentotech.preentrega.model.Sistema;
import com.talentotech.preentrega.service.ProductoService;

import java.util.List;
import java.util.Scanner;

public class PedidoDao {

    private final Sistema sistema;
    private ProductoService productoService;

    public PedidoDao(Sistema sistema) {
        this.sistema = sistema;
        this.productoService = new ProductoService(sistema);
    }

    public void agregarProductoAPedido(Long seleccionarProducto, int cantidadProducto){

        Producto productoEnLaLista = productoService.buscarProducto(seleccionarProducto);

        if(productoEnLaLista != null) {
            if(!existeProductoEnLaLista(productoEnLaLista,cantidadProducto)){
                LineaPedido nuevaLineaPedido = new LineaPedido(productoEnLaLista, cantidadProducto);
                nuevaLineaPedido.disminuirStock();
                sistema.getPedido().getListaLineaPedido().add(nuevaLineaPedido);
            }else{
                System.out.println("Ya existe un producto igual, se disminuyo el stock y aumentamos la cantidad!");
            }
        }else{
            throw new RuntimeException("El producto buscado es nulo");
        }
    }


    public void mostrarPedidos(){
        double totalPedidos = 0;
        for(LineaPedido pedido: sistema.getPedido().getListaLineaPedido()){
            System.out.println(pedido);
            totalPedidos += pedido.totalPedido();
        }

        System.out.println("Total a pagar ---> " + totalPedidos);
    }

    // Este metodo se encarga de modificar la lista, en vez de insertar aumenta la cantidad del producto en pedido y disminuye el stock.
    private boolean existeProductoEnLaLista(Producto producto,int cantidadProducto){
        boolean bandera = false;
        for(LineaPedido lineaPedido: sistema.getPedido().getListaLineaPedido()){
            if(lineaPedido.getProducto().equals(producto)){
                lineaPedido.setCantidad(lineaPedido.getCantidad() + cantidadProducto);
                lineaPedido.disminuirStock();
                bandera = true;
            }
        }
        return bandera;
    }

}
