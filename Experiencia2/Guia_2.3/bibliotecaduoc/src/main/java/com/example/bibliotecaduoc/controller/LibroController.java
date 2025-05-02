package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;
    
    //Mostrar los libros
    @GetMapping
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }
    
    //Crear un libro
    @PostMapping
    public Libro agregarLibro(@RequestBody Libro l) {
        return libroService.saveLibro(l);
    }
    
    @GetMapping("/{id}")
    public Libro buscarLibro(@PathVariable int id) {
        return libroService.getLibroIs(id);
    }

    /*Buscar libro por ID:
    @GetMapping("/id/{id}")//Añadi el "/id/" para que pueda funcionar la busqueda según el filtro.
    public Libro buscaLibroId(@PathVariable int id) {
        return libroService.getLibroIs(id);
    }

    //Buscar libro por ISBN:
    @GetMapping("/isbn/{isbn}")//Añadi el "/isbn/" para que pueda funcionar la busqueda según el filtro.
    public Libro buscaLibroIsbn(@PathVariable String isbn) {
        return libroService.getLibroIsbn(isbn);
    }*/

    //Actualizar libro:
    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro l) {
        return libroService.updateLibro(l);
    }

    //Eliminar libro:
    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id) {
        return libroService.deleteLibro(id);
    }

    //Total de libros:
    @GetMapping("/total")
    public int totalLibros() {
        return libroService.totalLibro();
    }
    
}
