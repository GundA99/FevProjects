package customerpack;
import static customerpack.ValidationRules.validation;
import java.util.ArrayList;
import java.util.List;

public  class populatedList {
	
	public static List<customer> populatedList1() throws InvalidCustomerException
	{
		List<customer> custList1 = new ArrayList<customer>();
		custList1.add(validation("PRANAY", "rahangdale", "pranay123@gmail.com", "passw1", 15000, "2022-05-12", "GOLD",custList1,"2023-05-21"));
		custList1.add(validation("akash", "gund", "akash1999@gamil.com", "passw", 5000, "2021-05-21", "GOLD",custList1,"2023-07-21"));
		custList1.add(validation("piyush", "kolhe", "piyush2199@gamil.com", "passw2", 25000, "2024-04-22", "GOLD",custList1,"2023-08-21"));
		custList1.add(validation("jayesh", "thombre", "jayesh2099@gamil.com", "passw2", 1900, "2023-05-12", "PLATINUM",custList1,"2023-09-21"));
		custList1.add(validation("sachin", "shinde", "sachin2099@gamil.com", "passw2", 20900, "2023-05-12", "PLATINUM",custList1,"2023-10-21"));
		custList1.add(validation("abhi", "sav", "abhi2099@gamil.com", "passw2", 1900, "2023-05-12", "PLATINUM",custList1,"2023-04-21"));
		custList1.add(validation("Ram", "lukhan", "abhi22099@gamil.com", "passw2", 20000, "2023-04-12", "PLATINUM",custList1,"2021-04-21"));

		
		return custList1;
	}
	
}
