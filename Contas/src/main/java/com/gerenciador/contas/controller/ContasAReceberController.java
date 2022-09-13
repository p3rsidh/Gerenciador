package com.gerenciador.contas.controller;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.TipoRecebimento;
import com.gerenciador.contas.execption.ExceptionHandlerContas;
import com.gerenciador.contas.model.ContasAReceberModel;
import com.gerenciador.contas.service.ContasAReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<ContasAReceberModel> mostrarContas(){
        return contasAReceberService.listarContas();
    }

    @GetMapping(path = "/contasReceber/{id}")
    public Optional<ContasAReceberModel> mostrarContaEspecifica(@PathVariable Long id){
        return contasAReceberService.buscarUmaContaPorId(id);
    }

    @PostMapping(path = "/contasReceber/{id}")
    public ContasAReceberModel alterarConta(@PathVariable Long id, @RequestBody ContasAReceberModel contasAReceberModel){
        return contasAReceberService.alterarConta(contasAReceberModel, id);
    }

    @GetMapping(path = "/contasReceber/{status}")
    public List<ContasAReceberModel> filtrarPorStatus(@PathVariable String status){
        return contasAReceberService.mostrarPorStatus(status);
    }

    @GetMapping(path = "/contasReceber/{tipo}")
    public List<ContasAReceberModel> filtrarPorTipoDeRecebimento(@PathVariable TipoRecebimento tipo){
        return contasAReceberService.mostrarPorTipoDeRebecimento(tipo);
    }

    @GetMapping(path = "/contasReceber/{data}")
    public List<ContasAReceberModel> filtrarPorDataDeVencimento(@PathVariable LocalDate localDate) {
        return contasAReceberService.mostrarPorDataDeVencimento(localDate);

    }

    @DeleteMapping(path = "/contasReceber/{id}")
    public HttpStatus deletarPorId(@PathVariable Long id){
        return contasAReceberService.deletarConta(id);
    }


}
