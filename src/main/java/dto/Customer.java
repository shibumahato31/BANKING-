package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {

	@Id
	@SequenceGenerator(initialValue = 112233, allocationSize = 1, sequenceName = "custid", name = "custid")
	@GeneratedValue(generator = "custid")
	int cid;

	@Column(nullable = false, unique = false)
	String cname;

	@Column(unique = true, nullable = false)
	long cphone;

	@Column(unique = true, nullable = false)
	String c_email;

	@Column(nullable = false)
	String pwd;

	@Column(nullable = false)
	String gender;

	@Column(nullable = false)
	Date date;

	@OneToMany
	List<Bank_Account> bankaccounts;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public long getCphone() {
		return cphone;
	}

	public void setCphone(long cphone) {
		this.cphone = cphone;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Bank_Account> getBankaccounts() {
		return bankaccounts;
	}

	public void setBankaccounts(List<Bank_Account> bankaccounts) {
		this.bankaccounts = bankaccounts;
	}
	

}
