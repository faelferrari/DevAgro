package com.senai.devAgro.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table( name="Empresa")
public class EmpresaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="O campo nao pode ser Vazio")
    @Column
    @CNPJ
    private  String cnpj;

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

    @OneToMany(mappedBy = "fazendaEmpresa",orphanRemoval = true)
    private List<FazendaModel> fazenda;

    @OneToMany(mappedBy = "funcionarioEmpresa",orphanRemoval = true)
    private  List<FuncionarioModel> funcionario;



//    @OneToMany(mappedBy = "grao_empresa",orphanRemoval = true)
//    private  List<GraoModel> grao;
}











