package com.senai.devAgro.service;

import com.senai.devAgro.controler.dto.EmpresaDTO;
import com.senai.devAgro.controler.dto.FazendaDTO;
import com.senai.devAgro.model.EmpresaModel;
import com.senai.devAgro.model.FazendaModel;
import com.senai.devAgro.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;


    public List <EmpresaDTO> findAllDTO(){
        List<EmpresaDTO> dtos = new ArrayList<>();
        List<EmpresaModel> models = this.empresaRepository.findAll();
        for (EmpresaModel model :models) {
            dtos.add(new EmpresaDTO(model));
        }
        return dtos;
    }


    public EmpresaModel addEmpresa(EmpresaModel empresaModel){
        return this.empresaRepository.save(empresaModel);
    }


    public void delEmpresa(Long id){
        empresaRepository.deleteById(id);
    }

    public  EmpresaModel attEmpresa(Long id,EmpresaModel empresaModel){
       EmpresaModel empresaModelAtt = empresaRepository.findById(id).get();
       empresaModelAtt.setId(id);
       empresaModelAtt.setCnpj(empresaModel.getCnpj());
       empresaModelAtt.setNome(empresaModel.getNome());
       empresaModelAtt.setBairro(empresaModel.getBairro());
       empresaModelAtt.setNumero(empresaModel.getNumero());
       empresaModelAtt.setRua(empresaModel.getRua());
       empresaModelAtt.setEstado(empresaModel.getEstado());
       return empresaRepository.save(empresaModelAtt);
    }

    public EmpresaDTO empresaFindID(Long id) throws Exception {
        Optional<EmpresaModel> models = this.empresaRepository.findById(id);

        if (!models.isPresent()) {
            throw new Exception("Empresa não encontrada: " + id);
        }

        EmpresaDTO dto = new EmpresaDTO(models.get());
        return dto;
    }
}
