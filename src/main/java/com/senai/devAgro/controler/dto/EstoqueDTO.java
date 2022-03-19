package com.senai.devAgro.controler.dto;


import com.senai.devAgro.model.FazendaModel;
import com.senai.devAgro.model.GraoModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstoqueDTO {

    private  String nome ;

    private  Long estoque;

    public EstoqueDTO(){
    }

    public EstoqueDTO(GraoModel graoModel, FazendaModel fazendaModel){
        this.nome=graoModel.getNome();
        this.estoque=fazendaModel.getQuantidadeEstoque();
    }


}
