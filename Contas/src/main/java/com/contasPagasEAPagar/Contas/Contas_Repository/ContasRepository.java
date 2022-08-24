package com.contasPagasEAPagar.Contas.Contas_Repository;

import com.contasPagasEAPagar.Contas.Contas_Model.ContasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasRepository extends JpaRepository<ContasModel, Long> {
}
