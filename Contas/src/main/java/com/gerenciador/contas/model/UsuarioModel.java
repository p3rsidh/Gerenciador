package com.gerenciador.contas.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import java.util.Date;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;

    @Column(nullable = false, unique = true)
    @Size(min = 11, max = 11)
    private String CPF;

    @Column(nullable = false, precision = 11)
    @Email
    private String email;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = false)
    private String nomeUsuario;
}
