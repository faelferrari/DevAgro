package com.senai.devAgro.service;

import com.senai.devAgro.controler.dto.FazendaDTO;
import com.senai.devAgro.controler.dto.ProximaColheitaDTO;
import com.senai.devAgro.model.EmpresaModel;
import com.senai.devAgro.model.FazendaModel;
import com.senai.devAgro.model.GraoModel;
import com.senai.devAgro.repository.FazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FazendaService {

    @Autowired
    FazendaRepository fazendaRepository;


    public FazendaModel addFazenda(FazendaModel fazendaModel) {
        return fazendaRepository.save(fazendaModel);
    }


    public FazendaModel attFazenda(Long id, FazendaModel fazendaModel) {
        FazendaModel fazendaAtt = fazendaRepository.findById(id).get();
        fazendaAtt.setId(id);
        fazendaAtt.setQuantidadeEstoque(fazendaModel.getQuantidadeEstoque());
        fazendaAtt.setUltimaColheita(fazendaModel.getUltimaColheita());
        fazendaAtt.setBairro(fazendaModel.getBairro());
        fazendaAtt.setEstado(fazendaModel.getEstado());
        fazendaAtt.setNome(fazendaModel.getNome());
        fazendaAtt.setRua(fazendaModel.getRua());
        fazendaAtt.setNumero(fazendaModel.getNumero());
        fazendaAtt.setFazendaEmpresa(fazendaModel.getFazendaEmpresa());
        fazendaAtt.setFazendaEmpresa(fazendaModel.getFazendaEmpresa());
        return fazendaRepository.save(fazendaAtt);
    }

    public void delFazenda(Long id) {
        fazendaRepository.deleteById(id);
    }


    public FazendaDTO fazendaFindID(Long id) throws Exception {
        Optional<FazendaModel> models = this.fazendaRepository.findById(id);

        if (!models.isPresent()) {
            throw new Exception("Fazenda não encontrada: " + id);
        }

        FazendaDTO dto = new FazendaDTO(models.get());
        return dto;
    }

    public List<FazendaDTO> findAlldto() {
        List<FazendaDTO> dtos = new ArrayList<>();
        List<FazendaModel> models = this.fazendaRepository.findAll();
        for (FazendaModel model : models) {
            dtos.add(new FazendaDTO(model));
        }
        return dtos;
    }

    public List<FazendaDTO> fazendafindEmpresa(Long id) {
        List<FazendaModel> models = this.fazendaRepository.findFazendabyEmpresa(id);
        List<FazendaDTO> dtos = new ArrayList<>();
        for (FazendaModel model : models) {
            dtos.add(new FazendaDTO(model));
        }
        return dtos;
    }

    public Long countFazenda(Long id) {
        return fazendaRepository.countFazenda(id);
    }

    public FazendaDTO colheita(Long id) {
        FazendaModel fazenda = fazendaRepository.findById(id).get();
        Long estoque = fazenda.getQuantidadeEstoque();
        estoque += 100;
        fazenda.setQuantidadeEstoque(estoque);
        fazendaRepository.save(fazenda);
        FazendaDTO fazendaDTO = new FazendaDTO(fazenda);
        return  fazendaDTO;
    }

    public FazendaDTO retirada(Long id) {
        FazendaModel fazenda = fazendaRepository.findById(id).get();
        Long estoque = fazenda.getQuantidadeEstoque();
        FazendaDTO fazendaDTO = null;
        if (estoque < 100) {
            System.out.printf("Estoque insuficiente!!");
        } else {
            estoque -= 100;
            fazenda.setQuantidadeEstoque(estoque);
            fazendaRepository.save(fazenda);
            fazendaDTO = new FazendaDTO(fazenda);
        }
        return fazendaDTO;
    }

    public ProximaColheitaDTO proxColheita(Long id) {
        FazendaModel fazendaModel = fazendaRepository.getById(id);
        GraoModel graoModel = fazendaModel.getFazendaGrao();
        ProximaColheitaDTO proximaColheitaDTO = new ProximaColheitaDTO(fazendaModel, graoModel);
        return proximaColheitaDTO;
    }
}
