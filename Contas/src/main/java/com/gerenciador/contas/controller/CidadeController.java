package com.gerenciador.contas.controller;

import com.gerenciador.contas.model.CidadeModel;
import com.gerenciador.contas.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping(path = "/cidades")
    public List<CidadeModel> buscarTodos(){
        return cidadeService.buscarTodas();
    }

    @GetMapping(path = "/cidades/{codigo}")
    public Optional<CidadeModel> buscarPorId(@PathVariable Long codigo){
        return cidadeService.buscarPorId(codigo);
    }

    @PostMapping(path = "/cidades")
    public CidadeModel cadastrarCidade(@RequestBody CidadeModel cidade){
        return cidadeService.cadastrar(cidade);
    }

    @PutMapping(path = "/cidade/{codigo}")
    public CidadeModel alterarCidade(@RequestBody CidadeModel cidade){
        return cidadeService.alterar(cidade);
    }

    @DeleteMapping(path = "/cidade/{codigo}")
    public List<CidadeModel> deletarCidade(@PathVariable Long codigo){
        return cidadeService.deletar(codigo);
    }
}