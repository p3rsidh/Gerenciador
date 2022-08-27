package com.gerenciador.contas.controller;

import com.gerenciador.contas.model.ContaResponse;
import com.gerenciador.contas.model.ContasModel;
import com.gerenciador.contas.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<ContaResponse>> mostrarContas(){
    List<ContaResponse> contasService1 = contasService.listarContas();
        if (!(contasService1.isEmpty())) {
            return ResponseEntity.ok(contasService.listarContas());
        } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping(path = "/contas/{id}")
    public ResponseEntity<ContasModel> informarPagamento(@RequestBody String status, @PathVariable Long id) {
        return ResponseEntity.ok(contasService.alterarStatus(status, id));
    }

    @GetMapping(path = "/contas/{id}")
    public ResponseEntity<Optional<ContasModel>> buscarContaEspecificaPorId(@PathVariable Long id){

        Optional<ContasModel> buscaData = contasService.buscarUmaContaPorId(id);
        if (buscaData.isPresent()) {
            return new ResponseEntity<>(contasService.buscarUmaContaPorId(id), HttpStatus.OK);
        } else
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);



    }

    @GetMapping(path = "/contasPorStatus/{status}")
    public List<ContaResponse> buscarContasPorStatus(@PathVariable String status){
        return contasService.mostrarPorStatus(status);
    }

    @GetMapping(path = "/contasPorTipo/{tipo}")
    public List<ContaResponse> buscarContasPorTipo(@PathVariable String tipo){
        return contasService.mostrarPorTipo(tipo);
    }


   }

