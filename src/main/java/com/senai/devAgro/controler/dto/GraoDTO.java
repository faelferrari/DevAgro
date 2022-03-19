package com.senai.devAgro.controler.dto;


import com.senai.devAgro.model.GraoModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class GraoDTO {
    private Long id;

    private  String nome ;

    private  Long tempo_colheita;

    public GraoDTO(){
    }
    public GraoDTO(GraoModel graoModel){
        this.id= graoModel.getId();
        this.nome=graoModel.getNome();
        this.tempo_colheita=graoModel.getTempoColheita();
    }
}
