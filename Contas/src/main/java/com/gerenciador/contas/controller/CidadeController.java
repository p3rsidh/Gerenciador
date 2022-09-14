package com.gerenciador.contas.controller;

import com.gerenciador.contas.model.CidadeModel;
import com.gerenciador.contas.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping(path = "/cidades")
    public ResponseEntity<List<CidadeModel>> buscarTodos(){
        return ResponseEntity.ok(cidadeService.buscarTodas());
    }

    @GetMapping(path = "/cidades/{codigo}")
    public ResponseEntity<Optional<CidadeModel>> buscarPorId(@PathVariable Long codigo){
        return ResponseEntity.ok(cidadeService.buscarPorId(codigo));
    }

    @PostMapping(path = "/cidades")
    public ResponseEntity<CidadeModel> cadastrarCidade(@RequestBody CidadeModel cidade){
        return ResponseEntity.ok(cidadeService.cadastrar(cidade));
    }

    @PutMapping(path = "/cidade/{codigo}")
    public ResponseEntity<CidadeModel> alterarCidade(@RequestBody CidadeModel cidade){
        return ResponseEntity.ok(cidadeService.alterar(cidade));
    }

    @DeleteMapping(path = "/cidade/{codigo}")
    public List<CidadeModel> deletarCidade(@PathVariable Long codigo){
        return cidadeService.deletar(codigo);
    }
}