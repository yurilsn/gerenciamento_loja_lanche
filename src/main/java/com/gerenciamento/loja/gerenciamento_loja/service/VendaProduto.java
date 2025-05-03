package com.gerenciamento.loja.gerenciamento_loja.service;


import com.gerenciamento.loja.gerenciamento_loja.domain.Produto;
import com.gerenciamento.loja.gerenciamento_loja.domain.Venda;
import com.gerenciamento.loja.gerenciamento_loja.repository.VendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public class VendaProduto {
    private final VendaRepository vendaRepository;

    @Transactional
    public Venda exec(List<Produto> produtos){
        Venda venda = new Venda();
        venda.setProdutos(produtos);
        venda.setTotalVenda(calculaTotalProdutos(produtos));
        return vendaRepository.save(venda);
    }

    @Transactional
    public Integer calculaTotalProdutos(List<Produto> produtos){
//        return produtos.stream().mapToInt(
//                Produto::getValor
//        ).sum();
        return produtos.stream().map(
                Produto::getValor
        ).reduce(0, Integer::sum);
    }


}
