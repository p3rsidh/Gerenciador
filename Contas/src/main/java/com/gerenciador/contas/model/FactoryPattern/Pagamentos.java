package com.gerenciador.contas.model.FactoryPattern;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.BiConsumer;

public interface Pagamentos {
    public BigDecimal calcularValor (BigDecimal valoRecebido);
}
