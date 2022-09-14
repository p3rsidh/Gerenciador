package com.gerenciador.contas.controller;

import com.gerenciador.contas.execption.ExceptionHandlerContas;
import com.gerenciador.contas.model.ContasAReceberModel;
import com.gerenciador.contas.service.ContasAReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContasAReceberController extends ExceptionHandlerContas {

    @Autowired
    private ContasAReceberService contasAReceberService;


    @PostMapping(path = "/contasReceber")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContasAReceberModel> cadastrarConta(@RequestBody ContasAReceberModel contasAReceberModel){
        return ResponseEntity.ok(contasAReceberService.adicionarConta(contasAReceberModel));
    }

    @GetMapping(path = "/contasReceber")
    public ResponseEntity<List<ContasAReceberModel>> mostrarContas() {
        return ResponseEntity.ok(contasAReceberService.listarContas());
    }

    @GetMapping(path = "/contasReceber/{id}")
    public ResponseEntity<Optional<ContasAReceberModel>> mostrarContaEspecifica(@PathVariable Long id){
        return ResponseEntity.ok(contasAReceberService.buscarUmaContaPorId(id));
    }

    @PostMapping(path = "/contasReceber/{id}")
    public ResponseEntity< ContasAReceberModel> alterarConta(@PathVariable Long id, @RequestBody ContasAReceberModel contasAReceberModel){
        return ResponseEntity.ok(contasAReceberService.alterarConta(contasAReceberModel, id));
    }

    @GetMapping(path = "/contasReceber/buscar/{busca}")
    public ResponseEntity<List<ContasAReceberModel>> filtrarPorStatus(@PathVariable String busca){
        return ResponseEntity.ok(contasAReceberService.mostrarPorBusca(busca));
    }


    @GetMapping(path = "/contasReceber/buscarData/{data}")
    public ResponseEntity<List<ContasAReceberModel>> filtrarPorDataDeVencimento(@PathVariable String data) {
        return ResponseEntity.ok(contasAReceberService.mostrarPorDataDeVencimento(data));
    }

    @DeleteMapping(path = "/contasReceber/{id}")

    public ResponseEntity<ContasAReceberModel> deletarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(contasAReceberService.deletarConta(id), HttpStatus.NO_CONTENT);
    }


}
