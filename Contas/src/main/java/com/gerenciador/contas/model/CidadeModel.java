package com.gerenciador.contas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cidades")
public class CidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column
    private String nomeCidade;

    @ManyToOne //2
    @JoinColumn(name = "estado_id", referencedColumnName = "codigo")
    private EstadoModel estado_id;

    @JsonIgnore //1
    @OneToMany(mappedBy = "cidade_id", cascade = CascadeType.ALL)
    private List<EnderecoModel> endereco_id;
}