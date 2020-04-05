package assignments.banking;

public class Main 
{
	public static void main(String argsp[])
	{
		Bank bank = new Bank("My Bank");
		bank.addCustomer("Happy", "Birthday");
		bank.addCustomer("Tom", "Harry");
		System.out.println(bank.getCustomer(1).getFirstName());
	}
}
