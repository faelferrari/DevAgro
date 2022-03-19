package com.senai.devAgro.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table( name="Fazenda")
public class FazendaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="O campo nao pode ser Vazio")
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaModel fazendaEmpresa;

    @ManyToOne()
    @JoinColumn(name = "id_grao")
    private GraoModel fazendaGrao;

    @Column
    private Long quantidadeEstoque;

    @Column
    private LocalDate ultimaColheita;

    @NotNull(message="O campo nao pode ser Vazio")
    @Column
    private  String nome ;

    @Column
    private  String rua;

    @Column
    private  String bairro;

    @Column
    private  String estado;

    @Column
    private  String numero ;

}
