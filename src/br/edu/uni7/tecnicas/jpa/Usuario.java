package br.edu.uni7.tecnicas.jpa;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String login;
    
    @Column(name = "password")
    private String senha;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAdmissao; 
    
    public static enum StatusType {
    	BLOQUEADO, ATIVO, DESATIVADO, REMOVIDO
    }
    
    @Enumerated(EnumType.STRING)
    private StatusType status;
    
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Veiculo> veiculos = new ArrayList<Veiculo>();
    
    @ManyToMany
    @JoinTable(name = "USUARIO_PROJETO",
    		joinColumns = @JoinColumn(name="usuario_id"),
    		inverseJoinColumns = @JoinColumn(name="projeto_id"))
    private List<Projeto> projetos = new ArrayList<Projeto>();

    public Usuario() {
    	this(null, null, null);
    }

    public Usuario(Integer id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.dataAdmissao = new GregorianCalendar();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Calendar getDataAdmissao() {
		return dataAdmissao;
	}
    
    public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
    
    public StatusType getStatus() {
		return status;
	}
    
    public void setStatus(StatusType status) {
		this.status = status;
	}
    
    public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
    
    public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
    
}