package com.gerenciador.contas.service;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.TipoRecebimento;
import com.gerenciador.contas.model.ContasAReceberModel;
import com.gerenciador.contas.repository.ContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.*;

@Service
public class ContasAReceberService {

    @Autowired
    private ContasAReceberRepository contasAReceberRepository;

    public ContasAReceberModel adicionarConta(ContasAReceberModel contasAReceberModel) {
        LocalDate horaCadastro = LocalDate.now();

        if (contasAReceberModel.getDataDeVencimento() != null) {
            if (horaCadastro.isAfter(contasAReceberModel.getDataDeVencimento())) {
                contasAReceberModel.setStatus(Status.VENCIDA);
            } else {
                contasAReceberModel.setStatus(Status.AGUARDANDO);
            }
        }
        return contasAReceberRepository.save(contasAReceberModel);
    }

    public List<ContasAReceberModel> listarContas() {

        if (contasAReceberRepository.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } else {
            return contasAReceberRepository.findAll();
        }
    }
        public Optional<ContasAReceberModel> buscarUmaContaPorId(Long id) {

            if (contasAReceberRepository.findAll().isEmpty()){
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            } else if (contasAReceberRepository.findById(id).isPresent()) {
                return contasAReceberRepository.findById(id);
            } else
                throw new NoSuchElementException();
        }

        public ContasAReceberModel alterarConta(ContasAReceberModel contasAReceberModel, Long id) {

           Optional<ContasAReceberModel> conta = contasAReceberRepository.findById(id);

            if (contasAReceberRepository.findAll().isEmpty()){
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            } else if(conta != null) {
                return contasAReceberRepository.save(contasAReceberModel);
            }
            throw new NoSuchElementException();

        }


        public List<ContasAReceberModel> mostrarPorStatus(Status status) {

            int tamanhoLista = contasAReceberRepository.findAll().size();
            List<ContasAReceberModel> status1 = contasAReceberRepository.findAll();
            List<ContasAReceberModel> contasStatus = null;

            if (tamanhoLista > 0) {
                if (status1.isEmpty()) {
                    throw new NoSuchElementException();
                } else {
                    contasAReceberRepository.findByStatus(status);
//                    for (ContasAReceberModel conta : status1) {
//                        if (conta.getStatus().equals(status)) {
//                            contasStatus.add(conta);
//                        }
                    }
//                    return contasStatus;
                }
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

//        public ContasAReceberModel mostrarPorTipoDeRebecimento(TipoRecebimento tipo) {
//
//            int tamanhoLista = contasAReceberRepository.findAll().size();
//           // List<ContasAReceberModel> tipo1 = contasAReceberRepository.findByTipoDeRecebimento(tipo);
//
//            if (tamanhoLista > 0) {
//                if (contasAReceberRepository.findAll().isEmpty()){
//                    throw new NoSuchElementException();
//                } else
//                return contasAReceberRepository.findByTipoDeRecebimento(tipo);
//            } else
//                throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
//        }
//
//        public ContasAReceberModel mostrarPorDataDeVencimento(LocalDate localDate) {
//
//            int tamanhoLista = contasAReceberRepository.findAll().size();
//          //  List<ContasAReceberModel> tipo1 = contasAReceberRepository.findByDataDeVencimento(localDate);
//
//            if (tamanhoLista > 0) {
//                if (contasAReceberRepository.findAll().isEmpty()){
//                    throw new NoSuchElementException();
//                } else
//                    return contasAReceberRepository.findByDataDeVencimento(localDate);
//            } else
//                throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
//        }

        public HttpStatus deletarConta(Long id){
            int tamanhoLista = contasAReceberRepository.findAll().size();
            if (tamanhoLista > 0 && contasAReceberRepository.findById(id).isPresent() ){
                contasAReceberRepository.deleteById(id);
            }else if (tamanhoLista > 0 && !(contasAReceberRepository.findById(id).isPresent())) {
                throw new NoSuchElementException();
            } else {
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            }
            return HttpStatus.NO_CONTENT;
        }

}

