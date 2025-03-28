package com.talentotech.preentrega.service;

import com.talentotech.preentrega.dao.PedidoDao;
import com.talentotech.preentrega.model.Pedido;
import com.talentotech.preentrega.model.Sistema;

import java.util.Scanner;

public class PedidoService {

    private Sistema sistema;
    private final PedidoDao pedidoDao;

    public PedidoService(Sistema sistema) {
        this.pedidoDao = new PedidoDao(sistema);
    }

    public void agregarProducto(Long producto, int cantidad) {
        try {
            pedidoDao.agregarProductoAPedido(producto,cantidad);
            System.out.println("¡Pedido creado exitosamente!");
        } catch (Exception e) {
            System.out.println("Error al crear pedido: " + e.getMessage());
        }
    }

    public void listar(){
        pedidoDao.mostrarPedidos();
    }

    public static void menu(){
        System.out.println("-----------------------------------------");
        System.out.println("1) Agregar Producto");
        System.out.println("2) Listar Productos");
        System.out.println("3) Buscar Producto");
        System.out.println("4) Actualizar Producto");
        System.out.println("5) Eliminar Producto");
        System.out.println("6) Crear un pedido");
        System.out.println("7) Listar pedidos");
        System.out.println("0) Salir");
        System.out.println("-----------------------------------------");
    }

}
