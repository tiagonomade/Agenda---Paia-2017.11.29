package br.com.nomadesdeveloper.AgendaPaia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.nomadesdeveloper.AgendaPaia.model.Contato;
import br.com.nomadesdeveloper.AgendaPaia.service.ContatoService;

@RestController
@RequestMapping("/contcontroller")
@CrossOrigin(origins = {"*"})
public class ContatoController {
	@Autowired
	private ContatoService contatoService;
		
	@PostMapping()
	public Contato inserir(@RequestBody Contato contato){
		
		return contatoService.salvar(contato);
	}
	
	@PutMapping()
	public Contato alterar(@RequestBody Contato contato){
		
		return contatoService.salvar(contato);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Integer id){
		contatoService.excluir(id);
	}
	
	@GetMapping("/{id}")
	public Contato buscarPorId(@PathVariable("id") Integer id){
		return contatoService.buscarPorId(id);
	}	

	@GetMapping("/q/{nome}")
	public List<Contato> buscarPorNome(@PathVariable("nome") String nome){
		return contatoService.buscarPorNome(nome);
	}
	
	@GetMapping("/q2")
	public List<Contato> buscarPorNomeETel(@RequestParam("nome") String nome, @RequestParam("tel") String tel){
		return contatoService.buscarPorNomeETel(nome, tel);
	}
	
	@PostMapping("/autenticar")
	public List<Contato> autenticar(@RequestBody Contato contato) throws ContatoNaoEncontradoException{
		List<Contato> listCont =  contatoService.buscarPorNomeETel(contato.getNome(), contato.getTel());
		if(listCont == null || listCont.size() == 0){
			throw new ContatoNaoEncontradoException();
		}else{
			return listCont;
		}
	}
	
	@GetMapping()
	public List<Contato> buscarTodos(){
		return contatoService.buscarTodos();
	}
	
	@GetMapping("/q/grupo")
	List<Contato> buscarPorGrupo(@RequestParam("descricao") String descricao){
		return contatoService.buscarPorGrupo(descricao);
	}
	
}
