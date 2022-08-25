package com.gerenciador.contas.repository;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.Tipo;
import com.gerenciador.contas.model.ContasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Enumeration;
import java.util.List;

@Repository
public interface ContasRepository extends JpaRepository<ContasModel, Long> {
    public List<ContasModel> findByStatusDePagamento(Status status);
    public List<ContasModel> findByTipoDePagamento(Tipo tipo);
}
