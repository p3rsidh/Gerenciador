package com.gerenciador.contas.controller;

import com.gerenciador.contas.execption.ExceptionHandlerUsuario;
import com.gerenciador.contas.model.UsuarioModel;
import com.gerenciador.contas.model.UsuarioResponse;
import com.gerenciador.contas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController extends ExceptionHandlerUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody @Valid UsuarioModel usuarioModel) {
        return ResponseEntity.ok(usuarioService.adicionarUsuario(usuarioModel));

    }

    @GetMapping(path = "/usuario")
    public List<UsuarioResponse> mostrarUsuarios(){
        return usuarioService.verUsuarios();
    }

    @GetMapping(path = "/usuario/{id}")
    public Optional<UsuarioModel> mostrarPorId(@PathVariable Long id){
        return usuarioService.verUmUsuario(id);
    }

    @PutMapping(path = "/usuario/{id}")
    public UsuarioModel alterarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel){
        return usuarioService.editarUsuario(id, usuarioModel);
    }

    @DeleteMapping(path = "/usuario/{id}")
    public ResponseEntity<List<UsuarioResponse>> deletarPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.deletarPorId(id));
    }

}
