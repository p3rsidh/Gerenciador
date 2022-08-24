package com.contasPagasEAPagar.Contas.Contas_Service;

import com.contasPagasEAPagar.Contas.Contas_Model.ContasModel;
import com.contasPagasEAPagar.Contas.Contas_Repository.ContasRepository;
import com.contasPagasEAPagar.Contas.ENUM.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

@Service
public class ContasService {

    @Autowired
    private ContasRepository contasRepository;


    public ContasModel adicionarConta(ContasModel contasModel){

        contasModel.getCodigo();
        contasModel.getNome();
        contasModel.getValor();
        contasModel.getTipoPagamento();
        contasModel.getDataDeVencimento();
        contasModel.setDataDePagamento(LocalDate.now());

        if (contasModel.getDataDeVencimento() != null && contasModel.getDataDePagamento() != null) {
            if (contasModel.getDataDePagamento().isAfter(contasModel.getDataDeVencimento())) {
                contasModel.setStatusDePagamento(Status.valueOf("Vencida"));
            } else {
                contasModel.setStatusDePagamento(Status.valueOf("Aguardando"));
            }
        }
        return contasRepository.save(contasModel);
    }

//    public ContasModel mostrarContas() {
//        while ()
//
//            return
//    }
//////
//    public ContasModel mostrarPorStatus(){
//
//    }
//
//    public ContasModel mostrarPorTipo(){
//
//    }
//
//    public ContasModel deletarConta(){
//
//    }


}
