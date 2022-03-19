package com.senai.devAgro.controler.dto;


import com.senai.devAgro.model.FazendaModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class FazendaDTO implements Serializable {


    private Long id;

    private GraoDTO grao;

    private EmpresaDTO empresa;

    private Long quantidade_estoque;

    private LocalDate ultima_colheita;

    private  String nome ;

    private  String rua;

    private  String bairro;

    private  String estado;

    private  String numero ;

    public  FazendaDTO(FazendaModel model) {
        this.id = model.getId();
        this.nome = model.getNome();
        this.bairro = model.getBairro();
        this.empresa= new EmpresaDTO(model.getFazendaEmpresa());
        this.grao=new GraoDTO(model.getFazendaGrao());
        this.estado=model.getEstado();
        this.rua=model.getRua();
        this.ultima_colheita=model.getUltimaColheita();
        this.quantidade_estoque=model.getQuantidadeEstoque();
    }


}
