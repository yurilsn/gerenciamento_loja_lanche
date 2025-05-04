package com.gerenciamento.loja.gerenciamento_loja.rest;


import com.gerenciamento.loja.gerenciamento_loja.domain.Produto;
import com.gerenciamento.loja.gerenciamento_loja.domain.Venda;
import com.gerenciamento.loja.gerenciamento_loja.service.VendaProduto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/venda")
@AllArgsConstructor
public class VendaRest {

    private VendaProduto vendaProduto;

    @PostMapping
    public Venda executaVenda(@RequestBody List<Produto> produtos, @RequestHeader String jwt){
        return  vendaProduto.exec(produtos, jwt);
    }
}
