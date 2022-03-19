package com.senai.devAgro.controler;

import com.senai.devAgro.controler.dto.EmpresaDTO;
import com.senai.devAgro.model.EmpresaModel;
import com.senai.devAgro.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/empresa")
public class EmpresaControler {
    @Autowired
    EmpresaService empresaService;

    @GetMapping
    public List<EmpresaDTO> empresaFindAlldto(){
        return empresaService.findAllDTO();
    }


    @PostMapping
    public EmpresaModel addEmpresa(@RequestBody() EmpresaModel empresaModel){
        return this.empresaService.addEmpresa(empresaModel);
    }

    @DeleteMapping("/{id}")
    public  void dellEmpresa(@PathVariable Long id){
        empresaService.delEmpresa(id);
    }

    @PutMapping("/{id}")
    public EmpresaModel atualizarEmpresa(@PathVariable Long id, @RequestBody EmpresaModel empresaModel){
        return empresaService.attEmpresa(id,empresaModel);
    }

    @GetMapping ("/{id}")
    public EmpresaDTO empresaFindID(@PathVariable Long id) throws Exception{
    return  empresaService.empresaFindID(id);
    }

}
