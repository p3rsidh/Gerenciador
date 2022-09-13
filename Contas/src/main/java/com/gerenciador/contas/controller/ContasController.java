package com.gerenciador.contas.controller;

import com.gerenciador.contas.execption.ExceptionHandlerContas;
import com.gerenciador.contas.model.ContaResponse;
import com.gerenciador.contas.model.ContasModel;
import com.gerenciador.contas.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@RestController
public class ContasController extends ExceptionHandlerContas{

    @Autowired
    private ContasService contasService;

    @PostMapping(path = "/contas")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <ContasModel> cadastrarConta(@RequestBody ContasModel contasModel){
      return ResponseEntity.ok(contasService.adicionarConta(contasModel));

    }

    @GetMapping(path = "/contas")
    public ResponseEntity<List<ContaResponse>> mostrarContas(){
      return ResponseEntity.ok(contasService.listarContas());
    }

    @PutMapping(path = "/contas/{id}")
    public ResponseEntity<ContasModel> informarPagamento(@RequestBody String status, @PathVariable Long id) {
        return ResponseEntity.ok(contasService.alterarStatus(status, id));
    }

    @GetMapping(path = "/contas/{id}")
    public ResponseEntity<Optional<ContasModel>> buscarContaEspecificaPorId(@PathVariable Long id){
    return ResponseEntity.ok(contasService.buscarUmaContaPorId(id));
    }

    @GetMapping(path = "/contasPorStatus/{status}")
    public ResponseEntity<ListIterator<ContaResponse>> buscarContasPorStatus(@PathVariable String status){
        return ResponseEntity.ok(contasService.mostrarPorStatus(status));
    }

    @GetMapping(path = "/contasPorTipo/{tipo}")
    public ResponseEntity<List<ContaResponse>> buscarContasPorTipo(@PathVariable String tipo){
        return ResponseEntity.ok(contasService.mostrarPorTipo(tipo));
    }

    @DeleteMapping(path = "/contas/{id}")
    public ResponseEntity<List<ContaResponse>> apagarConta(@PathVariable Long id){
        return ResponseEntity.ok(contasService.deletarConta(id));
    }

   }

