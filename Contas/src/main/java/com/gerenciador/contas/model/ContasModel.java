package com.gerenciador.contas.model;


import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.Tipo;
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

