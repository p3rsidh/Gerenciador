package com.gerenciador.contas.service;


import com.gerenciador.contas.model.EstadoModel;
import com.gerenciador.contas.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<EstadoModel> buscarTodos(){
        return estadoRepository.findAll();
    }

    public Optional<EstadoModel> buscarPorId(Long id){
        return estadoRepository.findById(id);
    }

    public EstadoModel cadastrar(EstadoModel estado){
        estado.getCodigo();
        return estadoRepository.save(estado);
    }

    public EstadoModel alterar(EstadoModel estado){
        return estadoRepository.save(estado);
    }

    public List<EstadoModel> deletar(Long id){
        estadoRepository.deleteById(id);
        return buscarTodos();
    }
}