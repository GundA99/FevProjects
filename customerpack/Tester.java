package customerpack;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static customerpack.populatedList.populatedList1;;

//import customerpack.*;

public class Tester {

	public static void main(String[] args) throws InvalidCustomerException {

		Scanner sc = new Scanner(System.in);
		List<customer> CustList = populatedList1();
		
		try {
			boolean Exit = false;
			while (!Exit) {
				System.out.println(
						"Enter choice \n1: Sign up\n2: Sign in (login)\n3:Change Password \n5: Display All \n6: sort by gmail\n7: Sort by DOB\n8: Sort by DOB and Lname\n9: chech Subcription not paid\n10: Remove customer Who not paid subcription \n0 : Exit");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter fname lname email password regAmount dob plan,SubcriptionDate");
					customer c = ValidationRules.validation(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),
							sc.next(), sc.next().toUpperCase(), CustList, sc.next());
					CustList.add(c);
					System.out.println("Customer Added..!");
					break;
				case 2:
					System.out.println("Enter Email id and password ");
					customer cust1 = new customer(sc.next());

					boolean check = false;
					for (customer I : CustList) {
						if (I.equals(cust1)) {
							check = true;
							System.out.println("Enter password");
							String s = sc.next();
							if (I.getPassword().contains(s)) {
								System.out.println("---Login SuccessFull----");
								System.out.println(I);
								System.out.println("---------------------------");

								break;
							}
							System.out.println("Wrong Password !");
						}
					}
					if (check == false) {
						System.out.println("Invalid Email id");
					}
					break;

				case 3:
					System.out.println("Enter the Email");
					boolean ch = false;
					cust1 = new customer(sc.next());
					for (customer c1 : CustList) {
						if (c1.equals(cust1)) {
							System.out.println("Enter password");
							if (c1.getPassword().contains(sc.next())) {
								ch = true;
								System.out.println("Enter new password");
								c1.setPassword(sc.next());
								System.out.println("Password change successfully");
							}

						}
					}
					if (ch == false) {
						System.out.println("Wrong password !");
					}

					break;
				case 5:
					for (customer c1 : CustList) {
						System.out.println("Name = " + c1.getFname() + " " + c1.getLname());
						System.out.println("Email = " + c1.getEmail());
						System.out.println("DOB = " + c1.getDob());
						System.out.println("Subscription Date = " + c1.getLastdateSubcription());
						System.out.println("-----------------------------------");
					}
					break;
				case 6:
					Collections.sort(CustList);
					break;
				case 7:
					Collections.sort(CustList, new Comparator<customer>() {
						public int compare(customer o1, customer o2) {
							System.out.println("in comparator");
							return o1.getDob().compareTo(o2.getDob());
						}
					});
					break;
				case 8:
					Collections.sort(CustList, new Comparator<customer>() {
						@Override
						public int compare(customer o1, customer o2) {
//							System.out.println("In comparator");
							int i = o1.getDob().compareTo(o1.getDob());
							if (i == 0) {
								return o1.getLname().compareTo(o2.getLname());
							}
							return i;
						}
					});

					for (customer c1 : CustList) {
						System.out.println("Name = " + c1.getFname() + " " + c1.getLname());
						System.out.println("Email = " + c1.getEmail());
						System.out.println("DOB = " + c1.getDob());
						System.out.println("Subscription Date" + c1.getLastdateSubcription());
						System.out.println("-----------------------------------");
					}
					break;

				case 9:
					System.out.println("Subcription not paid list...");
					for (customer c1 : CustList) {
						long months = Period.between(c1.getLastdateSubcription(), LocalDate.now()).toTotalMonths();
						if (months > 3) {
							System.out.println("Name = " + c1.getFname() + " " + c1.getLname());
							System.out.println("Last Subcription Date " + c1.getLastdateSubcription());
							System.out.println("-----------------------------------");
						}
					}
					break;
				case 10:
					System.out.println("---------------------------------------------");
					Iterator<customer> iterateCust = CustList.iterator();
					while (iterateCust.hasNext()) {
						long period = Period.between(iterateCust.next().getLastdateSubcription(), LocalDate.now())
								.toTotalMonths();
						if (period<6) {
							iterateCust.remove();
						}
					}
					System.out.println("Removed customers...");
					for(customer c1: CustList)
					{
						System.out.println(c1.getFname()+" "+c1.getLname());
						System.out.println("Subcription Date = "+c1.getLastdateSubcription());
					}
					System.out.println("---------------------------------------------");
					break;

				case 0:
					System.out.println("-----Thank you------");
					Exit = true;
				}
			}
		} catch (

		InvalidCustomerException e) {
			e.printStackTrace();
		}
	}

}
