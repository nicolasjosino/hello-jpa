package br.edu.uni7.tecnicas.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vaga {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	public String logradouro;
	
	@OneToOne(mappedBy = "vaga")
	private Veiculo veiculo;

	public Vaga() {
		
	}
	
	public Vaga(Integer id, String logradouro) {
		this.id = id;
		this.logradouro = logradouro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}	

}
