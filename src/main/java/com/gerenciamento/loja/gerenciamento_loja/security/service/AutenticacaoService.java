package com.gerenciamento.loja.gerenciamento_loja.security.service;

import com.gerenciamento.loja.gerenciamento_loja.security.jwt.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutenticacaoService {

    private final JwtService jwtService;

    public String autenticacao(Authentication authentication){
        return jwtService.gerarToken(authentication);
    }
}
