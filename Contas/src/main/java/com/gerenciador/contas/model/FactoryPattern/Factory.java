package com.gerenciador.contas.model.FactoryPattern;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.TipoRecebimento;

import java.time.LocalDate;

public class Factory {
    public Pagamentos getPagamentos(TipoRecebimento tipoRecebimento, LocalDate vencimento, LocalDate pagamento) {

        if (tipoRecebimento.equals(TipoRecebimento.ALUGUEIS)){
        if (vencimento.isEqual(pagamento)) {
            return new PagamentoEmDia();
        } else if (vencimento.isBefore(pagamento)) {
            return new PagamentoAluguelAtrasado();

        } else if (vencimento.isAfter(pagamento)) {
            return new PagamentoAluguelAdiantado();

        }}else {
            return new PagamentoEmDia();
        }
        return null;
}}
