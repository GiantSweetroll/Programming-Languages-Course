package assignments.composition;

public class Account
{
	//Fields
	private int id;
	private Customer2 customer;
	private double balance;
	
	//Constructors
	public Account(int id, Customer2 customer, double balance)
	{
		this.id = id;
		this.customer = customer;
		this.balance = balance;
	}
	public Account(int id, Customer2 customer) 
	{
		this.id = id;
		this.customer = customer;
		this.balance = 0d;
	}
	
	//Setters and Getters
	public int getID() 
	{
		return id;
	}
	public Customer2 getCustomer() 
	{
		return customer;
	}
	public double getBalance() 
	{
		return balance;
	}
	public void setBalance(double balance) 
	{
		this.balance = balance;
	}
	
	//Other Methods
	public String toString()
	{
		return this.getCustomer().toString() + " balance=$" + Math.round(this.getBalance()/100d); 
	}
	
	public String getCustomerName()
	{
		return this.getCustomer().getName();
	}
	
	public Account deposit(double amount)
	{
		this.balance += amount;
		return this;
	}
	
	public Account(double amount)
	{
		if (this.balance >= amount)
		{
			this.balance -= amount;
		}
		else
		{
			System.out.println("Amount withdrawn exceeds the current balance!");
		}
	}
}
