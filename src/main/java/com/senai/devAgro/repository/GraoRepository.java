package com.senai.devAgro.repository;

import com.senai.devAgro.model.GraoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraoRepository extends JpaRepository<GraoModel,Long> {

    @Query(value = "select * from grao g where id_empresa = :id",nativeQuery = true)
    List<GraoModel> findByEmpresa(@Param("id")Long id);

    @Query(value = "select count(*) from funcionario f where id_empresa = :id",nativeQuery = true)
    Long countGrao(@Param("id")Long id);

    @Query(value = "select  g.id,g.nome ,g.tempo_colheita ,g.id_fazenda, g.id_empresa  from empresa e  inner  join  grao g on  g.id_empresa = :id inner join fazenda f  on  f.id_grao = g.id order by f.quantidade_estoque desc",nativeQuery = true)
    List<GraoModel> Estoque(@Param("id") Long id);
}
