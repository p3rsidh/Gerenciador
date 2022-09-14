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
@Table(name = "contas_receber")
public class ContasAReceberModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column
    private Status status;

    @Column
    private String recebimento;

    @Column(nullable = false)
    private BigDecimal valorRecebimento;

    @Column(nullable = false)
    private TipoRecebimento tipoRecebimento;

    @Column(nullable = false)
    private LocalDate dataDeVencimento;

    @Column
    private LocalDate dataDeRecebimento;

    @Column
    private BigDecimal valorTotal;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuario_id;
}
