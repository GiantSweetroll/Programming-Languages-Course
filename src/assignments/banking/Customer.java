package assignments.banking;

public class Customer 
{
	//Fields
	private String firstName, lastName;
	private Account account;
	
	//Constructor
	public Customer(String f, String l)
	{
		this.firstName = f;
		this.lastName = l;
	}
	
	//Setters and Getters
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public Account getAccount()
	{
		return this.account;
	}
	public void setAccount(Account acct)
	{
		this.account = acct;
	}
}
