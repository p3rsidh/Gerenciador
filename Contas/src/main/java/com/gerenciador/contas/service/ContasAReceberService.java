package com.gerenciador.contas.service;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.TipoRecebimento;
import com.gerenciador.contas.model.ContasAReceberModel;
import com.gerenciador.contas.repository.ContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDate;
import java.util.*;

@Service
public class ContasAReceberService {

    @Autowired
    private ContasAReceberRepository contasAReceberRepository;

    public ContasAReceberModel adicionarConta(ContasAReceberModel contasAReceberModel) {
        LocalDate horaCadastro = LocalDate.now();
        contasAReceberModel.setDataDeRecebimento(horaCadastro);
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


        public List<ContasAReceberModel> mostrarPorBusca(String busca) {

            if (contasAReceberRepository.findAll().size() > 0) {
                if (busca.equalsIgnoreCase("PAGA") || busca.equalsIgnoreCase("VENCIDA") || busca.equalsIgnoreCase("AGUARDANDO")) {
                    List<ContasAReceberModel> status1 = contasAReceberRepository.findByStatus(Status.valueOf(busca));

                    if (status1.isEmpty()) {
                        throw new NoSuchElementException();
                    } else {
                        return status1;
                    }
                } else if (busca.equalsIgnoreCase("ALUGUEIS") || busca.equalsIgnoreCase("EMPREGO_CLT") || busca.equalsIgnoreCase("FREELANCER")) {
                    List<ContasAReceberModel> status1 = contasAReceberRepository.findByTipoRecebimento(TipoRecebimento.valueOf(busca));

                    if (status1.isEmpty()) {
                        throw new NoSuchElementException();
                    } else {
                        return status1;
                    }
                } throw new HttpClientErrorException(HttpStatus.EXPECTATION_FAILED);
            }throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
            }


        public List<ContasAReceberModel> mostrarPorDataDeVencimento(String localDate) {
            LocalDate localDate1 = LocalDate.parse(localDate);

            if (contasAReceberRepository.findAll().size() > 0) {
                if (contasAReceberRepository.findByDataDeVencimento(localDate1).isEmpty()){
                    throw new NoSuchElementException();
                } else
                    return contasAReceberRepository.findByDataDeVencimento(localDate1);
            } else
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }



        public ContasAReceberModel deletarConta(Long id){
            int tamanhoLista = contasAReceberRepository.findAll().size();
            if (tamanhoLista > 0 && contasAReceberRepository.findById(id).isPresent() ){
                 contasAReceberRepository.deleteById(id);
                 throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
                // return new DeleteMessage(HttpStatus.NO_CONTENT,"Objeto Apagado");
            }else if (tamanhoLista > 0 && !(contasAReceberRepository.findById(id).isPresent())) {
                throw new NoSuchElementException();
            } else {
                throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
            }

        }

}

