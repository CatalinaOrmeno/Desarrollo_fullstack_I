package com.example.bibliotecaduocv2.Service;

import com.example.bibliotecaduocv2.Model.Usuario;
import com.example.bibliotecaduocv2.Repository.UsuarioRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Esto indica que UsuarioService es un servicio.
public class UsuarioService {
    @Autowired //Sincroniza el servicio con el repositorio.
    private UsuarioRepository repositorio;

    //Método para registrar usuarios a la base de datos:
    public Usuario registrar(Usuario u){
        return repositorio.save(u);
    }

    //Método para autenticar los usuarios:
    public Optional<Usuario> autenticar(String email,String password){
        return repositorio.findByEmail(email).filter(u -> u.getPassword().equals(password));//Filtra el usuario por email y contraseña.
    }
}
