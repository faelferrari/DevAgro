package com.senai.devAgro.controler.dto;

import com.senai.devAgro.model.FuncionarioModel;
import lombok.Getter;
import lombok.Setter;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
public class FuncionarioDTO implements Serializable {

    private Long id;

    private String empresa;

    private String nome;

    private String sobrenome;

    private String telefone;

    private LocalDate dataNascimento;

    private LocalDate dataContratacao;

    private String rua;

    private String bairro;

    private  String numero;

    private String cidade;

    private  String estado;

    private  String sexo;

    private  String cpf;

    public FuncionarioDTO(FuncionarioModel funcionarioModel){
        this.id = funcionarioModel.getId();
        this.empresa =funcionarioModel.getFuncionarioEmpresa().getNome();
        this.nome=funcionarioModel.getNome();
        this.sobrenome=funcionarioModel.getSobrenome();
        this.telefone=funcionarioModel.getTelefone();
        this.dataNascimento=funcionarioModel.getDataNascimento();
        this.dataContratacao=funcionarioModel.getDataContratacao();
        this.rua=funcionarioModel.getRua();
        this.bairro=funcionarioModel.getBairro();
        this.numero=funcionarioModel.getNumero();
        this.cidade=funcionarioModel.getCidade();
        this.estado=funcionarioModel.getEstado();
        this.sexo=funcionarioModel.getSexo();
        this.cpf=funcionarioModel.getCpf();
    }

}
