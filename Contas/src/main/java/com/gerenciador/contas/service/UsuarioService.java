package com.gerenciador.contas.service;

import com.gerenciador.contas.model.ContaResponse;
import com.gerenciador.contas.model.ContasModel;
import com.gerenciador.contas.model.UsuarioModel;
import com.gerenciador.contas.model.UsuarioResponse;
import com.gerenciador.contas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel adicionarUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioResponse> verUsuarios(){
        List<UsuarioResponse> novaListaContas = new ArrayList<>();
        List<UsuarioModel> contasModelList = usuarioRepository.findAll();

        if (usuarioRepository.findAll().isEmpty()){
           throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }else {
            for (UsuarioModel usuarioModel : contasModelList) {
                UsuarioResponse usuarioResponse = new UsuarioResponse();

                usuarioResponse.setCodigo(usuarioModel.getCodigo());
                usuarioResponse.setNomeUsuario(usuarioModel.getNomeUsuario());
                usuarioResponse.setEmail(usuarioModel.getEmail());
                usuarioResponse.setDataNascimento(usuarioModel.getDataNascimento());

                novaListaContas.add(usuarioResponse);

        }return novaListaContas;
    }}

    public Optional<UsuarioModel> verUmUsuario(Long id){
        return usuarioRepository.findById(id);
    }

    public UsuarioModel editarUsuario(Long id, UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioResponse> deletarPorId(Long id){
        if (usuarioRepository.findById(id).isPresent()) {
            usuarioRepository.deleteById(id);
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }else if (usuarioRepository.findAll().isEmpty()){
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }else
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
    }

}
