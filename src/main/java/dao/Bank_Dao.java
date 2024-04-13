package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Bank_Account;

public class Bank_Dao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void save_account(Bank_Account bank_Account) {
		entityTransaction.begin();
		entityManager.persist(bank_Account);
		entityTransaction.commit();
	}
	public List<Bank_Account> fetchAll(){
		List<Bank_Account> list=(List<Bank_Account>) entityManager.createQuery("select x from Bank_Account x").getResultList();
		return list;
	}
	public Bank_Account fetch_account_details(long acc_no) {
		Bank_Account bank_Account=entityManager.find(Bank_Account.class, acc_no);
		return bank_Account;
	}
	public void update_the_detail(Bank_Account bank_Account) {
		entityTransaction.begin();
		entityManager.merge(bank_Account);
		entityTransaction.commit();
		
	}
	public Bank_Account find(long ac_number) {
		Bank_Account bank_Account=entityManager.find(Bank_Account.class, ac_number);
		return bank_Account;
		
	}
}
