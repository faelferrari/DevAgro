package com.senai.devAgro.repository;

import com.senai.devAgro.model.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository  extends JpaRepository <EmpresaModel, Long>{

}
