package com.gerenciador.contas.service;


import com.gerenciador.contas.model.EnderecoModel;
import com.gerenciador.contas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> buscarTodos(){
        return enderecoRepository.findAll();
    }

    public Optional<EnderecoModel> buscarId(Long codigo){
        return enderecoRepository.findById(codigo);
    }

    public EnderecoModel cadastrar(EnderecoModel endereco){
        return enderecoRepository.save(endereco);
    }

    public EnderecoModel alterar(EnderecoModel endereco){

        return enderecoRepository.save(endereco);
    }

    public void deletar(Long codigo){
        if (enderecoRepository.findById(codigo).isPresent()) {
            enderecoRepository.deleteById(codigo);
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }else if (enderecoRepository.findAll().isEmpty()){
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }else
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
    }
}