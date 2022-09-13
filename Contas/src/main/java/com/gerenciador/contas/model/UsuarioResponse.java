package com.gerenciador.contas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class UsuarioResponse {


    private Long codigo;
    private String email;
    private LocalDate dataNascimento;
    private String nomeUsuario;


}
