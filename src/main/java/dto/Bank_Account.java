package dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Bank_Account {
	@Id
	@SequenceGenerator(initialValue = 4456321, allocationSize = 1,sequenceName = "account_no",name = "account_no")
	@GeneratedValue(generator = "account_no")
	long ac_no;
	@Column
	String acc_type;
	@Column
	double acc_limit;
	@Column
	boolean status;
	@Column
	double amount;
	
	@ManyToOne
	Customer customer;

	@OneToMany(cascade = CascadeType.ALL)//used to save the data inside the database without using being,persist,commit
	List<BankTransaction> list;

	public long getAc_no() {
		return ac_no;
	}

	public void setAc_no(long ac_no) {
		this.ac_no = ac_no;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public double getAcc_limit() {
		return acc_limit;
	}

	public void setAcc_limit(double acc_limit) {
		this.acc_limit = acc_limit;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<BankTransaction> getList() {
		return list;
	}

	public void setList(List<BankTransaction> list) {
		this.list = list;
	}
}
