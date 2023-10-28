package ShowroomManagment;

import ShowroomManagment.InvalidInputException;
import java.time.LocalDate;
import java.util.List;

import ShowroomManagment.Vehicle;

public class ShowroomValidations {

	public static Color parseAndValidateColor(String str) throws IllegalArgumentException

	{
//		   Color c=null;
//		if(c.name().equalsIgnoreCase(str))
//		{ Color c1=c;
//			return c1;
//		}
//	return  c;
		Color c = Color.valueOf(str.toUpperCase());
//		System.out.println(c);
		return c;

	}

	public static LocalDate parseAndValidateDate(String str) throws InvalidInputException {
		LocalDate menudate = LocalDate.parse(str);
		LocalDate checkDate = LocalDate.of(2022, 1, 1);
		if (menudate.isBefore(checkDate)) {
			throw new InvalidInputException("Manu date must be after 1st Jan 2022");
		}
		return menudate;
	}

	public static Vehicle findByChasisNo(String str, List<Vehicle> list) throws InvalidInputException {
		Vehicle v = new Vehicle(str);
		int index = list.indexOf(v);
		System.out.println("index= " + index);
		if (index == -1) {
			throw new InvalidInputException("Invalid ch no , Vehicle not found !!!!");
		} else
			return list.get(index);
	}

	public static void checkdup(String chno, List<Vehicle> vehicle) throws InvalidInputException {
		Vehicle newvehicle = new Vehicle(chno);
		if (vehicle.contains(newvehicle))
			throw new InvalidInputException("Duplicate ch.no");
	}
	

	public static Vehicle validateAllInputs(String chasisNo, String vehicleColor, double price, String manufactureDate,
			String company,List<Vehicle> vehicle) throws InvalidInputException {
		checkdup(chasisNo,vehicle);
		Color c = parseAndValidateColor(vehicleColor);
		LocalDate d = parseAndValidateDate(manufactureDate);
		return new Vehicle(chasisNo, c, price, d, company);

	}

}