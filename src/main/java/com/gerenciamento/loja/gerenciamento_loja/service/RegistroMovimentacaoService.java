package com.gerenciamento.loja.gerenciamento_loja.service;

import com.gerenciamento.loja.gerenciamento_loja.domain.Estoque;
import com.gerenciamento.loja.gerenciamento_loja.domain.Movimentacao;
import com.gerenciamento.loja.gerenciamento_loja.domain.Produto;
import com.gerenciamento.loja.gerenciamento_loja.repository.MovimentacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegistroMovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;


    @Transactional
    public void execProduto(List<Produto> produtos) throws Exception {
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setProdutos(produtos);
        if(produtos.stream().map(Produto::getEstabelecimento).distinct().count() <= 1){
            movimentacao.setEstabelecimento(produtos.get(0).getEstabelecimento());
        } else {
            throw new Exception("Existem produtos de diferentes estabelecimentos");
        }
        movimentacao.setDataMovimentacao(LocalDateTime.now());
    }

    @Transactional
    public void execMovimentacao(Estoque estoque){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setEstoque(estoque);
        movimentacao.setDataMovimentacao(LocalDateTime.now());
    }


}
