package com.gerenciamento.loja.gerenciamento_loja.security.rest;

import com.gerenciamento.loja.gerenciamento_loja.security.service.AutenticacaoService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AutenticacaoRest {
    private final AutenticacaoService autenticacaoService;


    @GetMapping("autenticacao")
    public String autenticacao(Authentication authentication){
        return autenticacaoService.autenticacao(authentication);
    }

}
