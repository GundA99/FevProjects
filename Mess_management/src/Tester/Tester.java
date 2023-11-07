package Tester;

import static utils.PopulatedList.PopulatedList1;
import static Rules.validation.checkValidation;
import static utils.Serialization_Des.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import Exeption.CustExeption;
import customer.Customer;
import customer.Plan;

public class Tester {

	public static void main(String[] args) throws CustExeption {

		Scanner sc = new Scanner(System.in);
		List<Customer> custlist = PopulatedList1();
		boolean EXIT = false;
		while (!EXIT) {
			try {
				System.out.println(
						"\n1: Sign up Customer\n2: Sign in \n3: Change Password \n4: Sorting \n5: Unsubscribe e customer according plan duration \n6: Display All Customer\n7: Modify all customers first name\n"
								+ "8: Display email addresses registration in month of January \n9: Display count of the Customers register for plan: Monthly\n10: Search the Customer who lived in Akurdi\n"
								+ "11: Give the 20% discount to the customers plan for 1 year\n12: Serialization\n13: deSerialization\n14: Store data in text format 15: read Data from text file");
				System.out.println("Enter the choise");
				switch (sc.nextInt()) {
				case 0:
					EXIT = true;
					break;

				case 1:// Sign up Customer
					System.out.println("Enter details :");
					System.out.println(
							" customerId ,fname , lname, email, password , PhoneNO, Address, registerdDate, plan   ");
					Customer c1 = checkValidation(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
							sc.next(), sc.next(), sc.next(), custlist);
					custlist.add(c1);
					System.out.println("Customer Added");
					break;
				case 2:// sign in
					System.out.println("Enter email ");
					Customer cust = new Customer(sc.next());
					boolean check = false;
					for (Customer s : custlist) {
						if (s.equals(cust)) {
							check = true;
							System.out.println("Enter the password : ");
							String pass = sc.next();
							if (s.getPassword().equals(pass)) {
								System.out.println("--------------------------");
								System.out.println(s);
								System.out.println("--------------------------");
								break;

							} else {
								System.out.println("Wrong Password !");
							}
						}
					}
					if (check == false) {
						System.out.println("Invalid Email Id !");
					}

					break;

				case 3:// Change Password
					System.out.println("Enter Email Id");
					Customer c2 = new Customer(sc.next());
					boolean Check2 = false;
					for (Customer e : custlist) {
						if (e.equals(c2)) {
							Check2 = true;
							System.out.println("Enter the password : ");
							if (e.getPassword().contains(sc.next())) {
								System.out.println("Enter New Password : ");
								e.setPassword(sc.next());
								System.out.println("Password Changed ! ");

							} else
								System.out.println("Wrong password !");
						}
					}
					if (Check2 == false) {
						System.out.println("Invalid Email Id !");
					}
					break;

				case 4: // Sort
					int ch;
					do {
						System.out.println(
								"1: Sorted by Fname\n2: Sorted According to plan \n3: Accourding to Date of Ragistration\n0: Exit");
						ch = sc.nextInt();
						switch (ch) {
						case 1:
							custlist.stream()
									.sorted((Customer p1, Customer p2) -> p1.getFname().compareTo(p2.getFname()))
									.forEach(System.out::println);
							break;
						case 2:

							custlist.stream()
									.sorted((Customer cp1, Customer cp2) -> cp1.getPlan().compareTo(cp2.getPlan()))
									.forEach(System.out::println);
							break;
						case 3:
							custlist.stream().sorted((Customer r1, Customer r2) -> r1.getRegisterdDate()
									.compareTo(r2.getRegisterdDate())).forEach(System.out::println);
							break;
						}
					} while (ch != 0);
					break;
				case 5:// Unsubscribe customer according plan duration (month wise (1, 3, 6, 12)
					System.out.println("Enter the duration");
					int duration = sc.nextInt();
					List<Customer> cust2list = new ArrayList<Customer>();
					if (duration == 1) {
						cust2list = custlist.stream().filter(p -> p.getPlan() == Plan.MONTHLY)
								.collect(Collectors.toList());
						custlist.removeAll(cust2list);
					} else if (duration == 3) {
						cust2list = custlist.stream().filter(p -> p.getPlan() == Plan.QUATERLY)
								.collect(Collectors.toList());
						custlist.removeAll(cust2list);
					} else if (duration == 6) {
						cust2list = custlist.stream().filter(p -> p.getPlan() == Plan.HALFYEAR)
								.collect(Collectors.toList());
						custlist.removeAll(cust2list);
					} else if (duration == 12) {
						cust2list = custlist.stream().filter(p -> p.getPlan() == Plan.YEARLY)
								.collect(Collectors.toList());
						custlist.removeAll(cust2list);
					}

					custlist.forEach(p -> System.out.println(p));
					break;
				case 6:// Display all Customers

					System.out.println("--------------------------------");
					for (Customer c : custlist) {
						System.out.println(c);
						System.out.println("---------------------------");
					}
					break;
				case 7: // Modify all customers first name (make first Letter capital of customers first
						// name)
					Iterator<Customer> custitr = custlist.iterator();
					while (custitr.hasNext()) {
						Customer c4 = custitr.next();
						c4.setFname(c4.getFname().substring(0, 1).toUpperCase()
								.concat(c4.getFname().substring(1, c4.getFname().length())));

					}
					custlist.forEach(System.out::println);

				case 8:// Display email addresses of the customers who did registration in month of
						// January
					custlist.stream().filter(p -> p.getRegisterdDate().getMonthValue() == 1).forEach(p -> p.getEmail());
					break;
				case 9: // Display count of the Customers who have register for plan: Monthl
					long count = custlist.stream().filter(p -> p.getPlan() == Plan.MONTHLY).count();
					System.out.println("Total Customer of monthly plans : " + count);
					break;
				case 10: // Search the Customer who lived in Akurdi
					custlist.stream().filter(p -> p.getAddress().equals("Akurdi")).forEach(System.out::println);
					break;
				case 11: // Give the 20% discount to the customers who have selected plan for 1 year
					Iterator<Customer> custit = custlist.iterator();
					while (custit.hasNext()) {
						Customer c5 = custit.next();
						if (c5.getPlan().equals(Plan.YEARLY)) {
							c5.setAmount(c5.getAmount() * 0.80);
							System.out.println("Get 20% Discount...");
							System.out.println(c5);
						}
					}
					break;
				case 12: // serialization
					System.out.println("Enter the file name for Store data !");
					encodebinary(custlist, sc.next());
					break;
				case 13:// de-serialization
					System.out.println("Enter the File name for read Data");
					List<Customer> custlist1 = decodebinary(sc.next());
					custlist1.forEach(p -> System.out.println(p));
				case 14:
					System.out.println("Enter the file name to Store");
					StoreData(custlist, sc.next());
					System.out.println("Data is Stored !");
					break;
				case 15: 
					System.out.println(retriveData(sc.next()));
				
					break;
				default:
					System.out.println("Enter valid choise !");
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
