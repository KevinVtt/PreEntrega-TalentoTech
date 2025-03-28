package com.talentotech.preentrega;

import com.talentotech.preentrega.model.Sistema;
import com.talentotech.preentrega.service.MenuService;
import com.talentotech.preentrega.service.PedidoService;
import com.talentotech.preentrega.service.ProductoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();
        ProductoService productoService = new ProductoService(sistema);
        PedidoService pedidoService = new PedidoService(sistema);
        MenuService menuService = new MenuService(pedidoService,productoService, scanner);

        int inputUsuario;

        do{
            PedidoService.menu();
            System.out.println("Seleccione alguna opcion: ");
            inputUsuario = scanner.nextInt();
            switch (inputUsuario){
                case 1 -> menuService.menuAgregarProducto();
                case 2 -> menuService.mostrarListado();
                case 3 -> menuService.mostrarProducto();
                case 4 -> menuService.menuParaActualizarProducto();
                case 5 -> menuService.eliminarProducto();
                case 6 -> menuService.menuParaAgregarMasProductoAlPedido();
                case 7 -> pedidoService.listar();
            }
        }while(inputUsuario != 0);

    }

}