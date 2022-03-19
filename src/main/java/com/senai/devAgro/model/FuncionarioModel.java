package com.senai.devAgro.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table( name="Funcionario")
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private  EmpresaModel funcionarioEmpresa;

    @NotNull(message="O campo nao pode ser Vazio")
    @Column
    private String nome;

    @NotNull(message="O campo nao pode ser Vazio")
    @Column
    private String sobrenome;

    @Column
    private String telefone;

    @NotNull(message="O campo nao pode ser Vazio")
    @Column
    private LocalDate dataNascimento;

    @NotNull(message="O campo nao pode ser Vazio")
    @Column
    private LocalDate dataContratacao;

    @Column
    private String rua;

    @Column
    private String bairro;

    @Column
    private  String numero;

    @Column
    private String cidade;

    @Column
    private  String estado;

    @Column
    private  String sexo;

    @NotNull(message="O campo nao pode ser Vazio")
    @Column
    @CPF
    private  String cpf;

}
