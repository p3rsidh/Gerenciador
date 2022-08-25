package com.contasPagasEAPagar.Contas.repository;

import com.contasPagasEAPagar.Contas.model.ContasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasRepository extends JpaRepository<ContasModel, Long> {

}
