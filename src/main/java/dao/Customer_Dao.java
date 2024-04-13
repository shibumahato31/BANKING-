package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Customer;

public class Customer_Dao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public void save(Customer customer) 
	{
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
	}
	public List<Customer> check1(String email)
	{
		List<Customer> list=entityManager.createQuery("select a from Customer a where c_email=?1").setParameter(1, email).getResultList();
		return list;
		//List<Customer> list=query.getResultList();
	}
	public List<Customer> check2(long mob)
	{
		List<Customer> list=entityManager.createQuery("select a from Customer a where cphone=?1").setParameter(1, mob).getResultList();
		return list;
	}
	
	public Customer login(int customerid) {
		Customer customer=entityManager.find(Customer.class, customerid);
		return  customer;
	}
	
	public void update(Customer customer) {
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
	}
}
