package assignments.class_design;

public class Account 
{
	//Fields
	private String id, name;
	private int balance;
	
	//Constructor
	public Account(String id, String name)
	{
		this.id = id;
		this.name = name;
		this.balance = 0;
	
	}
	public Account(String id, String name, int balance)
	{
		this.id = id;
		this.name = name;
		this.balance = balance >= 0? balance : 0;
	}
	
	//Setter and Getter
	public String getID()
	{
		return this.id;
	}
	public String getName()
	{
		return this.name;
	}
	public int getBalance()
	{
		return this.balance;
	}
	
	//Other Methods
	public int credit(int amount)
	{
		this.balance = amount > 0? balance + amount : balance;
		return this.getBalance();
	}
	public int debit(int amount)
	{
		if (amount <= this.getBalance())
		{
			this.balance -= amount;
		}
		else
		{
			System.out.println("Amount exceeded balance");
		}
		
		return this.balance;
	}
	public int transferTo(Account another, int amount)
	{
		if (amount <= this.balance)
		{
			this.balance-=amount;
			another.credit(amount);
		}
		else
		{
			System.out.println("Amount exceeded balance");
		}
		
		return this.getBalance();
	}
	public String toString()
	{
		return "Account[id=" + this.getID() + ", name=" + this.getName() + ", balance=" + this.getBalance() + "]";
	}
}
