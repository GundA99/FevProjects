package Rules;

import java.time.LocalDate;
import Exeption.CustExeption;
import java.util.List;

import customer.Customer;
import customer.Plan;

public class validation {

	
	private static LocalDate checkdater(String rdate)
	{
		LocalDate d = LocalDate.parse(rdate);
		return d;
	}
	private static Plan checkplan(String plan)
	{
		Plan p = Plan.valueOf(plan.toUpperCase());
		return p;
	}
	
	private static void checkDuplicate(String email, List<Customer>list) throws CustExeption
	{
		String pattern = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
		if(!email.matches(pattern))
		{
			throw new CustExeption("Email contain not valid");
		}

		Customer c = new Customer(email);
		for(Customer c1 : list)
		{
			if(c1.equals(c))
			{
				throw new CustExeption("Email Id is Already used !!!");
			}
		}
	}
	
	private static void checkphoneNo(String phone) throws CustExeption
	{
		String patter = "^[0-9]${10}";
		if(phone.matches(patter))
		{
			throw new CustExeption("Phone Number not valid !");
		}
	}
	
	
	public static Customer checkValidation(int id,String fname,String lname,String email,String pass,String phoneno,String address,String rdate,String plan,List<Customer> cust) throws CustExeption 
	{
		
		LocalDate r = checkdater(rdate);
		Plan pl = checkplan(plan);
		checkDuplicate(email,cust);
		checkphoneNo(phoneno);
	

		return new Customer(id, fname, lname, email, pass, phoneno, address, r,pl );
		
	}
}
