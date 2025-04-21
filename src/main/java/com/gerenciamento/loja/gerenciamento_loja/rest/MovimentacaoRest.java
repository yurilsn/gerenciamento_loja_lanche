package com.gerenciamento.loja.gerenciamento_loja.rest;


import com.gerenciamento.loja.gerenciamento_loja.domain.Movimentacao;
import com.gerenciamento.loja.gerenciamento_loja.repository.MovimentacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movimentacao")
@AllArgsConstructor
public class MovimentacaoRest {

    private final MovimentacaoRepository movimentacaoRepository;

    @PostMapping
    public Movimentacao save(@RequestBody Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }

}
