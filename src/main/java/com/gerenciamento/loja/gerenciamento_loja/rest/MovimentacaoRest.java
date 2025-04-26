package com.gerenciamento.loja.gerenciamento_loja.rest;


import com.gerenciamento.loja.gerenciamento_loja.domain.Movimentacao;
import com.gerenciamento.loja.gerenciamento_loja.repository.MovimentacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movimentacao")
@AllArgsConstructor
public class MovimentacaoRest {

    private MovimentacaoRepository movimentacaoRepository;

    @PostMapping
    public Movimentacao save(@RequestBody Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }


    @GetMapping
    public List<Movimentacao> findAll(@RequestBody Movimentacao movimentacao){
        return movimentacaoRepository.findAll();
    }

}
