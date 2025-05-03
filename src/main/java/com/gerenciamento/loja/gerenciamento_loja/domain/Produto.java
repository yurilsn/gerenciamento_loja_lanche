package com.gerenciamento.loja.gerenciamento_loja.domain;


import com.gerenciamento.loja.gerenciamento_loja.domain.enums.Estabelecimento;
import com.gerenciamento.loja.gerenciamento_loja.domain.enums.TipoMovimentacao;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "PRODUTO")
@DynamicUpdate
@DynamicInsert
@ToString(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private Integer valor;

    @Column
    private Integer qtdProdutos;

    @Column
    @Enumerated(EnumType.STRING)
    private Estabelecimento estabelecimento;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
}
