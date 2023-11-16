package Rules;

import java.security.Provider.Service;
import java.time.LocalDate;
import java.util.List;

import CustException.CustomException;
import Library.*;

public class validationRules {

	private static LocalDate checkDate(String date) {
		return LocalDate.parse(date);
	}

	private static ServicePlan checkplan(String s) {
		return ServicePlan.valueOf(s);
	}

	private static void checkEmail(String s, List<Reader> rlist) throws CustomException {
		String pattern = "[a-z0-9]+@[a-z0-9]+\\.com";
		
		if (!s.matches(pattern)) {
			throw new CustomException("Email pattern not match");
		}
		Reader r = new Reader(s);

		for (Reader r1 : rlist) {
			if (r1.getEmail().equals(r.getEmail())) {
				throw new CustomException("Duplicate email id");
			}
		}

	}
	
	private static void checkPlanAmount(String plan, double amt) throws CustomException
	{
		ServicePlan s = ServicePlan.valueOf(plan);
		if(!(s.getCost()==amt))
		{
			throw new CustomException("Amount not match with plan");
		}
	}

	public static Reader validation(String fname, String lname, String email, String password,
			double registrationAmount, String dob, String plan, List<Reader>rlist) throws CustomException {
		ServicePlan p = checkplan(plan);
		LocalDate d = checkDate(dob);
		checkPlanAmount(plan, registrationAmount);
		checkEmail(email, rlist);

		return new Reader(fname, lname, email, password, registrationAmount, d, p);

	}
}
