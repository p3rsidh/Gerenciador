package com.gerenciador.contas.model;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.Tipo;
import lombok.Data;

@Data
public class ContaResponse {

    private Long codigo;
    private String nome;
    private Double valor;
    private Status statusDePagamento;




}
