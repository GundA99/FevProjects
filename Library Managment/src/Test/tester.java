package Test;

import Library.*;
import static utils.Populatedlist.PopulatedList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
				System.out.println("1: Sign up\n2: Sign in\n3: Change Password\n4: Un-Subscribe Reader\n5: Display all Readers\n6: Store Data in txt\n7: Read data from txt\n8: Serialization\n9: De-Serialization\n0: Exit");
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
				case 6 :
					System.out.println("Enter the file name");
					try(PrintWriter pw = new PrintWriter(new FileWriter(sc.next())))
					{
						pw.println(rlist);
						System.out.println("Date is stored !");
					}
					break;
				case 7:
					System.out.println("Enter the file name");
					try(BufferedReader br = new BufferedReader(new FileReader(sc.next())))
					{
						br.lines().forEach(System.out::println);
					}
					break;
					
				case 8:
					System.out.println("Enter the file name");
					try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(sc.next())))
					{
						out.writeObject(rlist);
						System.out.println("Data is Stored !");
					}
					break;
				case 9:
					System.out.println("Enter the file name");
					try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(sc.next())))
					{
						List<Reader> list =  (List<Reader>) in.readObject();
						list.forEach(p->System.out.println(p));
					}
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