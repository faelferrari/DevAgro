package com.senai.devAgro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table( name="Grao")
public class GraoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  String nome ;

    @Column
    private  Long tempoColheita;

    @NotNull(message="O campo nao pode ser Vazio")
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaModel graoEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_fazenda")
    private FazendaModel graoFazenda;
}
