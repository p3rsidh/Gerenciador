package com.gerenciador.contas.controller;

import com.gerenciador.contas.model.UsuarioModel;
import com.gerenciador.contas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel cadastrarUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioService.adicionarUsuario(usuarioModel);
    }
}
