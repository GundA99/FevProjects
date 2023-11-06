package utils;

import java.util.ArrayList;
import java.util.List;

import Exeption.CustExeption;
import Rules.validation;

import static Rules.validation.checkValidation;

import customer.Customer;

public class PopulatedList {

	public static ArrayList<Customer> PopulatedList1() throws CustExeption {

		
		List<Customer> custlist = new ArrayList<Customer>();
	
		custlist.add(checkValidation(101, "akash", "gund", "akash123@gmail.com", "passw", "9156917179", "Solapur", "2021-05-05",  "QUATERLY",custlist));
		custlist.add(checkValidation(102, "jayesh", "thombre", "jt123@gmail.com", "pass", "8789987809", "Jalgaon", "2023-01-08", "Monthly",custlist));
		custlist.add(checkValidation(104, "pranay", "Rahandale", "pr125@gmail.com", "pass", "9178998789", "gondia", "2022-07-18",  "YEARLY",custlist));
		custlist.add(checkValidation(103, "kalpesh", "patil", "kp125@gmail.com", "pass", "9178998789", "Akurdi", "2022-07-18",  "YEARLY",custlist));
		custlist.add(checkValidation(109, "piyush", "kolhe", "pk143@gmail.com", "pass", "8017658789", "Jalgaon", "2021-01-18",  "HALFYEAR",custlist));
		
			return (ArrayList<Customer>) custlist;
	}
}
