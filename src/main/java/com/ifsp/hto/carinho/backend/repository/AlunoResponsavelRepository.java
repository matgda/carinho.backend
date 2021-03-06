package com.ifsp.hto.carinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.model.AlunoResponsavel;

public interface AlunoResponsavelRepository extends JpaRepository<AlunoResponsavel, Long>  {
	
	

	@Query(value ="SELECT * FROM `aluno_responsavel` WHERE `nome_resp`=:id && `nome`=:id2",nativeQuery = true)
	AlunoResponsavel  selecionarResponsavel(@Param("id") long id,@Param("id2") long id2);
	
	

}
