package com.gerenciador.contas.controller;

import com.gerenciador.contas.model.ContaResponse;
import com.gerenciador.contas.model.ContasModel;
import com.gerenciador.contas.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContasController {

    @Autowired
    private ContasService contasService;

    @PostMapping(path = "/contas")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <ContasModel> cadastrarConta(@RequestBody ContasModel contasModel){
        return ResponseEntity.ok(contasService.adicionarConta(contasModel));
    }

    @GetMapping(path = "/contas")
    public List<ContaResponse> mostrarContas(){
        return contasService.listarContas();

    }

    @PutMapping(path = "/contas/{id}")
    public ResponseEntity<ContasModel> informarPagamento(@RequestBody ContasModel id){
        if(contasService.listarContas().contains(id)) {
            return ResponseEntity.ok(contasService.alterarStatus(id));
        }else {

        }
    }

}
