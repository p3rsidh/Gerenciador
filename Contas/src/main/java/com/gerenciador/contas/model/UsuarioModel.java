package com.gerenciador.contas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

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

    @JsonIgnore //1
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL)
    private List<EnderecoModel> endereco_id;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL)
    private List<ContasAReceberModel> contas_id;

}
