package com.gerenciador.contas.service;

import com.gerenciador.contas.model.UsuarioModel;
import com.gerenciador.contas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel adicionarUsuario(UsuarioModel usuarioModel){

        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> verUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> verUmUsuario(Long id){
        return usuarioRepository.findById(id);
    }

    public UsuarioModel editarUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> deletarPorId(Long id){
        usuarioRepository.deleteById(id);
        return verUsuarios();
    }
}
