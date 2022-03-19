package com.senai.devAgro.repository;

import com.senai.devAgro.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository <FuncionarioModel,Long> {
    @Query(value = "select * from funcionario f where id_empresa = :id",nativeQuery = true)
    List<FuncionarioModel> findByEmpresa(@Param("id")Long id);
}
