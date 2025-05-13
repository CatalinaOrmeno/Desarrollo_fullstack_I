package com.example.bibliotecaduocv2.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduocv2.Model.Libro;
import com.example.bibliotecaduocv2.Service.LibroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v2/carrito")
public class CarritoController {
    private final List<Libro> carrito = new ArrayList<>();
    @Autowired
    private LibroService libroService;

    //Método para agregar un libro al carrito de compras:
    @PostMapping("/agregar/{id}")
    public String agregarLibro(@PathVariable int id) {
        Libro libro = libroService.getLibroId(id);
        if (libro != null) {
            carrito.add(libro);
            return "Libro se agrego al carrito: " + libro.getTitulo();
        }
        return "Libro no encontrado.";
    }
    
    //Método para eliminar un libro del carrito:
    @DeleteMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable int id) {
        boolean eliminado = carrito.removeIf(libro -> libro.getId() == id);
        return eliminado ? "Libro ha sido eliminado" : "Libro no encontrado";
    }

    //Método para mostrar el contenido del carrito:
    @GetMapping
    public List<Libro> verCarrito() {
        return carrito;
    }

    //Método para vaciar el carrito de compras:
    @DeleteMapping("/vaciar")
    public String vaciarCarrito() {
        carrito.clear();
        return "El carrito esta vacio";
    }

    //Método para contar los items del carrito:
    @GetMapping("/total")
    public int totalCarrito() {
        return carrito.size();
    }
}
