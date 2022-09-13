package com.gerenciador.contas.service;


import com.gerenciador.contas.model.EnderecoModel;
import com.gerenciador.contas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        enderecoRepository.deleteById(codigo);
    }
}