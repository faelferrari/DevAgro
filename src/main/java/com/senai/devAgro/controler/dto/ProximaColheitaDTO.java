package com.senai.devAgro.controler.dto;


import com.senai.devAgro.model.FazendaModel;

import com.senai.devAgro.model.GraoModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Getter
@Setter
public class ProximaColheitaDTO {

    private Long id;

    private  String nome ;

    private LocalDate proximaColheita;

    public LocalDate calculaData(LocalDate ultimaColheita,  Long tempoColheita){
        LocalDate dataAtual = LocalDate.now();
        Long dias = ChronoUnit.DAYS.between(ultimaColheita,dataAtual);
        tempoColheita =  tempoColheita - dias;
        LocalDate proximaColheita = dataAtual.plusDays(tempoColheita);
        return  proximaColheita;
    }

    public ProximaColheitaDTO(FazendaModel fazendaModel, GraoModel graoModel){
        this.id= fazendaModel.getId();
        this.nome=fazendaModel.getNome();
        this.proximaColheita= calculaData(fazendaModel.getUltimaColheita(), graoModel.getTempoColheita());
    }
}
