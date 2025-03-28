# PreEntrega-TalentoTech
Sistema e-commerce de TaletoTech &lt;PreEntrega>
---
## Tecnicas y practicas
- Utilice buenas practicas para el desarrollo de este proyecto implementando **Polimorfismo, Encapsulamiento, Herencia, etc**.
- Aplique algunos conceptos **SOLID** como por ejemplo, clases abstractas para no repetir codigo.
- Metodos estructurados, claros y concisos para ahorrarme los comentarios.
- Los metodos de cada clase tienen una unica funcion esto quiere decir que, **_Un metodo no puede realizar dos cosas a la vez_**.
- Estas prácticas las estoy realizando a medida que leo el libro "Código Limpio" de Robert C. Martin.
	
### Ejemplo de código (Funcionamiento de los metodos):

```java
public void agregarBebida(String nombre, double precio, int stock, String marca, double litros) {
    if(existeElProducto(nombre, marca)) {
        productobao.agregarBebida(nombre, precio, stock, marca, litros);
    }
}

public void agregarComida(String nombre, double precio, int stock, String marca, double grasaNeta) {
    if(existeElProducto(nombre, marca)) {
        productobao.agregarComida(nombre, precio, stock, marca, grasaleta);
    }
}

private boolean existeElProducto(String nombre, String marca) {
    if(buscarProductoPorNombreYMarca(nombre, marca) == null) {
        return true;
    }
    throw new ProductoExistsException("El producto ya existe!");
}
