package customerpack;

import java.time.LocalDate;
import java.util.List;

public class ValidationRules {

	public static void parseAndValidatePlan(String plan) throws InvalidCustomerException {
		ServicePlan.valueOf(plan.toUpperCase()); // ;
	}

	public static void validatePlanAmount(ServicePlan plan, double amount) throws InvalidCustomerException {
		if (plan.getcost() != amount) {
			throw new InvalidCustomerException("Reg amount doesn't match with the plan !!!");
		}
	}

	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}

	public static void checkDuplicate(String email, List<customer> list) throws InvalidCustomerException {

		String pattern = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";

		if (!email.matches(pattern)) {
			throw new InvalidCustomerException("Email invalid");
		}

		customer c = new customer(email);
		if (list.contains(c)) {
			throw new InvalidCustomerException("Email is already used ");

		}
	}

	public static customer validation(String fname, String lname, String email, String password, double regAmount,
			String dob, String plan, List<customer> List) throws InvalidCustomerException {
		LocalDate d = parseDate(dob);
		parseAndValidatePlan(plan);
		checkDuplicate(email, List);

		return new customer(fname, lname, email, password, regAmount, d, plan);
	}
}
