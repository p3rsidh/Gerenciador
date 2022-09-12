package com.gerenciador.contas.service;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.Tipo;
import com.gerenciador.contas.model.ContaResponse;
import com.gerenciador.contas.model.ContasModel;
import com.gerenciador.contas.repository.ContasRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.NullValueInNestedPathException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


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
        if (contasRepository.findAll().isEmpty()){
             throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }else {
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
    }


    public Optional<ContasModel> buscarUmaContaPorId(Long id) {
        Optional<ContasModel> contasModel = contasRepository.findById(id);

        if (contasRepository.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } else if (contasRepository.findById(id).isPresent()) {
            return contasRepository.findById(id);
        } else
            throw new NoSuchElementException();
    }

    public ContasModel alterarStatus(String status, Long id) {

       Optional<ContasModel> contasModel = contasRepository.findById(id);
        if (contasRepository.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } else if(contasModel != null && status.contains("PAGA")){

            contasModel.get().setStatusDePagamento(Status.PAGA);
            contasModel.get().setDataDePagamento(LocalDateTime.now());

            return contasRepository.save(contasModel.get());

        }
        throw new NoSuchElementException();

    }


   public ListIterator<ContaResponse> mostrarPorStatus(String status) {

    int tamanhoLista = contasRepository.findAll().size();
    List<ContaResponse> novaListaContas = new ArrayList<>();
    List<ContasModel> status1 =  contasRepository.findByStatusDePagamento(Status.valueOf(status));

    if (tamanhoLista > 0) {
        if (status1.isEmpty()){
            throw new NoSuchElementException();
        }
        for (ContasModel conta : status1) {
            ContaResponse contaResponse = new ContaResponse();

            contaResponse.setCodigo(conta.getCodigo());
            contaResponse.setNome(conta.getNome());
            contaResponse.setValor(conta.getValor());
            contaResponse.setStatusDePagamento(conta.getStatusDePagamento());
            novaListaContas.add(contaResponse);
        }
        return novaListaContas.listIterator();
    }
    throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    public List<ContaResponse> mostrarPorTipo(String tipo) {

        int tamanhoLista = contasRepository.findAll().size();
        List<ContaResponse> novaListaContas = new ArrayList<>();
        List<ContasModel> tipo1 = contasRepository.findByTipoPagamento(Tipo.valueOf(tipo));
        if (tamanhoLista > 0) {
            if (tipo1.isEmpty()){
                throw new NoSuchElementException();
            } else
            for (ContasModel conta : tipo1) {
                ContaResponse contaResponse = new ContaResponse();

                contaResponse.setCodigo(conta.getCodigo());
                contaResponse.setNome(conta.getNome());
                contaResponse.setValor(conta.getValor());
                contaResponse.setStatusDePagamento(conta.getStatusDePagamento());
                novaListaContas.add(contaResponse);
            }
            return novaListaContas;
        } else
        throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }

    public List<ContaResponse> deletarConta(Long id){
        int tamanhoLista = contasRepository.findAll().size();
        if (tamanhoLista > 0 && contasRepository.findById(id).isPresent() ){
            contasRepository.deleteById(id);
        }else if (tamanhoLista > 0 && !(contasRepository.findById(id).isPresent())) {
            throw new NoSuchElementException();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return listarContas();
    }

}

