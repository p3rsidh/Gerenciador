package com.gerenciador.contas.controller;

import com.gerenciador.contas.model.ContaResponse;
import com.gerenciador.contas.model.ContasModel;
import com.gerenciador.contas.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContasController {

    @Autowired
    private ContasService contasService;

    @PostMapping(path = "/contas")
    @ResponseStatus
    public ContasModel cadastrarConta(@RequestBody ContasModel contasModel){
        return contasService.adicionarConta(contasModel);
    }

    @GetMapping(path = "/contas")
    public List<ContaResponse> mostrarContas(){
        return contasService.listarContas();

    }

    @PutMapping(path = "/contas/{id}")
    public ContasModel informarPagamento(@RequestBody ContasModel id){
       return contasService.alterarStatus(id);
    }

}
