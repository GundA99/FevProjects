package customerpack;
import java.time.LocalDate;

public class customer implements Comparable<customer>{

	private int customerid = id;
	private String fname,lname,email,password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	public static int id;
	
	static {
		id = 1;
	}
	
	public customer(String email) {
		super();
		this.email = email;
	}


	public customer(String fname, String lname, String email, String password, double regAmount, LocalDate dob,
			String plan) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
//		this.plan = plan;
		this.plan = ServicePlan.valueOf(plan);
		this.customerid = id++;
	}


	@Override
	public String toString()
	{
		return "customerId = "+customerid+ "\n name=" + fname + " " + lname + ",\n email=" + email+ ",\n regAmount=" + regAmount + ", \n dob=" + dob + ",\n plan=" + plan+"\nPass= "+password ;
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof customer)
		{
		return this.email.equals(((customer)o).email);
		}
		return false;
	}
	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}
	


	public LocalDate getDob() {
		return dob;
	}


	@Override
	public int compareTo(customer o) {
		return  this.email.compareTo(o.getEmail());
		
	}
	
	
	
	
}
