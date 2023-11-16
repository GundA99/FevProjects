package Test;

import Library.*;
import utils.Populatedlist;
import static utils.Populatedlist.PopulatedList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import CustException.CustomException;

import static Rules.validationRules.validation;

public class tester {

	public static void main(String[] args) throws CustomException {

		List<Reader> rlist = PopulatedList();
		Scanner sc = new Scanner(System.in);
		boolean Exit = false;

		try {
			while (!Exit) {
				System.out.println("1: Sign up\n2: Sign in\n3: Change Password\n4: Un-Subscribe Reader\n5: Display all Readers\n0: Exit");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("fname,lname, email, password, registrationAmount, dob, plan	");
					Reader r = validation(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(),
							sc.next().toUpperCase(),rlist);
					rlist.add(r);
					System.out.println("New Reader added !");
					break;
				case 2:
					System.out.println("Enter the email id");
					String s = sc.next();
					for (Reader R : rlist) {
						if (R.getEmail().equals(s)) {
							System.out.println("Enter the password");
							if (R.getPassword().equals(sc.next())) {
								System.out.println(R);
							} else
								System.out.println("Wrong password");
						}
					}
					break;
				case 3:
					boolean flag = false;
					System.out.println("Enter the email id");
					String s1 = sc.next();
					for (Reader R : rlist) {
						if (R.getEmail().equals(s1)) {
							System.out.println("Enter the password");
							if (R.getPassword().equals(sc.next())) {
								flag =true;
								System.out.println("Enter new password !");
								R.setPassword(sc.next());
								System.out.println("Password change successfully !");
							} else
								System.out.println("Wrong password");
						}
					}
					if(flag==false)
					{
						System.out.println("Invalid email id");
					}
					break;
					
				case 4: 
					System.out.println("Enter the email id");
					s = sc.next();
					Iterator<Reader> i = rlist.iterator();
					while(i.hasNext())
					{
						if(i.next().getEmail().equals(s))
						{
							i.remove();
							System.out.println("Reader is un subscribe");
						}
					}
					break;
				case 5:
					rlist.forEach(p -> System.out.println(p));
					break;
				case 0:
					Exit = true;
					System.out.println("------Thnak you------");
					break;
				default:
					break;
				}
			}

		} catch (Exception e) {
			sc.nextLine();
			System.out.println("Error : "+e.getMessage());
		}
	}
}