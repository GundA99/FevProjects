package com.tester;

import static com.tester.validationrules.checkvalidity;
import static populatedlist.populated.populatedlist;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.code.patient;
import com.code.roomtype;

public class tester {

	public static void main(String[] args) throws invalidexception {

		List<patient> patientlist = populatedlist();

		try (Scanner sc = new Scanner(System.in)) {
			boolean Exit = false;

			while (!Exit) {
				try {
					System.out.println(
							"\n1: Add patient \n2: Display all patient \n3: patient applicable for ”Rajeev Gandhi Yojana \n"
									+ "4: patient details of room type chosen from the user.\n5: Remove Diabetese patients\n6: Change  patient from ICU to SPECIAL room.\n7 :display all the patients who’s age  >75.\n8: Sort the patients based on gender.\n9: Exit   ");
					switch (sc.nextInt()) {

					case 1: // add patient records.
						System.out.println(
								"serialno age pname gender address phoneno disease  admitdate, bill annual_income  rooms ");
						patient p = checkvalidity(sc.nextInt(), sc.nextInt(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble(), sc.next());
						patientlist.add(p);
						System.out.println("Patient Added !");
						break;

					case 2: // display all the patients.
						patientlist.forEach(System.out::println);
						break;

					case 3:// display all the patient who has annualIncome < 30000
						patientlist.stream().filter(p1 -> p1.getAnnual_income() < 30000).forEach(System.out::println);
						break;

					case 4: // display all the patient details of room type chosen from the user.
						System.out.println("Enter room type : ");
						roomtype s = roomtype.valueOf(sc.next().toUpperCase());
						patientlist.stream().filter(p3 -> p3.getRooms().equals(s)).forEach(System.out::println);
						break;
					case 5:// Remove all the patient who has disease “Diabetese”.
						Iterator<patient> piter = patientlist.iterator();
						while (piter.hasNext()) {
							if (piter.next().getDisease() == "Diabetese") {
								piter.remove();
							}
						}
						patientlist.forEach(System.out::println);
						break;

					case 6: // Change the roomType of a patient who is from “ICU” to SPECIAL room.

						for (patient a : patientlist) {
							if (a.getRooms().equals(roomtype.valueOf("ICU"))) {
								a.setRooms(roomtype.valueOf("SPECIAL"));
							}
						}
						System.out.println("Shifting patient ICU to Special room");
						break;

					case 7:// display all the patients who’s age >75.
						patientlist.stream().filter(d -> (d.getAge() > 75)).forEach(System.out::println);
						break;

					case 8: // Sort the patients based on gender.
						Collections.sort(patientlist, (p5, p6) -> p5.getGender().compareTo(p6.getGender()));
						patientlist.forEach(System.out::println);
						break;
					case 9:
						System.out.println("------Thank you-----");
						Exit = true;
						break;
					}

				} catch (Exception e) {
					sc.nextLine();
					System.out.println("Error " + e);
				}
			}

		}

	}
}
