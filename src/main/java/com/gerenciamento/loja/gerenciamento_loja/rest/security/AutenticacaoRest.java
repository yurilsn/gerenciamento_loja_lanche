package com.gerenciamento.loja.gerenciamento_loja.rest.security;

import com.gerenciamento.loja.gerenciamento_loja.domain.Usuario;
import com.gerenciamento.loja.gerenciamento_loja.service.security.AutenticacaoService;
import lombok.AllArgsConstructor;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
