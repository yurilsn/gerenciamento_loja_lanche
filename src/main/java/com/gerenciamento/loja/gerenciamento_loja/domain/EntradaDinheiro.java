package com.gerenciamento.loja.gerenciamento_loja.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "ENTRADA_DINHEIRO")
@DynamicUpdate
@DynamicInsert
@ToString(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class EntradaDinheiro {

    @Id
    @Column(name = "id")
    private Long id;

    @Column
    public String valor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "venda_id", referencedColumnName = "id")  // This means Foreign key will be created only in the Product table i.e. extra column 'stock_id' will be created in the Product table
    private Venda venda;
}
