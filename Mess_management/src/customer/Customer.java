package customer;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Comparable<Customer>,Serializable{
	
	private int customerId;
	private String fname,lname,email,password,PhoneNO,Address;
	private LocalDate registerdDate, PlanEndDate;
	private Plan plan;
	private double Amount;
	
	public Customer(String email)
	{
		this.email = email;
	}
	public Customer(int customerId, String fname, String lname, String email, String password, String phoneNO,
			String address, LocalDate registerdDate, Plan plan) {
		super();
		this.customerId = customerId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		PhoneNO = phoneNO;
		Address = address;
		this.registerdDate = registerdDate;
		
		if(plan.name()=="MONTHLY")
		{	
			PlanEndDate = registerdDate.plusMonths(1);
		}
		
		if(plan.name()=="YEARLY")
		{
			PlanEndDate = registerdDate.plusYears(1);
		}
		if(plan.name()=="HALFYEAR")
		{
			PlanEndDate = registerdDate.plusMonths(6);
		}
		if(plan.name()=="QUATERLY")
		{
			PlanEndDate = registerdDate.plusMonths(3);
		}
		this.plan = plan;
		Amount = plan.getCost();
	}

	@Override
	public String toString() {
		return "customerId = " + customerId + "\n name = " + fname+" " + lname + "\n email = " + email
				+ "\n password = " + password + "\n PhoneNO = " + PhoneNO + "\n Address =" + Address + "\n registerdDate = "
				+ registerdDate + " PlanEndDate = " + PlanEndDate + "\n plan = " + plan + ", Amount = " + Amount+"\n----------------------------";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return Address;
	}

	public LocalDate getRegisterdDate() {
		return registerdDate;
	}

	public LocalDate getPlanEndDate() {
		return PlanEndDate;
	}

	public Plan getPlan() {
		return plan;
	}
	
	

	public void setFname(String fname) {
		this.fname = fname;
	}
	public boolean equals(Object o)
	{
		if(o instanceof Customer)
		{
		return this.email.equals(((Customer)o).email);
		}
		return false;
	}
	@Override
	public int compareTo(Customer o) {
		this.getEmail().compareTo(o.getAddress());
		return 0;
	}
	
	
	
	
	
}
