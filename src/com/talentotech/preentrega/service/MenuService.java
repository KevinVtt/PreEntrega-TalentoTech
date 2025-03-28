package com.talentotech.preentrega.service;

import com.talentotech.preentrega.model.Bebida;
import com.talentotech.preentrega.model.Comida;
import com.talentotech.preentrega.model.Producto;

import java.util.Scanner;

public class MenuService {

    private final ProductoService productoService;
    private final Scanner scanner;
    private final PedidoService pedidoService;

    public MenuService(PedidoService pedidoService,ProductoService productoService, Scanner scanner) {
        this.productoService = productoService;
        inicializarProductos();
        this.scanner = scanner;
        this.pedidoService = pedidoService;
    }

    public void menuAgregarProducto(){
        System.out.println("Ingrese 1 si es una Bebida, Ingrese 2 si es una Comida");
        int usuarioInput = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        System.out.println("Ingrese el precio del producto: ");
        double precioProducto = scanner.nextDouble();

        System.out.println("Ingrese el stock del producto: ");
        int stockProducto = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre de la marca: ");
        String marcaProducto = scanner.nextLine();

        switch (usuarioInput){
            case 1:
                System.out.println("Ingrese los litros de la bebida");
                String inputLitros = scanner.nextLine().replace(",", ".");
                double litros = Double.parseDouble(inputLitros);
                productoService.agregarBebida(nombreProducto,precioProducto,stockProducto,marcaProducto,litros);
                break;
            case 2:
                System.out.println("Ingrese la grasa neta de la comida");
                String inputGrasaNeta = scanner.nextLine().replace(",", ".");
                double grasaNeta = Double.parseDouble(inputGrasaNeta);
                productoService.agregarComida(nombreProducto,precioProducto,stockProducto,marcaProducto,grasaNeta);
                break;
            default:
                System.out.println("Usted no ingreso ningun numero");
        }
    }

    public void mostrarListado(){
        if(productoService.listar().isEmpty()){
            System.out.println("LA LISTA ESTA VACIA!");
        }
        for(Producto producto: productoService.listar()){
            System.out.println(producto);
        }
    }

    public void mostrarProducto(){
        System.out.println("Ingrese el id del producto que quieres buscar: ");
        System.out.println(productoService.buscarProducto(scanner.nextLong()));
    }

    public void menuParaActualizarProducto(){

        System.out.println("------------------------------------------------");
            if(productoService.listar().isEmpty()){
                System.out.println("LA LISTA ESTA VACIA!");
            }
            for(Producto productoLista: productoService.listar()){
                if(productoLista instanceof Bebida b){
                    System.out.println(productoLista.getId()+")" + " nombre: " + productoLista.getNombre() + " precio: " + productoLista.getPrecio() + " stock: " + productoLista.getStock() + " marca: " + productoLista.getMarca() + " litros: " + b.getLitros());
                }else if(productoLista instanceof Comida c){
                    System.out.println(productoLista.getId()+")" + " nombre: " + productoLista.getNombre() + " precio: " + productoLista.getPrecio() + " stock: " + productoLista.getStock() + " marca: " + productoLista.getMarca() + " grasa neta: " + c.getGrasaNeta());
                }
                System.out.println();
            }
            System.out.println("------------------------------------------------");
        System.out.println("Seleccione alguno para editar: ");
        Producto producto = productoService.buscarProducto(scanner.nextLong());
        verificarTipoDeProducto(producto);
        System.out.println("PRODUCTO EDITADO -->" + productoService.actualizarProducto(producto));
    }

    public void actualizarProducto(Producto producto){

        scanner.nextLine();
        System.out.println("Ingrese el nuevo nombre: ");
        String nombreNuevo = scanner.nextLine();

        System.out.println("Ingrese el nuevo precio: ");
        double nuevoPrecio = scanner.nextDouble();

        System.out.println("Ingrese el nuevo stock");
        int stock = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la nueva marca");
        String marca = scanner.nextLine();

        producto.setNombre(nombreNuevo);
        producto.setPrecio(nuevoPrecio);
        producto.setStock(stock);
        producto.setMarca(marca);

    }

    public void inputActualizarBebida(Bebida bebida){

        actualizarProducto(bebida);

        System.out.println("Ingrese los litros nuevos");
        double litrosNuevo = scanner.nextDouble();

        bebida.setLitros(litrosNuevo);
    }

    public void inputActualizarComida(Comida comida){
        actualizarProducto(comida);

        System.out.println("Ingrese la cantidad de grasa neta nueva");
        double grasaNetaNueva = scanner.nextDouble();

        comida.setGrasaNeta(grasaNetaNueva);
    }

    public void eliminarProducto(){
        mostrarListado();
        System.out.println("Ingrese el id que desee eliminar!");
        productoService.eliminarProducto(scanner.nextLong());
    }

    public void inicializarProductos(){
        productoService.agregarComida("Papas fritas",2000,30,"Pringless",52.02d);
        productoService.agregarBebida("Cerveza",3500,35,"Brahma",2.5d);
        productoService.agregarComida("Chocolate",1000,40,"Milka",122.12d);
        productoService.agregarBebida("Bebida Energizante",1500,25,"Redbull",0.700d);
        productoService.agregarComida("Carne",4000,10,"Carne vacuna",212.02d);
    }

    public void menuParaAgregarMasProductoAlPedido(){
        Long seleccionarProducto = 0L;
        do{
            menuProductosPedido();
            System.out.println("Seleccione algun producto para agregar al pedido: ");
            seleccionarProducto = scanner.nextLong();
            if(seleccionarProducto != 0){
                System.out.println("Agregue la cantidad del producto: ");
                int cantidadProducto = scanner.nextInt();
                pedidoService.agregarProducto(seleccionarProducto,cantidadProducto);
            }
        }while (seleccionarProducto != 0);
    }

    private void menuProductosPedido(){
        System.out.println("------------------------------------------------");
        for(Producto productoLista: productoService.getSistema().getListaProductos()){
            System.out.println(productoLista.getId()+")" + " nombre: " + productoLista.getNombre() + " precio: " + productoLista.getPrecio() + " stock: " + productoLista.getStock());
            System.out.println();
        }
        System.out.println("0) Salir");
        System.out.println("------------------------------------------------");
    }

    private void verificarTipoDeProducto(Producto producto){
        if(producto instanceof Comida comida){
            inputActualizarComida(comida);
        } else if (producto instanceof Bebida bebida) {
            inputActualizarBebida(bebida);
        }else{
            throw new RuntimeException("El tipo de producto no existe");
        }
    }

}
