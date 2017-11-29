package br.com.nomadesdeveloper.AgendaPaia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.nomadesdeveloper.AgendaPaia.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
	
	List<Contato> findByNomeIgnoreCase(String nome);
	
	List<Contato> findByNomeAndTelIgnoreCase(String nome, String tel);
	
	List<Contato> findByGrupoDescricao(String descricao);
	
	List<Contato> buscarPorGrupo(String descricaoGrupo);
}