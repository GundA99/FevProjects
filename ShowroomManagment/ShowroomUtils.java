package ShowroomManagment;
import ShowroomManagment.Vehicle;
import java.util.List;
import java.util.ArrayList;
import static java.time.LocalDate.parse;


public class ShowroomUtils {

	public static List<Vehicle> populateShowroom()
	
	{		List<Vehicle> vehicles = new ArrayList<>();
	vehicles.add(new Vehicle("abc-1233", Color.RED, 556787, parse("2022-10-20"), "Maruti"));
		vehicles.add(new Vehicle("abc-1233", Color.WHITE, 456789, parse("2023-05-25"), "Honda"));
		vehicles.add(new Vehicle("abc-1238", Color.WHITE, 956789, parse("2023-05-25"), "Mahindra"));
		vehicles.add(new Vehicle("abc-1239", Color.BLACK, 576787, parse("2023-10-21"), "Honda"));
		vehicles.add(new Vehicle("abc-1231", Color.WHITE, 496789, parse("2022-08-20"), "Honda"));
		vehicles.add(new Vehicle("abc-1234", Color.BLUE, 706787, parse("2023-05-25"), "Tata"));
		vehicles.add(new Vehicle("abc-1230", Color.WHITE, 416789, parse("2022-08-20"), "Honda"));
		vehicles.add(new Vehicle("abc-1236", Color.BLUE, 356787, parse("2023-05-25"), "Tata"));
	
		return vehicles;
	}
}
