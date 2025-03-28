package com.talentotech.preentrega.service;

import com.talentotech.preentrega.dao.ProductoDao;
import com.talentotech.preentrega.excepciones.ProductoYaExisteExcepcion;
import com.talentotech.preentrega.model.Bebida;
import com.talentotech.preentrega.model.Comida;
import com.talentotech.preentrega.model.Producto;
import com.talentotech.preentrega.model.Sistema;

import java.util.List;

public class ProductoService {

    private final Sistema sistema;
    private ProductoDao productoDao;

    public ProductoService(Sistema sistema) {
        this.sistema = sistema;
        this.productoDao = new ProductoDao(sistema);
    }

    public List<Producto> listar(){
        return productoDao.listarProductos();
    }

    public void eliminarProducto(Long id){
        productoDao.eliminarProducto(id);
    }

    public Producto buscarProducto(Long id){
        return productoDao.buscarProducto(id);
    }

    public Producto buscarProductoPorNombreYMarca(String nombre, String marca){
        return productoDao.buscarProducto(nombre,marca);
    }

    public void agregarBebida(String nombre, double precio, int stock, String marca, double litros){
        if(existeElProducto(nombre,marca)){
            productoDao.agregarBebida(nombre,precio,stock,marca,litros);
        }
    }

    public void agregarComida(String nombre, double precio, int stock, String marca,double grasaNeta){
        if(existeElProducto(nombre,marca)){
            productoDao.agregarComida(nombre,precio,stock,marca,grasaNeta);
        }
    }

    public Producto actualizarProducto(Producto producto){
        Producto productoActualizado = null;
        if(producto != null){
            if(producto instanceof Bebida b){
                productoActualizado = productoDao.actualizarBebida(b);
            }else if (producto instanceof Comida c){
                productoActualizado = productoDao.actualizarComida(c);
            }else {
                throw new RuntimeException("No existe ningun producto para actualizar");
            }
        }
        return productoActualizado;
    }

    private boolean existeElProducto(String nombre, String marca){
        if(buscarProductoPorNombreYMarca(nombre,marca) == null){
            return true;
        }
        throw new ProductoYaExisteExcepcion("El producto ya existe!");
    }

    public Sistema getSistema() {
        return sistema;
    }
}
