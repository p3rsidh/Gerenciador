package com.gerenciador.contas.model.FactoryPattern;

import java.math.BigDecimal;

public class PagamentoEmDia implements Pagamentos{
    @Override
    public BigDecimal calcularValor(BigDecimal valoRecebido) {
        return valoRecebido;
    }
}
