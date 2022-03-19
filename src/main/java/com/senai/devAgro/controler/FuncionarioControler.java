package com.senai.devAgro.controler;

import com.senai.devAgro.controler.dto.FuncionarioDTO;
import com.senai.devAgro.model.FuncionarioModel;
import com.senai.devAgro.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioControler {
    @Autowired
    FuncionarioService funcionarioService;


    @GetMapping()
    public List<FuncionarioDTO> funcionariofindAll() {
        return funcionarioService.findAll();
    }

    @PostMapping
    public FuncionarioModel addFuncionario(@RequestBody FuncionarioModel funcionarioModel) {
        return funcionarioService.addFuncionario(funcionarioModel);
    }

    @PutMapping("/{id}")
    public FuncionarioModel attFuncionario(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioModel) {
        return funcionarioService.attFuncionario(id, funcionarioModel);
    }

    @DeleteMapping("/{id}")
    public void delFuncionario(@PathVariable Long id) {
        funcionarioService.delFuncionario(id);
    }

    @GetMapping("/{id}")
    public FuncionarioDTO funcionarioFindID(@PathVariable Long id) throws Exception {
        return funcionarioService.funcionarioFindID(id);
    }

    @GetMapping("/empresa/{id}")
    public List<FuncionarioDTO> funcionarioFindEmpresa(@PathVariable Long id){
        return funcionarioService.funcionarioFindEmpresa(id);
    }
}
