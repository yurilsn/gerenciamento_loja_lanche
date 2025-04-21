package com.gerenciamento.loja.gerenciamento_loja.repository;

import com.gerenciamento.loja.gerenciamento_loja.domain.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
