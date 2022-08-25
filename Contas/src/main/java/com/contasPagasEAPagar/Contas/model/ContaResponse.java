package com.contasPagasEAPagar.Contas.model;

import com.contasPagasEAPagar.Contas.enumeration.Status;
import lombok.Data;

@Data
public class ContaResponse {

    private Long codigo;
    private String nome;
    private Double valor;
    private Status statusDePagamento;
}
