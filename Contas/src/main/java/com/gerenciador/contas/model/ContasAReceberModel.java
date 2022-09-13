package com.gerenciador.contas.model;


import com.gerenciador.contas.enumeration.Status;
import com.gerenciador.contas.enumeration.TipoRecebimento;
import org.springframework.data.jpa.repository.Query;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "contasreceber")
public class ContasAReceberModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column
    private Status status;

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
