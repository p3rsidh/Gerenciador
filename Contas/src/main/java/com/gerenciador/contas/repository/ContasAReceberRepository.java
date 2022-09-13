package com.gerenciador.contas.repository;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.TipoRecebimento;
import com.gerenciador.contas.model.ContasAReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ContasAReceberRepository extends JpaRepository<ContasAReceberModel, Long> {

   List<ContasAReceberModel> findByStatus(Status status);
  // List<ContasAReceberModel> findByTipoDeRecebimento(TipoRecebimento tipoRecebimento);
//    ContasAReceberModel findByDataDeVencimento(LocalDate localDate);
}
