package com.example.bibliotecaduocv2.Model;

import java.util.Optional;

import jakarta.persistence.*; //Importa la anotaciones JPA.
import lombok.Data; //Evita códigos redundantes.

@Entity //Indicar que la clase usuario se considere un objetoJPA.
@Data //Genera los métodos Getter y Setter para ser utilizados en las imports de otros archivos.
public class Usuario {
    @Id //Indica que este campo es una clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY/*Determina que este número generado es una clave primaria*/)//Vuelve el ID automatica.
    private Long id;

    private String nombre,email,password;

    //Método para crear la tabla usuario automaticamente en la base de datos:
    public static Optional<Usuario>map(Object o){
        throw new UnsupportedOperationException("Unimplement method 'map'");
    }
}