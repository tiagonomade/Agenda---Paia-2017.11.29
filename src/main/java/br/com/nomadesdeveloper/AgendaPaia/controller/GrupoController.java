package br.com.nomadesdeveloper.AgendaPaia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nomadesdeveloper.AgendaPaia.model.Grupo;
import br.com.nomadesdeveloper.AgendaPaia.repository.GrupoRepository;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/grupocontroller")
public class GrupoController {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@PostMapping
	public Grupo inserir(@RequestBody Grupo grupo){
		return grupoRepository.save(grupo);
	}
	
	@GetMapping
	public List<Grupo> buscarTodos(){
		return grupoRepository.findAll();
	}
}
