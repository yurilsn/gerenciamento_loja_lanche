package com.gerenciamento.loja.gerenciamento_loja.domain;


import com.gerenciamento.loja.gerenciamento_loja.domain.enums.Estabelecimento;
import com.gerenciamento.loja.gerenciamento_loja.domain.enums.TipoMovimentacao;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.sound.sampled.Port;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "MOVIMENTACAO")
@DynamicUpdate
@DynamicInsert
@ToString(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime dataMovimentacao;


    @Column
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    @Column
    @Enumerated(EnumType.STRING)
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ESTOQUE_ID")
    private Estoque estoque;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MOVIMENTACAO_ID", referencedColumnName = "id")
    private List<Produto> produtos;

}
