package ShowroomManagment;

import static ShowroomManagment.ShowroomValidations.parseAndValidateColor;
import static ShowroomManagment.ShowroomValidations.findByChasisNo;
import static ShowroomManagment.ShowroomUtils.populateShowroom;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ShowroomManagement {

	public static void main(String[] args) throws InvalidInputException {

		try (Scanner sc = new Scanner(System.in)) {
			List<Vehicle> showroom = populateShowroom();
			boolean Exit = false;
			System.out.println("Options : 1 . Add a Vehicle\n" + "2. Display all \n" + "3. Get Vehicle Details\n "
					+ "4. Apply discount\n " + "5. Apply discount on old vehicles\n "
					+ "6. Remove specific vehicle \n 7. Remove vehicles by color \n "
					+ "8. Sort vehicles as per ch no \n 9. Sort vehicle details as per price\n"
					+ " 10. Sort vehicle details as per Date n price\n 0.Exit");

			while (!Exit) {
				try {
					int ch = sc.nextInt();
					switch (ch) {
					case 1:
						System.out.println(
								"Enter vehicle details : chasisNo,  vehicleColor,  price,  manufactureDate,	company");
						Vehicle v = ShowroomValidations.validateAllInputs(sc.next(), sc.next(), sc.nextDouble(),
								sc.next(), sc.next(),showroom);
						showroom.add(v);
						System.out.println("Vehicle is added...");
						break;
					case 2:
						for (Vehicle v1 : showroom) {
							System.out.println(v1);
						}
						break;

					case 3:
						System.out.println("Enter chasis no , to get vehicle details");
						System.out.println(findByChasisNo(sc.next(), showroom));
						break;

					case 4:
						System.out.println("Enter chasis no n discount");
						v = findByChasisNo(sc.next(), showroom);
						v.setPrice(v.getPrice() - sc.nextDouble());
						System.out.println("Applied discount !");
						break;
					case 5:
						System.out.println("Enter date and discount");
						LocalDate d = LocalDate.parse(sc.next());
						double dis = sc.nextDouble();
						for (Vehicle v2 : showroom) {
							if (v2.getManufactureDate().isBefore(d)) {
								v2.setPrice(v2.getPrice() - dis);
								System.out.println("Applied discount !");
							}
						}
						break;
					case 6:
						System.out.println("Enter the chasino");
						boolean remove = showroom.remove(new Vehicle(sc.next()));
						if (remove) {
							System.out.println("vehicle details removed");
						} else
							throw new InvalidInputException("Vehicle details can't be removed : invalid ch no!!!!");
						break;
					case 7:
						System.out.println("ENter color");
						Color c = parseAndValidateColor(sc.next().toUpperCase());
						System.out.println(c);

//						for(Vehicle v3: showroom)
//							if(v3.getVehicleColor()==c)
//								showroom.remove(v3);
//						System.out.println("deleted vehicle details");

						Iterator<Vehicle> vehiIterator = showroom.iterator();
						while (vehiIterator.hasNext()) {
							if (vehiIterator.next().getVehicleColor() == c) {
								vehiIterator.remove();
								System.out.println("deleted vehicle details");

							}
						}
						break;
					case 8:
						Collections.sort(showroom);
						break;

					case 9:

						Collections.sort(showroom, new VehiclePriceComparator());
						break;

					case 10:
						Collections.sort(showroom, new Comparator<Vehicle>() {

							@Override
							public int compare(Vehicle o1, Vehicle o2) {
								System.out.println("in compare : date n price");
								int ret = o1.getManufactureDate().compareTo(o2.getManufactureDate());
								if (ret == 0) {
									if (o1.getPrice() < o2.getPrice()) {
										return -1;
									}
									if (o1.getPrice() > o2.getPrice()) {
										return 1;
									}
									return 0;
								}
								return ret;
							}
						});

						break;

					case 0:
						System.out.println("----Thank You----");
						Exit = true;
						break;

					default:
						System.out.println("Enter Invalid value");
						break;
					}
				} catch (Exception e) {
					sc.nextLine();   //for overcome from Switch Buffer and Avoid infinite loop
					System.out.println("Exception...." + e.getMessage());

				}
			}

		}
	}
}
