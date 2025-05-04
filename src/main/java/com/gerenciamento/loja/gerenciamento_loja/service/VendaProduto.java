package com.gerenciamento.loja.gerenciamento_loja.service;


import com.gerenciamento.loja.gerenciamento_loja.domain.Movimentacao;
import com.gerenciamento.loja.gerenciamento_loja.domain.Produto;
import com.gerenciamento.loja.gerenciamento_loja.domain.Usuario;
import com.gerenciamento.loja.gerenciamento_loja.domain.Venda;
import com.gerenciamento.loja.gerenciamento_loja.domain.enums.Estabelecimento;
import com.gerenciamento.loja.gerenciamento_loja.domain.enums.TipoMovimentacao;
import com.gerenciamento.loja.gerenciamento_loja.repository.MovimentacaoRepository;
import com.gerenciamento.loja.gerenciamento_loja.repository.UsuarioRepository;
import com.gerenciamento.loja.gerenciamento_loja.repository.VendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VendaProduto {
    private final VendaRepository vendaRepository;
    private final MovimentacaoRepository movimentacaoRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Venda exec(List<Produto> produtos, String usuario){

        Usuario usuario1 = usuarioRepository.findByNome(usuario).orElseThrow();
        List<Movimentacao> movimentacoes = new ArrayList<>();
        movimentacoes.add(createMovimentacao(produtos));
        usuario1.setMovimentacoes(movimentacoes);

        return vendaRepository.save(createVenda(produtos));
    }

    @Transactional
    public Integer calculaTotalProdutos(List<Produto> produtos){
        return produtos.stream().map(
               Produto::getValor
        ).reduce(0, Integer::sum);
    }

    public Movimentacao createMovimentacao(List<Produto> produtos){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setProdutos(produtos);
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setEstabelecimento(produtos.get(0).getEstabelecimento());
        return movimentacao;
    }

    public Venda createVenda(List<Produto> produtos){
        Venda venda = new Venda();

        venda.setProdutos(produtos);
        venda.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        venda.setEstabelecimento(produtos.get(0).getEstabelecimento());
        venda.setTotalVenda(calculaTotalProdutos(produtos));
        return venda;
    }

}
