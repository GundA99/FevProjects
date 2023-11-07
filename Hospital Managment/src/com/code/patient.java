package com.code;

import java.time.LocalDate;

public class patient {

	private int serialno,age;
	private String pname,gender,address,phoneno,disease;
	private LocalDate admitdate;
	private double bill,annual_income;
	private roomtype rooms;
	public patient(int serialno, int age, String pname, String gender, String address, String phoneno, String disease,
			LocalDate admitdate, double bill, double annual_income, roomtype rooms) {
		super();
		this.serialno = serialno;
		this.age = age;
		this.pname = pname;
		this.gender = gender;
		this.address = address;
		this.phoneno = phoneno;
		this.disease = disease;
		this.admitdate = admitdate;
		this.bill = bill;
		this.annual_income = annual_income;
		this.rooms = rooms;
	}
	public int getSerialno() {
		return serialno;
	}
	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public LocalDate getAdmitdate() {
		return admitdate;
	}
	public void setAdmitdate(LocalDate admitdate) {
		this.admitdate = admitdate;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	public double getAnnual_income() {
		return annual_income;
	}
	public void setAnnual_income(double annual_income) {
		this.annual_income = annual_income;
	}
	public roomtype getRooms() {
		return rooms;
	}
	public void setRooms(roomtype rooms) {
		this.rooms = rooms;
	}
	
	@Override
	public String toString() {
		return "patient [serialno=" + serialno + ", age=" + age + ", pname=" + pname + ", gender=" + gender
				+ ", address=" + address + ", phoneno=" + phoneno + ", disease=" + disease + ", admitdate=" + admitdate
				+ ", bill=" + bill + ", annual_income=" + annual_income + ", rooms=" + rooms + "]";
	}
	
	
	
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof patient) {
//			patient p1=(patient)obj;
//			return p1.age==this.age;
//		}
//		return super.equals(obj);
//	}
	
	
	
	
	
}
