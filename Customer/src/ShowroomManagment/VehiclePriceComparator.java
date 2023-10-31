package ShowroomManagment;

import java.util.Comparator;

public class VehiclePriceComparator implements Comparator<Vehicle>{
	
	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		System.out.println("In Compare : Price");
		if (o1.getPrice() < o2.getPrice())
			return -1;
		if(o1.getPrice()>o2.getPrice())
			return 1;
		return 0;
	}
}
