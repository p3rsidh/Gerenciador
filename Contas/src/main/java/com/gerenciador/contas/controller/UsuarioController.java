package com.gerenciador.contas.controller;

import com.gerenciador.contas.execption.ExceptionHandlerUsuario;
import com.gerenciador.contas.model.UsuarioModel;
import com.gerenciador.contas.model.UsuarioResponse;
import com.gerenciador.contas.service.UsuarioService;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController extends ExceptionHandlerUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/usuario")
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody @Valid UsuarioModel usuarioModel) throws HttpClientErrorException.UnprocessableEntity {
        return new ResponseEntity<>(usuarioService.adicionarUsuario(usuarioModel), HttpStatus.CREATED);
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
    public List<UsuarioResponse> deletarPorId(@PathVariable Long id){
        return usuarioService.deletarPorId(id);
    }

}
