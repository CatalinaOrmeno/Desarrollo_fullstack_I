package com.example.bibliotecaduocv2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.example.bibliotecaduocv2.Model.Usuario;

//Interfaz que extiende de JpaRepository para proporcionar los métodos CRUD
public interface UsuarioRepository extends JpaRepository<Usuario/*Que tipo de Objeto se va a pasar*/,Long/*Que tipo de Dato se va a pasar*/> {   
    Optional<Usuario> findByEmail(String email); //Sirve para buscar el usuario por el email
}
