package com.catnap;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
			
	public static void main(String[] args) throws InterruptedException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world-pu");
		EntityManager em = emf.createEntityManager();
		try {
			populateDb(em);
			while (true) {
				Query q2 = em.createQuery("SELECT hw FROM HelloWorld hw");
				List result = q2.getResultList();
				logger.info(result.toString());
				Thread.sleep(500);
			}
		} finally {
			em.close();
		}
	}
	
	public static void populateDb(EntityManager em) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			HelloWorld hw1 = new HelloWorld(1, "Hello");
			HelloWorld hw2 = new HelloWorld(2, "Bonjour");
			em.persist(hw1);
			em.persist(hw2);
			tx.commit();
		} finally {
			if(tx.isActive()) {
				tx.rollback();
			}
		}
	}
}
