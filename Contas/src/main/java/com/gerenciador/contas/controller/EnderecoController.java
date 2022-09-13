package com.gerenciador.contas.controller;

import com.gerenciador.contas.model.EnderecoModel;
import com.gerenciador.contas.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(path = "/enderecos")
    public List<EnderecoModel> buscarTodosClientes(){
        return enderecoService.buscarTodos();
    }

    @GetMapping(path = "/enderecos/{codigo}")
    public Optional<EnderecoModel> buscarPorId(@PathVariable Long codigo){
        return enderecoService.buscarId(codigo);
    }

    @PostMapping(path = "/enderecos")
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoModel cadastrarEndereco(@RequestBody EnderecoModel endereco){
        return enderecoService.cadastrar(endereco);
    }

    @PutMapping(path = "/enderecos/{codigo}")
    public EnderecoModel alterarEndereco(@RequestBody EnderecoModel endereco){
        return enderecoService.alterar(endereco);
    }

    @DeleteMapping(path = "/enderecos/{codigo}")
    public void deletarEndereco(@PathVariable Long codigo){
        enderecoService.deletar(codigo);
    }
}