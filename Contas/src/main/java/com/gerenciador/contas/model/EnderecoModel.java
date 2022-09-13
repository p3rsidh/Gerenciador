package com.gerenciador.contas.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enderecos")
public class EnderecoModel implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long codigo;

    @Column
    private String lagadouro;

    @Column
    private String bairro;

    @Column
    private String cep;

    @Column
    private String pontoDeReferencia;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuario_id;

    @ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "codigo")
    private CidadeModel cidade_id;

}