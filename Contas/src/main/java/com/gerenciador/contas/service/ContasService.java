package com.gerenciador.contas.service;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.Tipo;
import com.gerenciador.contas.model.ContaResponse;
import com.gerenciador.contas.model.ContasModel;
import com.gerenciador.contas.repository.ContasRepository;
import net.bytebuddy.implementation.bytecode.Throw;
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

        if (contasRepository.findAll().size() >0) {
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
        } else {
           return contasRepository.findAll().isEmpty().Throw(() -> new CityNotFoundException(id));
        }
      }

    public Optional<ContasModel> buscarUmaContaPorId(Long id) {


        if (contasRepository.findById(id).isPresent()) {
            return contasRepository.findById(id);
        }else {
        return null;
    }}

    public ContasModel alterarStatus(String status, Long id) {


       Optional<ContasModel> contasModel = contasRepository.findById(id);

        if(contasModel != null && status.contains("PAGA")){

            contasModel.get().setStatusDePagamento(Status.PAGA);
            contasModel.get().setDataDePagamento(LocalDateTime.now());

            return contasRepository.save(contasModel.get());

        }
    return null;
    }


   public List<ContaResponse> mostrarPorStatus(String status) {

    List<ContaResponse> novaListaContas = new ArrayList<>();
    List<ContasModel> status1 =  contasRepository.findByStatusDePagamento(Status.valueOf(status));
        for (ContasModel conta : status1) {
        ContaResponse contaResponse = new ContaResponse();

        contaResponse.setCodigo(conta.getCodigo());
        contaResponse.setNome(conta.getNome());
        contaResponse.setValor(conta.getValor());
        contaResponse.setStatusDePagamento(conta.getStatusDePagamento());
        novaListaContas.add(contaResponse);
    }
        return novaListaContas;
    }

    public List<ContaResponse> mostrarPorTipo(String tipo){

        List<ContaResponse> novaListaContas = new ArrayList<>();
        List<ContasModel> tipo1 =  contasRepository.findByTipoPagamento(Tipo .valueOf(tipo));
        for (ContasModel conta : tipo1) {
            ContaResponse contaResponse = new ContaResponse();

            contaResponse.setCodigo(conta.getCodigo());
            contaResponse.setNome(conta.getNome());
            contaResponse.setValor(conta.getValor());
            contaResponse.setStatusDePagamento(conta.getStatusDePagamento());
            novaListaContas.add(contaResponse);
        }
        return novaListaContas;
    }
//
//    public ContasModel deletarConta(){
//
//    }

}

