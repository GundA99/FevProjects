package utils;
import Library.Reader;
import static Rules.validationRules.validation;
import java.util.ArrayList;
import java.util.List;

import CustException.CustomException;

public class Populatedlist {
	
	public static List<Reader> PopulatedList() throws CustomException
	{
		List<Reader> rlist = new ArrayList<Reader>();
		rlist.add(validation("Akash", "Gund", "ag@gmail.com", "pass", 2000, "1999-05-21", "GOLD",rlist));
		rlist.add(validation("JAYESH", "THOMBRE", "jt@gmail.com", "pass", 1000, "2000-05-21", "SILVER",rlist));
		rlist.add(validation("PIYUSH", "KOLHE", "pk@gmail.com", "pass", 10000, "1999-05-21", "PLATINUM",rlist));
		rlist.add(validation("PRANAY", "RAHN", "pr@gmail.com", "pass", 5000, "1999-05-21", "DIAMOND",rlist));
		rlist.add(validation("Abhi", "Sevalkar", "as@gmail.com", "pass", 2000, "1999-05-21", "GOLD",rlist));
		return rlist;

	}
}
