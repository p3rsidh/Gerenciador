package com.gerenciador.contas.controller;

import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.TipoRecebimento;
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
public class ContasAReceberController {

    @Autowired
    private ContasAReceberService contasAReceberService;


    @PostMapping(path = "/contasReceber")
    @ResponseStatus(HttpStatus.CREATED)
    public ContasAReceberModel cadastrarConta(@RequestBody ContasAReceberModel contasAReceberModel){
        return contasAReceberService.adicionarConta(contasAReceberModel);
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

    @GetMapping(path = "/contasRecever/{status}")
    public List<ContasAReceberModel> filtrarPorStatus(@PathVariable Status status){
        return contasAReceberService.mostrarPorStatus(status);
    }

    @GetMapping(path = "/contasReceber/{tipo}")
    public List<ContasAReceberModel> filtrarPorTipoDeRecebimento(@PathVariable TipoRecebimento tipo){
        return contasAReceberService.mostrarPorTipoDeRebecimento(tipo);
    }

    @GetMapping(path = "/contasReceber/{data}")
    public List<ContasAReceberModel> filtrarPorDataDeVencimento(@PathVariable LocalDate localDate){
        return contasAReceberService.mostrarPorDataDeVencimento(localDate);
    }

    @GetMapping(path = "/contasReceber/{id}")
    public ResponseEntity deletarPorId(@PathVariable Long id){
        return deletarPorId(id);
    }


}
