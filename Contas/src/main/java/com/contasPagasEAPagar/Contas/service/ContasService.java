package com.contasPagasEAPagar.Contas.service;

import com.contasPagasEAPagar.Contas.enumeration.Status;
import com.contasPagasEAPagar.Contas.model.ContaResponse;
import com.contasPagasEAPagar.Contas.model.ContasModel;
import com.contasPagasEAPagar.Contas.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ContasService {

    @Autowired
    private ContasRepository contasRepository;




    public ContasModel adicionarConta(ContasModel contasModel) {

        contasModel.getCodigo();
        contasModel.getNome();
        contasModel.getValor();
        contasModel.getTipoPagamento();
        contasModel.getDataDeVencimento();

        LocalDate horaCadastro = LocalDate.now();
        if (contasModel.getDataDeVencimento() != null) {
            if (horaCadastro.isAfter(contasModel.getDataDeVencimento())) {
                contasModel.setStatusDePagamento(Status.VENCIDA);
            } else {
                contasModel.setStatusDePagamento(Status.AGUARDANDO);
            }
        }
        return contasRepository.save(contasModel);
    }

    public List<ContaResponse> listarContas() {

        List<ContaResponse> novaListaContas = new ArrayList<>();
        ContaResponse contaResponse = new ContaResponse();

        List<ContasModel> contasModelList = contasRepository.findAll();
        for (ContasModel conta : contasModelList) {
            contaResponse.setCodigo(conta.getCodigo());
            contaResponse.setNome(conta.getNome());
            contaResponse.setValor(conta.getValor());
            contaResponse.setStatusDePagamento(conta.getStatusDePagamento());
            novaListaContas.add(contaResponse);
        }
        return novaListaContas;
    }


//    public List<ContasModelCliente> mostrarContas(ContasModelCliente cliente) {
////       return contasRepository.findAll(contasModel.getCodigo(), contasModel.getNome(), contasModel.getValor(), contasModel.getStatusDePagamento());
//
//        return ContasCliente.listaContas;
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
