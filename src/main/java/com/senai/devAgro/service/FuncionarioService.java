package com.senai.devAgro.service;

import com.senai.devAgro.controler.dto.FazendaDTO;
import com.senai.devAgro.controler.dto.FuncionarioDTO;
import com.senai.devAgro.model.FazendaModel;
import com.senai.devAgro.model.FuncionarioModel;
import com.senai.devAgro.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> findAll() {

        List<FuncionarioDTO> dtos = new ArrayList<>();
        List<FuncionarioModel> models = this.funcionarioRepository.findAll();
        for (FuncionarioModel model :models) {
            dtos.add(new FuncionarioDTO(model));
        }
        return dtos;
    }

    public FuncionarioModel addFuncionario(FuncionarioModel funcionarioModel) {
        return  funcionarioRepository.save(funcionarioModel);
    }

    public FuncionarioModel attFuncionario(Long id, FuncionarioModel funcionarioModel) {
        FuncionarioModel funcionarioAtt = funcionarioRepository.findById(id).get();
        funcionarioAtt.setId(id);
        funcionarioAtt.setBairro(funcionarioModel.getBairro());
        funcionarioAtt.setCidade(funcionarioModel.getCidade());
        funcionarioAtt.setEstado(funcionarioModel.getEstado());
        funcionarioAtt.setNome(funcionarioModel.getNome());
        funcionarioAtt.setNumero(funcionarioModel.getNumero());
        funcionarioAtt.setDataNascimento(funcionarioModel.getDataNascimento());
        funcionarioAtt.setCpf(funcionarioModel.getCpf());
        funcionarioAtt.setDataContratacao(funcionarioModel.getDataContratacao());
        funcionarioAtt.setSexo(funcionarioModel.getSexo());
        funcionarioAtt.setSobrenome(funcionarioModel.getSobrenome());
        funcionarioAtt.setTelefone(funcionarioModel.getTelefone());
        funcionarioAtt.setRua(funcionarioModel.getRua());
        funcionarioAtt.setFuncionarioEmpresa(funcionarioModel.getFuncionarioEmpresa());
        return  funcionarioRepository.save(funcionarioAtt);
    }

    public void delFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public FuncionarioDTO funcionarioFindID(Long id) throws Exception {
        Optional<FuncionarioModel> models = this.funcionarioRepository.findById(id);

        if (!models.isPresent()) {
            throw new Exception("Funcionario não encontrada: " + id);
        }
        FuncionarioDTO dto = new FuncionarioDTO(models.get());
        return dto;
    }


    public List<FuncionarioDTO> funcionarioFindEmpresa(Long id) {
        List<FuncionarioDTO> dtos = new ArrayList<>();
        List<FuncionarioModel> models = this.funcionarioRepository.findByEmpresa(id);
        for (FuncionarioModel model :models) {
            dtos.add(new FuncionarioDTO(model));
        }
        return dtos;
    }
}
