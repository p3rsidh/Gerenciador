package com.gerenciador.contas.service;

import com.gerenciador.contas.model.CidadeModel;
import com.gerenciador.contas.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeReposirory;

    public List<CidadeModel> buscarTodas(){
        return cidadeReposirory.findAll();
    }

    public Optional<CidadeModel> buscarPorId(Long id){
        return cidadeReposirory.findById(id);
    }

    public CidadeModel cadastrar(CidadeModel cidade){
        return cidadeReposirory.save(cidade);
    }

    public CidadeModel alterar(CidadeModel cidade){
        return cidadeReposirory.save(cidade);
    }

    public List<CidadeModel> deletar(Long id){
        cidadeReposirory.deleteById(id);
        return buscarTodas();
    }
}