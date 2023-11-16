package Library;

import java.time.LocalDate;

public class Reader {

	private  int readerid;
	private String fname,lname,email,password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int id;
	
	static {
	int id =1;
	}
	
	public Reader(String fname, String lname, String email, String password, double registrationAmount,
			LocalDate dob, ServicePlan plan) {
		super();
		this.readerid = id++;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
	}

	
	public Reader(String email) {
		super();
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getReaderid() {
		return readerid;
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

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public static int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\n-----------------------\nReaderid = " + readerid + ",\nfname = " + fname + " " + lname + ",\nemail = " + email
				+ ",\npassword = " + password + ", \nregistrationAmount = " + registrationAmount + ", \ndob = " + dob + ", plan = "
				+ plan +"\n";
	}

	
	

}
