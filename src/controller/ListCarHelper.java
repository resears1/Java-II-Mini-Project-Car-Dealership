package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListCar;

public class ListCarHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebCarDealership");
	
	public void insertCar(ListCar lc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lc);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListCar> showAllCars() {
		EntityManager em = emfactory.createEntityManager();
		List<ListCar> allCars = em.createQuery("SELECT c from ListCar c").getResultList();
		return allCars;
	}
	
	public void deleteCar(ListCar toDelete) {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListCar> typedQuery = em.createQuery("select lc from ListCar lc where lc.make = :selectedMake and lc.model = :selectedModel and lc.year = :selectedYear", ListCar.class);
		
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		
		typedQuery.setMaxResults(1);
		
		ListCar result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	// Use this as a template for the other three search functions!!
	// Make sure the name matches (ex: searchForCarByModel(String model))
	
	public List<ListCar> searchForCarByMake(String make){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCar> typedQuery = em.createQuery("select lc from ListCar lc where lc.make = :selectedMake", ListCar.class);
		typedQuery.setParameter("selectedMake", make);
		
		List<ListCar> foundCars = typedQuery.getResultList();
		em.close();
		return foundCars;
	}
	
	// We are still missing updateCar function
	
	public void cleanUp() {
		emfactory.close();
	}
}
