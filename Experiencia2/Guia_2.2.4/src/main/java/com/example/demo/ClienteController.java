package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    @GetMapping//Sin parentesis, usa el path determinado en el RequestMapping, con parentesis, el metodo se activa solo al poner esa ruta especifica, poniendolo después de la ruta de RequestMapping.
    public String index(){
        return "Bienvenidos al listado de clientes";
    }
}
