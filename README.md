# PreEntrega-TalentoTech
Sistema e-commerce de TaletoTech &lt;PreEntrega>
---
## Tecnicas y practicas
- Utilice buenas practicas para el desarrollo de este proyecto implementando **Polimorfismo, Encapsulamiento, Herencia, etc**.
- Aplique algunos conceptos **SOLID** como por ejemplo, clases abstractas para no repetir codigo.
- Metodos estructurados, claros y concisos para ahorrarme los comentarios.
- Los metodos de cada clase tienen una unica funcion esto quiere decir que, **_Un metodo no puede realizar dos cosas a la vez_**.
	
### Ejemplo de código:

```java
public void agregarBebida(String nombre, double precio, int stock, String marca, double litros) {
    if(existeIProducto(nombre, marca)) {
        productobao.agregarBebida(nombre, precio, stock, marca, litros);
    }
}

public void agregarComida(String nombre, double precio, int stock, String marca, double grasaleta) {
    if(existeIProducto(nombre, marca)) {
        productobao.agregarComida(nombre, precio, stock, marca, grasaleta);
    }
}

private boolean existeIProducto(String nombre, String marca) {
    if(buscarProductoPorNombreYMarca(nombre, marca) == null) {
        return true;
    }
    throw new ProductoExistsException("El producto ya existe!");
}
	
- Estas practicas las estoy realizando a medida que leo el libro de Codigo limpio de Robert C. Martin.
