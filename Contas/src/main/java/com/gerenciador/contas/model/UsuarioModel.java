package com.gerenciador.contas.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;

    @Column
    @Size(min = 11, max = 11)
    private String CPF;

    @Column
    @Email(message="Please provide a valid email address")
    private String email;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String nomeUsuario;
}
