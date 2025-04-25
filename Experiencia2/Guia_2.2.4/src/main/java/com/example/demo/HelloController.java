package com.example.demo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/app")
public class HelloController {
    @GetMapping("/saludar")
    public String saludar() {
        return "¡Hola mundo!";
    }
    @GetMapping("/saludar/{nombre}")
    public String saludarConParametro(@PathVariable String nombre) {
        return "¡Hola "+nombre+"!";
    }
    @GetMapping("/suma")
    public String sumar() {
        int resultado = 5 + 8;
        return "El resultado de la suma es: "+resultado;
    }
    @GetMapping("/suma/{a}/{b}")
    public String sumarConParametros(@PathVariable int a,@PathVariable int b) {
        int resultado = a + b;
        return "El resultado de la suma es: "+resultado;
    }
    @GetMapping("/resta")
    public String restar() {
        int resultado = 8 - 5;
        return "El resultado de la resta es: "+resultado;
    }
    @GetMapping("/resta/{a}/{b}")
    public String restarConParametros(@PathVariable int a,@PathVariable int b) {
        int resultado = a - b;
        return "El resultado de la resta es: "+resultado;
    }
    @GetMapping("/división")
    public String dividir() {
        int resultado = 10 / 2;
        return "El resultado de la división es: "+resultado;
    }
    @GetMapping("/división/{a}/{b}")
    public String dividirConParametros(@PathVariable int a,@PathVariable int b) {
        int resultado = a / b;
        return "El resultado de la división es: "+resultado;
    }
    @GetMapping("/multiplicación")
    public String multiplicar() {
        int resultado = 5 * 8;
        return "El resultado de la multiplicación es: "+resultado;
    }
    @GetMapping("/multiplicación/{a}/{b}")
    public String multiplicarConParametros(@PathVariable int a,@PathVariable int b) {
        int resultado = a * b;
        return "El resultado de la multiplicación es: "+resultado;
    }
}
