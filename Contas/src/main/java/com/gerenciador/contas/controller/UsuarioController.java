package com.gerenciador.contas.controller;

import com.gerenciador.contas.model.UsuarioModel;
import com.gerenciador.contas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
}
