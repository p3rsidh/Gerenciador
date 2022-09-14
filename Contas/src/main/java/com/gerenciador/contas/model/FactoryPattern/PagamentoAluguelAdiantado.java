package com.gerenciador.contas.model.FactoryPattern;

import java.math.BigDecimal;

public class PagamentoAluguelAdiantado implements Pagamentos{

    @Override
    public BigDecimal calcularValor(BigDecimal valoRecebido) {
        BigDecimal desconto = BigDecimal.valueOf(0.05);
        BigDecimal valorDeDesconto = valoRecebido.multiply(desconto);
        BigDecimal valorTotal = valoRecebido.subtract(valorDeDesconto);

        return valorTotal;

    }
}
