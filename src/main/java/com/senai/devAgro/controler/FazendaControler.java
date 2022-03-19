package com.senai.devAgro.controler;

import com.senai.devAgro.controler.dto.EmpresaDTO;
import com.senai.devAgro.controler.dto.FazendaDTO;
import com.senai.devAgro.controler.dto.ProximaColheitaDTO;
import com.senai.devAgro.model.EmpresaModel;
import com.senai.devAgro.model.FazendaModel;
import com.senai.devAgro.service.FazendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fazenda")
public class FazendaControler {

    @Autowired
    FazendaService fazendaService;


//    @GetMapping
//    public List<FazendaModel> fazendaFindAllmodel(){
//        return fazendaService.findAllDTO();
//    }


    @GetMapping
    public List<FazendaDTO> empresaFindAlldto(){
        return fazendaService.findAlldto();
    }

    @PostMapping
    public FazendaModel addFazenda(@RequestBody() FazendaModel fazendaModel){
        return this.fazendaService.addFazenda(fazendaModel);
    }

    @DeleteMapping("/{id}")
    public  void dellFazenda(@PathVariable Long id){
        fazendaService.delFazenda(id);
    }

    @PutMapping("/{id}")
    public FazendaModel atualizarFazenda(@PathVariable Long id, @RequestBody FazendaModel fazendaModel){
        return fazendaService.attFazenda(id,fazendaModel);
    }

    @GetMapping ("/{id}")
    public FazendaDTO getId(@PathVariable Long id) throws Exception {
        return  fazendaService.fazendaFindID(id);
    }

    @GetMapping("/empresa/{id}")
    public List<FazendaDTO> getEmpresa(@PathVariable Long id){
        return fazendaService.fazendafindEmpresa(id);
    };

    @GetMapping("/count/{id}")
    public Long countFazenda(@PathVariable Long id){
        return fazendaService.countFazenda(id);
    }

    @PutMapping("/colheita/{id}")
    public FazendaDTO colheita(@PathVariable Long id){return  fazendaService.colheita(id);}

    @PutMapping("/retirada/{id}")
    public  FazendaDTO retirada(@PathVariable Long id){ return  fazendaService.retirada(id);};

    @GetMapping("/proximaColheita/{id}")
    public ProximaColheitaDTO proxColheita(@PathVariable Long id){ return  fazendaService.proxColheita(id);}
}
