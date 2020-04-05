package assignments.banking;

import java.util.List;
import java.util.Scanner;

public class Main 
{
	public static Scanner scanner = new Scanner(System.in);
	public static Bank bank = new Bank("My Bank");
	
	public static void main(String argsp[])
	{
		showMainMenu();
	}
	
	//UI Methods
	public static void showMainMenu()
	{
		println("Welcome to " + bank.getName());
		println("------------------------------------------");
		println("What would you like to do?");
		println();
		println("1. Create Account");
		println("2. Withdraw");
		println("3. Deposit");
		println("4. Exit");
		print("Response: ");
		
		int response = scanner.nextInt();
		scanner.nextLine();
		
		println();
		
		switch(response)
		{
			case 1:
				createAccount();
				break;
				
			case 2:
				withdraw();
				break;
				
			case 3:
				deposit();
				break;
				
			case 4:
				scanner.close();
				System.exit(0);
				break;
		}
	}
	public static void createAccount()
	{
		print("Enter first name: ");
		String f = scanner.nextLine();
		println();
		print("Enter last name: ");
		String l = scanner.nextLine();
		Customer c = new Customer(f, l);
		Account acc = new Account(0d);
		c.setAccount(acc);
		
		while(true)
		{
			print("Enter PIN (6 characters,  numbers 1-9): ");
			boolean b = c.setPin(scanner.next());
			if (!b)
			{
				println("Invalid PIN please try again.");
				continue;
			}
			break;
		}
		bank.addCustomer(c);
		println();
		showMainMenu();
	}
	public static void withdraw()
	{
		loop:
		while(true)
		{
			Customer c = findCustomer();
			if (c != null)
			{
				print("How much do you want to withdraw?: ");
				double amount = scanner.nextDouble();
				if (c.getAccount().withdraw(amount)) 
				{
					println("Money has been withdrawn. Current balance: " + c.getAccount().getBalance());
					break;
				}
				else
				{
					println();
					println("Invalid input. Try again?");
					println("1. Yes");
					println("2. No");
					print("Response: ");
					int response = scanner.nextInt();
					scanner.nextLine();
					switch(response)
					{
						case 1:
							continue;
							
						case 2:
							break loop;
					}
				}
			}
			else
			{
				break;
			}
		}
		showMainMenu();
	}
	public static Customer findCustomer()
	{
		while (true)
		{
			print("Enter your first name: ");
			String f = scanner.nextLine();
			print("Enter your last name: ");
			String l = scanner.nextLine();
			
			List<Customer> list = bank.getCustomers(f, l);
			if (list.size() > 0)
			{
				print("Enter PIN: ");
				String pin = scanner.next();
				scanner.nextLine();
				return bank.getCustomer(list, pin);
			}
			else
			{
				println();
				println("Account by the name " + f + " " + l + " was not found. Try again?");
				println("1. Yes");
				println("2. No");
				print("Response: ");
				int response = scanner.nextInt();
				scanner.nextLine();
				switch(response)
				{
					case 1:
						println();
						continue;
						
					case 2:
						return null;
						
					default:
						return null;
				}
			}
		}
	}
	public static void deposit()
	{
		loop:
			while(true)
			{
				Customer c = findCustomer();
				if (c != null)
				{
					print("How much do you want to deposit?: ");
					double amount = scanner.nextDouble();
					if (c.getAccount().deposit(amount)) 
					{
						println("Money has been deposited. Current balance: " + c.getAccount().getBalance());
						break;
					}
					else
					{
						println();
						println("Invalid input. Try again?");
						println("1. Yes");
						println("2. No");
						print("Response: ");
						int response = scanner.nextInt();
						scanner.nextLine();
						switch(response)
						{
							case 1:
								continue;
								
							case 2:
								break loop;
						}
					}
				}
				else
				{
					break;
				}
			}
			showMainMenu();
	}
	
	//Other Methods
	public static void print(Object obj)
	{
		System.out.print(obj);
	}
	public static void println(Object obj)
	{
		System.out.println(obj);
	}
	public static void println()
	{
		System.out.println();
	}
}