package com.example.bibliotecaduoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    //GET libro:
    public List<Libro> getLibros(){
        return libroRepository.obtenerLibros();
    }
    //SAVE libro:
    public Libro saveLibro(Libro l){
        return libroRepository.guardarLibro(l);
    }
    //Buscar por ID:
    public Libro getLibroIs(int id){
        return libroRepository.buscarPorId(id);
    }
    //Buscar por ISBN:
    public Libro getLibroIsbn(String isbn){
        return libroRepository.buscarPorIsbn(isbn);
    }
    //UPDATE libro:
    public Libro updateLibro(Libro l){
        return libroRepository.actualizarLibro(l);
    }
    //DELETE libro:
    public String deleteLibro(int id){
        libroRepository.eliminarLibro(id);
        return "El libro fue eliminado";
    }
    //Total de libros:
    public int totalLibro(){
        return libroRepository.totalLibros();
    }
}
