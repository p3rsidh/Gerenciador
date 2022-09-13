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
@Table(name = "estados")
public class EstadoModel implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long codigo;

    @Column
    private String nomeEstado;

    @Column
    private String uf;

    @JsonIgnore //2
    @OneToMany(mappedBy = "estado_id", cascade = CascadeType.ALL)
    private List<CidadeModel> cidade_id;




}