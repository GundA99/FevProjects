package Lab3_1;

import java.util.Scanner;

public class Test_bank {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choise, index = 0;
		int accountno;
		boolean check = false;

		bankApplication[] act = new bankApplication[10];
		System.out.println("1: create Account \n2: withdraw\n3: Deposite\n4: monyTransfer\n5: Display Details\n6:Exit");
		do {
			System.out.print("Enter choise : ");
			choise = sc.nextInt();
			switch (choise) {
			case 1:
				if (index < act.length) {
					System.out.println("Enter account id, name, balance");
					bankApplication ac2 = new bankApplication(sc.nextInt(), sc.next(), sc.nextDouble());
					System.out.println("Account is Created...");
					act[index] = ac2;
					index++;
				} else {
					System.out.println("bank account capacity is full...");
				}
				break;

			case 2:
				System.out.println("Enter Account no : ");
				accountno = sc.nextInt();
				check = false;
				double amt;
				for (bankApplication a : act) {
					if (a != null) {
						if (a.getAccountNo() == accountno) {
							System.out.print("Enter amount for withdraw :");
							amt = sc.nextDouble();
							if (amt < a.getBalance()) {
							
								a.withdraw(amt);
								check = true;
								break;
							} else {
								System.out.println("Insufficient Balance for withdraw...");
							}
						} else {
							check = false;
						}
					}
				}
				if (check == false) {
					System.out.println("Account no not match ");
				}

				break;

			case 3:
				System.out.println("Enter Account no : ");
				accountno = sc.nextInt();
				check = false;
				for (bankApplication a : act) {
					if (a != null) {
						if (a.getAccountNo() == accountno) {
							System.out.print("Enter amount for deposit :");
							a.deposit(sc.nextDouble());
							check = true;
							break;
						} else
							check = false;
					}
				}
				if (check == false) {
					System.out.println("Account no not match ");
				}
				break;

			case 4:
				System.out.println("Enter Account no : ");
				accountno = sc.nextInt();

				int acount;
				check = false;

				for (bankApplication a : act) {
					if (a != null) {
						if (a.getAccountNo() == accountno) {
							System.out.println("Enter Account no to transfer");
							acount = sc.nextInt();
							check = true;
							for (bankApplication b : act) {
								if (b != null) {
									if (b.getAccountNo() == acount) {
										check = true;
										System.out.println("Enter amount");
										a.monyTransfer(b, sc.nextDouble());
										System.out.println("Mony Tranfered from Account no " + a.getAccountNo() + " to "
												+ b.getAccountNo());
										break;
									}
								}
							}
						} 
					}
				}
				if (check == false) {
					System.out.println("Account no not match");
				}

				break;
			case 5:
				System.out.println("Enter Account no : ");
				accountno = sc.nextInt();
				check = false;
				for (bankApplication c : act) {
					if (c != null) {
						if (c.getAccountNo() == accountno) {
							System.out.println(c);
							check = true;
							break;
						}

					}
				}
				if (check == false) {
					System.out.println("Invalid account no...");
				}
				break;

			case 6:
				System.out.println("------Thank you-----");
				break;
			}
		} while (choise != 6);
	}

}
