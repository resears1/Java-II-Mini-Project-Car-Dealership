package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Dealer;

public class DealerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebCarDealership");
	
	public void insertDealer(Dealer d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Dealer> showAllDealers(){
		EntityManager em = emfactory.createEntityManager();
		List<Dealer> allDealers = em.createQuery("SELECT d FROM Dealer d").getResultList();
		return allDealers;
	}
}
