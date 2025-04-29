package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {
    private List<Libro> listaLibros = new ArrayList<>();

    public LibroRepository(){
        //Agregar libros manualmente:
        listaLibros.add(new Libro(1, "1234567891234", "Libro1", "Editorial1", 2001, ""));
        listaLibros.add(new Libro(2, "1234567891243", "Libro2", "Editorial2", 2025, ""));
        listaLibros.add(new Libro(3, "1234567891957", "Libro3", "Editorial3", 2007, ""));
    }

    //CRUD:
    //C:
    public Libro guardarLibro(Libro l){
        listaLibros.add(l);
        return l;
    }
    //R:
    public List<Libro> obtenerLibros(){
        return listaLibros;
    }
    public int totalLibros(){
        return listaLibros.size();
    }
    public Libro buscarPorId(int id){
        for (Libro l : listaLibros) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }
    public Libro buscarPorIsbn(String isbn){
        for (Libro l : listaLibros) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                return l;
            }
        }
        return null;
    }
    //U:
    public Libro actualizarLibro(Libro l){
        /*int idPosicion;
        for (Libro libro : listaLibros) {
            if (libro.getId() == l.getId()) {
                int idPosicion = listaLibros.indexOf(libro);
                break;
            }
        }*/
        int idPosicion=0;
        for (idPosicion = 0;idPosicion<listaLibros.size();idPosicion++) {
            if (listaLibros.get(idPosicion).getId() == l.getId()) {
                break;
            }
        }

        Libro l1 = new Libro();
        l1.setId(l.getId());
        l1.setTitulo(l.getTitulo());
        l1.setAutor(l.getAutor());
        l1.setFechaPublicacion(l.getFechaPublicacion());
        l1.setEditorial(l.getEditorial());
        l1.setIsbn(l.getIsbn());

        listaLibros.set(idPosicion, l);
        return l1;
    }
    //D:
    public void eliminarLibro(int id){
        if (buscarPorId(id) != null) {
            listaLibros.remove(buscarPorId(id));
        }
    }
}
