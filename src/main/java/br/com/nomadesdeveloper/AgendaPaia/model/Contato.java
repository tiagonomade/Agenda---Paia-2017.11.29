package br.com.nomadesdeveloper.AgendaPaia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
@NamedQueries(
		{
			@NamedQuery(name = "Contato.buscarPorGrupo", query = "select new Contato(cont.nome, cont.tel) from Contato cont where cont.grupo.descricao = ?1"),
			@NamedQuery(name = "buscarPorNome", query = "select cont from Contato cont where cont.nome = ?1")
		}
		
		)
public class Contato{
	@Id
	@GeneratedValue(generator = "seq_contato")
	@SequenceGenerator(name = "seq_contato", sequenceName = "seq_contato")
	private Integer id;
	private String nome;
	private String tel;
	
	@JoinColumn
	@ManyToOne
	private Grupo grupo;
	
	public Contato(){
		
	}
	
	public Contato(String nome, String tel){
		this.nome = nome;
		this.tel = tel;
	}
}
