package com.gerenciador.contas.repository;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.TipoRecebimento;
import com.gerenciador.contas.model.ContasAReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface ContasAReceberRepository extends JpaRepository<ContasAReceberModel, Long> {

    List<ContasAReceberModel> findByStatus(Status status);
    List<ContasAReceberModel> findByTipoDeRecebimento(TipoRecebimento tipoRecebimento);
    List<ContasAReceberModel> findByDataDeVencimento(LocalDate localDate);
}
