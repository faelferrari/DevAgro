package com.senai.devAgro.controler;

import com.senai.devAgro.controler.dto.EstoqueDTO;
import com.senai.devAgro.controler.dto.GraoDTO;
import com.senai.devAgro.model.EmpresaModel;
import com.senai.devAgro.model.GraoModel;
import com.senai.devAgro.service.GraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grao")
public class GraoControler {

    @Autowired
    GraoService graoService;


    @GetMapping
    public List<GraoDTO> graofindAll() {
        return graoService.findAll();
    }

    @PostMapping
    public GraoModel addGrao(@RequestBody GraoModel graoModel) {
        return graoService.addGrao(graoModel);
    }

    @PutMapping("/{id}")
    public GraoModel attGrao(@PathVariable Long id, @RequestBody GraoModel graoModel) {
        return graoService.attGrao(id, graoModel);
    }

    @DeleteMapping("/{id}")
    public void delGrao(@PathVariable Long id) {
        graoService.delGrao(id);
    }

    @GetMapping("/{id}")
    public Optional<GraoModel> graoFindID(@PathVariable Long id){

        return graoService.graoFindID(id);
    }

    @GetMapping("/empresa/{id}")
    public List<GraoDTO> graoFindEmpresa(@PathVariable Long id){
        return  graoService.graoFindEmpresa(id);
    }

    @GetMapping("/count/{id}")
    public Long countGrao(@PathVariable Long id){
        return graoService.countGrao(id);
    }

    @GetMapping("/estoque/empresa/{id}")
    public  List<EstoqueDTO> estoque(@PathVariable Long id){
        return graoService.estoqueGrao(id);
    }
}
