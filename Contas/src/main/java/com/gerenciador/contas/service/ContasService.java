package com.gerenciador.contas.service;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.model.ContaResponse;
import com.gerenciador.contas.model.ContasModel;
import com.gerenciador.contas.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ContasService {

    @Autowired
    private ContasRepository contasRepository;




    public ContasModel adicionarConta(ContasModel contasModel) {

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
        List<ContasModel> contasModelList = contasRepository.findAll();

        for (ContasModel conta : contasModelList) {
            ContaResponse contaResponse = new ContaResponse();

            contaResponse.setCodigo(conta.getCodigo());
            contaResponse.setNome(conta.getNome());
            contaResponse.setValor(conta.getValor());
            contaResponse.setStatusDePagamento(conta.getStatusDePagamento());
            novaListaContas.add(contaResponse);
        }

        return novaListaContas;
    }

    public Optional<ContasModel> buscarUmaContaPorId(Long id){
        return contasRepository.findById(id);
    }

    public ContasModel alterarStatus(ContasModel contasModel){

        if (contasModel.getStatusDePagamento() == Status.PAGA){
            contasModel.setDataDePagamento(LocalDateTime.now());
        }
            return contasRepository.save(contasModel);
        }}

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



