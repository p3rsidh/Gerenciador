package com.gerenciador.contas.model;


import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

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
    String nome;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private LocalDate dataDeVencimento;

    @Column
    private LocalDateTime dataDePagamento;

    @Column(nullable = false)
    private Tipo tipoPagamento;


    @Column
    private Status statusDePagamento;


}

