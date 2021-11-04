package br.edu.uni7.tecnicas.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projeto {
	public static enum ProjetoAreaType {
		INFRA, DEV, UX;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private ProjetoAreaType area;
	
	@ManyToMany(mappedBy = "projetos")
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public Projeto(Integer id, String nome, ProjetoAreaType area) {
		this.id = id;
		this.nome = nome;
		this.area = area;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ProjetoAreaType getArea() {
		return area;
	}

	public void setArea(ProjetoAreaType area) {
		this.area = area;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}	
	
}
