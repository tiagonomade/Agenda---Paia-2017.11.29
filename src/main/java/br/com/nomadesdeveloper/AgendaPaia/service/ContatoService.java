package br.com.nomadesdeveloper.AgendaPaia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nomadesdeveloper.AgendaPaia.model.Contato;
import br.com.nomadesdeveloper.AgendaPaia.model.Grupo;
import br.com.nomadesdeveloper.AgendaPaia.repository.ContatoRepository;
import br.com.nomadesdeveloper.AgendaPaia.repository.GrupoRepository;

@Service
public class ContatoService {
	@Autowired
	private ContatoRepository contRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	public Contato salvar(Contato contato){
		if(contato.getGrupo() == null){
			Grupo grupoPadrao = grupoRepository.findOne(7);
			contato.setGrupo(grupoPadrao);
		}
		return contRepository.save(contato);
	}

	public void excluir(Integer id) {
		contRepository.delete(id);
		
	}

	public List<Contato> buscarPorNome(String nome) {
		return contRepository.findByNomeIgnoreCase(nome);
	}

	public List<Contato> buscarPorNomeETel(String nome, String tel) {
		return contRepository.findByNomeAndTelIgnoreCase(nome, tel);
	}

	public Contato buscarPorId(Integer id) {
		return contRepository.findOne(id);
	}

	public List<Contato> buscarTodos() {
		return contRepository.findAll();
	}

	public List<Contato> buscarPorGrupo(String descricao) {
		return contRepository.findByGrupoDescricao(descricao);
	}
}
