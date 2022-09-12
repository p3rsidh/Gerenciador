package com.gerenciador.contas.controller;

import com.gerenciador.contas.model.UsuarioModel;
import com.gerenciador.contas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel cadastrarUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioService.adicionarUsuario(usuarioModel);
    }

    @GetMapping(path = "/usuario")
    public List<UsuarioModel> mostrarUsuarios(){
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
    public List<UsuarioModel> deletarPorId(@PathVariable Long id){
        return usuarioService.deletarPorId(id);
    }

}
