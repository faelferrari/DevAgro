package com.senai.devAgro.service;


import com.senai.devAgro.controler.dto.EstoqueDTO;
import com.senai.devAgro.controler.dto.FuncionarioDTO;
import com.senai.devAgro.controler.dto.GraoDTO;
import com.senai.devAgro.model.EmpresaModel;
import com.senai.devAgro.model.FuncionarioModel;
import com.senai.devAgro.model.GraoModel;
import com.senai.devAgro.repository.GraoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GraoService {

    @Autowired
    GraoRepository graoRepository;

    public List<GraoModel> findAll() {
        return graoRepository.findAll();
    }

    public GraoModel addGrao(GraoModel graoModel) {
        return graoRepository.save(graoModel);

    }

    public GraoModel attGrao(Long id,GraoModel graoModel) {
        GraoModel graoAtt=graoRepository.findById(id).get();
        graoAtt.setId(id);
        graoAtt.setNome(graoModel.getNome());
        graoAtt.setTempoColheita(graoModel.getTempoColheita());
        return  graoRepository.save(graoAtt);
    }

    public void delGrao(Long id) {
        graoRepository.deleteById(id);
    }

    public Optional<GraoModel> graoFindID(Long id) {
        Optional<GraoModel> graoModel = graoRepository.findById(id);
        return  graoModel;
    }


    public List<GraoDTO> graoFindEmpresa(Long id) {
        List<GraoDTO> dtos = new ArrayList<>();
        List<GraoModel> models = this.graoRepository.findByEmpresa(id);
        for (GraoModel model :models) {
            dtos.add(new GraoDTO(model));
        }
        return dtos;
    }

    public Long countGrao(Long id) {
        return graoRepository.countGrao(id);
    }

//    public List<EstoqueDTO> estoqueGrao(Long id) {
//        List <EstoqueDTO> dtos = new ArrayList<>();
//        List <GraoModel> models = graoRepository.findByEmpresa(id);
//        for (GraoModel model :models) {
//            dtos.add(new EstoqueDTO(model ,model.getGrao_Fazenda()));
//        }
//        return dtos;
//    }

    public List<EstoqueDTO> estoqueGrao(Long id) {
        List <EstoqueDTO> dtos = new ArrayList<>();
        List <GraoModel> models = graoRepository.Estoque(id);
        for (GraoModel model :models) {
            dtos.add(new EstoqueDTO(model ,model.getGraoFazenda()));
        }
        return dtos;
    }
}
