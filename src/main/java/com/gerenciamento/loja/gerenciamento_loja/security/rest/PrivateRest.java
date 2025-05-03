package com.gerenciamento.loja.gerenciamento_loja.security.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private")
public class PrivateRest {

    @GetMapping
    public String getMessage(){
        return "Ola do endpoint privado";
    }
}
