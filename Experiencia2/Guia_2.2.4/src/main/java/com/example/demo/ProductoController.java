package com.example.demo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController//Maneja las solicitudes HTTP
@RequestMapping("api/producto")//Ruta base
public class ProductoController {
    List<String> productos = Arrays.asList("Manzana","Pera","Limón","Sandia");//Lista de productos
    @GetMapping
    public String index(){
        return "Bienvenidos al listado de productos";
    }

    @GetMapping("/{idProducto}")
    public String buscarProducto(@PathVariable int idProducto) {
        if (idProducto >= 0 && idProducto < productos.size()) {
            return "Producto encontrado: "+productos.get(idProducto);   
        }else{
            return "Error 404: Producto no encontrado";
        }
    }
    
}
