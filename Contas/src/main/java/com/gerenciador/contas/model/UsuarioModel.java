package com.gerenciador.contas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    @Size(min = 11, max = 11)
    private String CPF;

    @Column(nullable = false)
    @Email(regexp=".+@.+\\..+")
    private String email;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String nomeUsuario;

    @JsonIgnore //1
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL)
    private List<EnderecoModel> endereco_id;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL)
    private List<ContasAReceberModel> contas_id;

}
