package com.gerenciamento.loja.gerenciamento_loja.domain;


import com.gerenciamento.loja.gerenciamento_loja.domain.enums.Estabelecimento;
import com.gerenciamento.loja.gerenciamento_loja.domain.enums.TipoMovimentacao;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "VENDA")
@DynamicUpdate
@DynamicInsert
@ToString(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer totalVenda;

    @Column
    @Enumerated(EnumType.STRING)
    private Estabelecimento estabelecimento;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "VENDA_PRODUTO",
            joinColumns = @JoinColumn(name = "venda_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id", referencedColumnName = "id"))
    private List<Produto> produtos;
}
