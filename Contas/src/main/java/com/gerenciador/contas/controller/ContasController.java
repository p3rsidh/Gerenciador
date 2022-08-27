package com.gerenciador.contas.controller;

import com.gerenciador.contas.model.ContaResponse;
import com.gerenciador.contas.model.ContasModel;
import com.gerenciador.contas.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
        if (!(buscaData.isEmpty())) {
            return new ResponseEntity<>(contasService.buscarUmaContaPorId(id), HttpStatus.OK);
        } else
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/contasPorStatus/{status}")
    public ResponseEntity<List<ContaResponse>> buscarContasPorStatus(@PathVariable String status){
        List<ContaResponse> buscaData = contasService.mostrarPorStatus(status);
        if (!(buscaData.isEmpty())) {
            return new ResponseEntity<>(contasService.mostrarPorStatus(status), HttpStatus.OK);
        } else
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/contasPorTipo/{tipo}")
    public ResponseEntity<List<ContaResponse>> buscarContasPorTipo(@PathVariable String tipo){
        List<ContaResponse> buscaData = contasService.mostrarPorTipo(tipo);
        if (!(buscaData.isEmpty())) {
            return new ResponseEntity<>(contasService.mostrarPorTipo(tipo), HttpStatus.OK);
        } else
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/contas/{id}")
    public ResponseEntity<List<ContaResponse>> apagarConta(@PathVariable Long id){
        return  new ResponseEntity<>(contasService.deletarConta(id),HttpStatus.NO_CONTENT);
    }

   }

