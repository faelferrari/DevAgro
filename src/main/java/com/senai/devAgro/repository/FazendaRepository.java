package com.senai.devAgro.repository;

import com.senai.devAgro.controler.dto.FazendaDTO;
import com.senai.devAgro.model.FazendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FazendaRepository  extends JpaRepository<FazendaModel,Long> {

    @Query(value = "select * from fazenda Where id_empresa=:id",nativeQuery = true)
     List<FazendaModel> findFazendabyEmpresa(@Param("id")Long id);

    @Query(value = "select count(*) from fazenda f where id_empresa =:id",nativeQuery = true)
    Long countFazenda(@Param("id")Long id);
}
