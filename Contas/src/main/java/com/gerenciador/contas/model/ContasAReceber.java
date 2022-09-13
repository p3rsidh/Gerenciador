package com.gerenciador.contas.model;


import com.gerenciador.contas.enumeration.TipoRecebimento;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "contasreceber")
public class ContasAReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column
    private String status;

    @Column
    private String recebimento;

    @Column
    private BigDecimal valorRecebido;

    @Column
    private TipoRecebimento tipoRecebimento;

    @Column
    private LocalDate dataDeVencimento;

    @Column
    private LocalDate dataDeRecebimento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuario_id;
}
