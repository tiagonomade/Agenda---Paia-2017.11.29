package br.com.nomadesdeveloper.AgendaPaia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Grupo {
	@Id
	@SequenceGenerator(name="seq_grupos", sequenceName="seq_grupos")
	@GeneratedValue(generator="seq_grupos")
	private Integer id;
	private String descricao;
}
