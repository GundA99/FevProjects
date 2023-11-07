package populatedlist;
import static com.tester.validationrules.checkvalidity;
import java.util.ArrayList;
import java.util.List;

import com.code.patient;
import com.tester.invalidexception;

public class populated {
	 public static List<patient> populatedlist() throws invalidexception
	 {
		 List<patient> list = new ArrayList<patient>();
		 list.add(checkvalidity(101, 25, "Akash", "Male", "Solapur", "9876543210", "cold", 2000, 155000, "GENERAL") );
		 list.add(checkvalidity(105, 27, "JAYESH", "Male", "PUNE", "9876543210", "FEVER", 3000, 154000, "SEMISPECIAL") );
		 list.add(checkvalidity(105, 27, "AVI", "Male", "PUNE", "9876543210", "Diabetese", 3000, 154000, "SEMISPECIAL") );
		 list.add(checkvalidity(109, 84, "SACHIN", "Male", "JALGAON", "9876543210", "DENGU", 7000, 35000, "ICU") );
		 list.add(checkvalidity(109, 84, "SAKSHI", "female", "JALGAON", "9876543210", "DENGU", 7000, 35000, "ICU") );
		 list.add(checkvalidity(111, 41, "PRANAY", "Male", "MUMBAI", "9876543210", "MALERIA", 2000, 15000, "GENERAL") );
		 list.add(checkvalidity(111, 41, "PRIYANKA", "female", "MUMBAI", "9876543210", "MALERIA", 2000, 15000, "GENERAL") );
		 list.add(checkvalidity(121, 14, "RAJU", "Male", "NAGPUR", "9876543210", "TIFIDE", 5000, 15000, "SPECIAL") );
		return list;

	 }
}
