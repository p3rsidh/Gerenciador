package com.contasPagasEAPagar.Contas.model;


import com.contasPagasEAPagar.Contas.enumeration.Status;
import com.contasPagasEAPagar.Contas.enumeration.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contas")
public class ContasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double valor;

    @Column
    private LocalDate dataDeVencimento;

    @Column
    private LocalDateTime dataDePagamento;

    @Column
    private Tipo tipoPagamento;

    @Column
    private Status statusDePagamento;


}

