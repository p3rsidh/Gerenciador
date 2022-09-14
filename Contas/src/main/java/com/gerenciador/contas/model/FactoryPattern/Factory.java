package com.gerenciador.contas.model.FactoryPattern;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.TipoRecebimento;

import java.time.LocalDate;

public class Factory {
    public Pagamentos getPagamentos(LocalDate vencimento, LocalDate pagamento) {

        if (vencimento.isEqual(pagamento)) {
            return null;

        } else if (vencimento.isBefore(pagamento)) {
            return new PagamentoAluguelAtrasado();

        } else if (vencimento.isAfter(pagamento)) {
            return new PagamentoAluguelAdiantado();

        }
        return null;
}}
