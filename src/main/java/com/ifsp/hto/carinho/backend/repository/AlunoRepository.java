package com.ifsp.hto.carinho.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifsp.hto.carinho.backend.dto.AlunoDTO;
import com.ifsp.hto.carinho.backend.dto.ResponsavelDTO;
import com.ifsp.hto.carinho.backend.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	Aluno findById(long id);

	@Query(value = "SELECT COUNT(id) from aluno", nativeQuery = true)
	Integer teste();

	@Query(value = "SELECT * FROM `aluno` WHERE nome LIKE :nomeA%", nativeQuery = true)
	List<Aluno> findByNome(@Param("nomeA") String nome);

	@Query(value = "SELECT responsavel.id,responsavel.carteira_identidade,responsavel.nome_resp from aluno_responsavel inner join aluno on aluno.id = aluno_responsavel.nome inner join responsavel on responsavel.id = aluno_responsavel.nome_resp WHERE aluno_responsavel.nome=:id", nativeQuery = true)
	List<ResponsavelDTO> responsavel(@Param("id") int id);

	@Query(value = "SELECT * FROM aluno", nativeQuery = true)
	List<Aluno> fetchEmpDeptDataInnerJoin2();

	@Query(value = "select aluno.*, controle_aluno.tipo_horario,controle_aluno.horario from aluno inner join controle_aluno ON aluno.id "
			+ "= controle_aluno.fk_aluno WHERE controle_aluno.fk_aluno ORDER BY `controle_aluno`.`horario`"
			+ " DESC LIMIT ?1", countQuery = "SELECT COUNT(id) from aluno", nativeQuery = true)
	List<AlunoDTO> todosAlunos(Long var);

	// Aluno findByNumero(long id);

	// boolean existsByNumero(Long id);

}
