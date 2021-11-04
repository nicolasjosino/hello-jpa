package br.edu.uni7.tecnicas.jpa;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.uni7.tecnicas.jpa.Projeto.ProjetoAreaType;

public class DatabaseGen {
	public static void main(String[] args) {
		Properties config = new Properties();
		config.put("hibernate.hbm2ddl.auto", "create");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni7-pu", config);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		
		Usuario u1 = new Usuario(null, "nicolasjosino", "1234");
		u1.setStatus(Usuario.StatusType.ATIVO);
		
		Projeto p1 = new Projeto(null, "INFRA-XPTO", ProjetoAreaType.INFRA);
		Projeto p2 = new Projeto(null, "DEV-XPTO", ProjetoAreaType.DEV);
		Projeto p3 = new Projeto(null, "PROD-XPTO", ProjetoAreaType.UX);
		
		
		u1.getProjetos().add(p1);
		u1.getProjetos().add(p2);
		u1.getProjetos().add(p3);
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		em.persist(u1);

		em.getTransaction().commit();

		em.close();
		factory.close();
		
		/*
		Veiculo v1 = new Veiculo(null, "Camaro", "GM", 400.0, "POC-7291");
		em.persist(v1);
		
		Veiculo v2 = new Veiculo(null, "Corsa", "GM", 80.0, "XYZ-1999");
		em.persist(v2);
		
		Vaga vaga1 = new Vaga(null, "B-301");
		em.persist(vaga1);

		Vaga vaga2 = new Vaga(null, "B-302");
		em.persist(vaga2);
		
		v1.setVaga(vaga1);
		v2.setVaga(vaga2);
		
		Usuario u1 = new Usuario(null, "nicolasjosino", "1234");
		u1.setStatus(Usuario.StatusType.ATIVO);
		
		u1.getVeiculos().add(v1);
		v1.setUsuario(u1);
		
		u1.getVeiculos().add(v2);
		v2.setUsuario(u1);
		
		em.persist(u1);
		*/
		
//		Usuario usuario = em.find(Usuario.class, 5);
//		
//		if (usuario != null) {
//			
//			System.out.println("Usuário: " + usuario.getLogin());
//			System.out.println("Número de Veículos: " + usuario.getVeiculos().size());
//		}
	}
}
