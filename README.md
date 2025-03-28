# PreEntrega-TalentoTech
Sistema e-commerce de TaletoTech &lt;PreEntrega>
---
## Tecnicas y practicas
- Utilice buenas practicas para el desarrollo de este proyecto implementando **Polimorfismo, Encapsulamiento, Herencia, etc**.
- Aplique algunos conceptos **SOLID** como por ejemplo, clases abstractas para no repetir codigo.
- Metodos estructurados, claros y concisos para ahorrarme los comentarios.
- Los metodos de cada clase tienen una unica funcion esto quiere decir que, **_Un metodo no puede realizar dos cosas a la vez_**.
	
### Ejemplo de codigo: 

	```public void agregarBebida(String nombre, double precio, int stock, String marca, double litros){
        if(existeElProducto(nombre,marca)){
            productoDao.agregarBebida(nombre,precio,stock,marca,litros);
        }
    }```

    ```public void agregarComida(String nombre, double precio, int stock, String marca,double grasaNeta){
        if(existeElProducto(nombre,marca)){
            productoDao.agregarComida(nombre,precio,stock,marca,grasaNeta);
        }
    }```
	
    ```private boolean existeElProducto(String nombre, String marca){
        if(buscarProductoPorNombreYMarca(nombre,marca) == null){
            return true;
        }
        throw new ProductoYaExisteExcepcion("El producto ya existe!");
    }```
	
- Estas practicas las estoy realizando a medida que leo el libro de Codigo limpio de Robert C. Martin.
