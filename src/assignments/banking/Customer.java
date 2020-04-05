package assignments.banking;

public class Customer 
{
	//Fields
	private String firstName, lastName;
	private Account account;
	private int pin;
	
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
	
	//Other Methods
	public boolean setPin(String pin)
	{
		if (pin.length() != 6)
		{
			return false;
		}
		else
		{
			try
			{
				this.pin = Integer.parseInt(pin);
				return true;
			}
			catch(Exception ex)
			{
				return false;
			}
		}
	}
	public boolean checkPIN(int pin)
	{
		return this.pin == pin;
	}
	public boolean checkPIN(String pin)
	{
		try
		{
			return this.checkPIN(Integer.parseInt(pin));
		}
		catch(Exception ex)
		{
			return false;
		}
	}
}
