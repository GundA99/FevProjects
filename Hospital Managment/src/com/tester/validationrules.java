package com.tester;

import java.time.LocalDate;

import com.code.patient;
import com.code.roomtype;

public class validationrules {

	
	// enum validation 
	
	public static roomtype parseroom (String rooms,double price)throws invalidexception{
		
		return roomtype.valueOf(rooms.toUpperCase());
	}
	
	
	public static void checkprice(String e, Double price) throws invalidexception
	{
		if(!(roomtype.valueOf(e).getCost()==price))
		{
			throw new invalidexception("Room price not ok");
		}
	}
	
	public static patient checkvalidity(int serialno, int age,String pname,String gender,String address,String phoneno,String disease,
			double bill,double annual_incomem,String  rooms) throws invalidexception 
	{
		LocalDate date = LocalDate.now();
		roomtype rt = parseroom(rooms,bill);
		checkprice(rooms,bill);
		return new patient(serialno, age, pname, gender, address, phoneno, disease, date, bill, annual_incomem, rt);
	}
	

	
	
	
	
	
	
	
	
	
	
}
