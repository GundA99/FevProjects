package Lab3_1;

public class bankApplication {
		
		private int AccountNo;
		private String name;
		private double balance;
		
		public bankApplication(int accountNo, String name, double balance) {
			super();
			AccountNo = accountNo;
			this.name = name;
			this.balance = balance;
		}
		
		public void withdraw(double amt) 
		{
			balance=balance-amt;
			System.out.println(amt+" Withdraw...");
			System.out.println("Current balance : "+balance);
		}
		
		public void deposit(double amt)
		{
			balance=balance+amt;
			System.out.println(amt+" Deposited...");
			System.out.println("Current balance : "+balance);
		}
		
		public void monyTransfer(bankApplication obj, double amt)
		{
			this.balance-=amt;
			obj.balance+=amt;
			System.out.println("cur balance = "+this.balance);
		}
		
		
		public int getAccountNo() {
			return AccountNo;
		}

		public void setAccountNo(int accountNo) {
			AccountNo = accountNo;
		}

		public String getName() {
			return name;
		}

		public double getBalance() {
			return balance;
		}

		public String toString()
		{
			return " Name : "+name+"\n Account no : "+AccountNo+"\n Balance : "+balance;
		}
}
