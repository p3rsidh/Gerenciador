package com.gerenciador.contas.controller;

import com.gerenciador.contas.model.EstadoModel;
import com.gerenciador.contas.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping(path = "/estados")
    public List<EstadoModel> buscarTodos(){
        return estadoService.buscarTodos();
    }

    @GetMapping(path = "/estados/{codigo}")
    public Optional<EstadoModel> buscarPorId(@PathVariable Long codigo){
        return estadoService.buscarPorId(codigo);
    }

    @PostMapping(path = "/estados")
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoModel cadastrar(@RequestBody EstadoModel estado){
        return estadoService.cadastrar(estado);
    }

    @PutMapping(path = "estados/{codigo}")
    public EstadoModel alterarEstado(@RequestBody EstadoModel estado){
        return estadoService.alterar(estado);
    }

    @DeleteMapping(path = "/estados/{codigo}")
    public List<EstadoModel> deletarEstado(@PathVariable Long codigo){
        return estadoService.deletar(codigo);
    }


}