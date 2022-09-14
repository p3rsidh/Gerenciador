package com.gerenciador.contas.model.FactoryPattern;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PagamentoAluguelAtrasado implements Pagamentos{


    @Override
    public BigDecimal calcularValor(BigDecimal valoRecebido) {
        BigDecimal multa = BigDecimal.valueOf(0.035);
        BigDecimal valorDesconto = valoRecebido.multiply(multa);
        BigDecimal valorTotal = valoRecebido.add(valorDesconto);
        return valorTotal;

    }
}
