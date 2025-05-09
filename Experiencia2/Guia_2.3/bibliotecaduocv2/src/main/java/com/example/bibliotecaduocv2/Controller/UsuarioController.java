package com.example.bibliotecaduocv2.Controller;

import java.util.Optional;
import java.util.HashMap; //Importar la clase HashMap, sirve para crear un Mapa del Objeto.
import java.util.Map; //Importar la clase Map, sirve para manejar las claves pares.

import com.example.bibliotecaduocv2.Model.Usuario;
import com.example.bibliotecaduocv2.Service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/usuarios")
@CrossOrigin //Permiten manejar las solicitudes cliente-servidor y viceversa.
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    //Método para agregar usuarios a la BB.DD.:
    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario u){
        return service.registrar(u); //Llama la fucion registrar() del service.
    }

    //Método para autenticar los usuarios logeados:
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Usuario u){
        Optional<Usuario> user = service.autenticar(u.getEmail(), u.getPassword()); //Verificación de credenciales
        Map<String, String> respuesta = new HashMap<>(); //Crea un nuevo mapa ara almacenar las respuestas de la funcion autenticar.
        if (user.isPresent()) {
            respuesta.put("result", "OK");
            respuesta.put("nombre", user.get().getNombre());
        }else{
            respuesta.put("result", "ERROR");
        }
        return respuesta;
    }
}
