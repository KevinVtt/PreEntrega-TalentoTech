package com.talentotech.preentrega.dao;

import com.talentotech.preentrega.model.Bebida;
import com.talentotech.preentrega.model.Comida;
import com.talentotech.preentrega.model.Sistema;
import com.talentotech.preentrega.excepciones.ProductoNoExisteExcepcion;
import com.talentotech.preentrega.model.Producto;
import com.talentotech.preentrega.service.productos.ActualizarProducto;

import java.util.List;

public class ProductoDao extends ActualizarProducto {

    private final Sistema sistema;

    public ProductoDao(Sistema sistema) {
        this.sistema = sistema;
    }

    public Producto buscarProducto(Long id){

        Producto producto = null;
        int indice = 0;
        boolean bandera = false;

        while(!bandera && indice < sistema.getListaProductos().size()) {
            bandera = sistema.getListaProductos().get(indice).getId() == id;
            producto = (bandera) ? sistema.getListaProductos().get(indice) : null;
            indice++;
        }
        return producto;
    }

    public Producto buscarProducto(String nombre, String marca){

        Producto producto = null;
        int indice = 0;
        boolean bandera = false;

        while(!bandera && indice < sistema.getListaProductos().size()) {

            bandera = sistema.getListaProductos().get(indice).getNombre().equals(nombre) && sistema.getListaProductos().get(indice).getMarca().equals(marca);
            producto = (bandera) ? sistema.getListaProductos().get(indice) : null;
            indice++;
        }
        return producto;
    }

    public void agregarBebida(String nombre, double precio, int stock,String marca, double litros){
        Long idIncrementado = incrementarIdProducto();
        Bebida bebidaNueva = new Bebida(idIncrementado,nombre,precio,stock,marca,litros);
        super.agregarProducto(sistema.getListaProductos(),bebidaNueva);
    }

    public void agregarComida(String nombre, double precio, int stock,String marca,double grasaNeta) {
        Long idIncrementado = incrementarIdProducto();
        Comida comida = new Comida(idIncrementado, nombre, precio, stock, marca,grasaNeta);
        super.agregarProducto(sistema.getListaProductos(), comida);
    }

    public List<Producto> listarProductos(){
        return sistema.getListaProductos();
    }


    @Override
    public Bebida actualizarBebida(Bebida nuevoProducto) {
        Producto producto = buscarProducto(nuevoProducto.getId());
        super.actualizarProducto(producto, nuevoProducto);
        Bebida bebidaLista = (Bebida) producto;
        bebidaLista.setLitros(nuevoProducto.getLitros());
        return bebidaLista;
    }

    @Override
    public Comida actualizarComida(Comida nuevoProducto) {
        Producto producto = buscarProducto(nuevoProducto.getId());
        super.actualizarProducto(producto, nuevoProducto);
        Comida comidaLista = (Comida) producto;
        comidaLista.setGrasaNeta(nuevoProducto.getGrasaNeta());
        return comidaLista;
    }

    public void eliminarProducto(Long id){
        Producto productoDeLaLista = buscarProducto(id);
        if(productoDeLaLista != null){
            sistema.getListaProductos().remove(productoDeLaLista);
            System.out.println("Producto removido correctamente!");
        }else{
            throw new ProductoNoExisteExcepcion("El producto no existe para eliminar");
        }
    }

    private Long incrementarIdProducto(){
        return (sistema.getListaProductos().isEmpty()) ? 1 : sistema.getListaProductos().getLast().getId() + 1;
    }

    public Sistema getSistema() {
        return sistema;
    }

}
