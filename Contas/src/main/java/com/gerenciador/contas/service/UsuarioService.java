package com.gerenciador.contas.service;

import com.gerenciador.contas.model.UsuarioModel;
import com.gerenciador.contas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel adicionarUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }
}
