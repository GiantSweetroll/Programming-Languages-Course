package assignments.composition;

public class Customer 
{
	//Fields
	private int ID, discount;
	private String name;
	
	//Constructor
	public Customer(int iD, int discount, String name) 
	{
		this.ID = iD;
		this.discount = discount;
		this.name = name;
	}

	//Setters and Getters
	public int getID() 
	{
		return ID;
	}

	public int getDiscount()
	{
		return discount;
	}
	
	public void setDiscount(int discount)
	{
		this.discount = discount;
	}

	public String getName() 
	{
		return name;
	}
	
	//Other Methods
	public String toString()
	{
		return this.getName() + "(" + this.getID() + ")";
	}
}
