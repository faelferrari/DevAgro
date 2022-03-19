package com.senai.devAgro.controler.dto;

import com.senai.devAgro.model.EmpresaModel;
import com.senai.devAgro.repository.EmpresaRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class EmpresaDTO implements Serializable {

    private  Long id;
    private  String cnpj;
    private  String nome ;

    public EmpresaDTO(EmpresaModel model) {
        this.cnpj = model.getCnpj();
        this.nome = model.getNome();
        this.id=model.getId();

    }

}
