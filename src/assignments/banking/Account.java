package assignments.banking;

public class Account 
{
	//Fields
	private double balance;
	
	//Constructor
	public Account(double balance)
	{
		this.balance = balance;
	}
	
	//Methods
	public double getBalance()
	{
		return this.balance;
	}
	public boolean deposit(double amt)
	{
		if (amt >= 0)
		{
			this.balance += amt;
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean withdraw(double amt)
	{
		if (amt <= balance)
		{
			this.balance -= amt;
			return true;
		}
		else
		{
			return false;
		}
	}
}
