package assignments.composition;

public class Invoice 
{
	//Fields
	private int ID;
	private Customer customer;
	private double amount;
	
	//Constructor
	public Invoice(int iD, Customer customer, double amount)
	{
		ID = iD;
		this.customer = customer;
		this.amount = amount;
	}

	//Setters and Getters
	public int getID() 
	{
		return ID;
	}

	public Customer getCustomer() 
	{
		return customer;
	}

	public void setCustomer(Customer customer) 
	{
		this.customer = customer;
	}

	public double getAmount() 
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}
	
	//Other Methods
	public String getCustomerName()
	{
		return this.getCustomer().getName();
	}
	public double getAmountAfterDiscount()
	{
		double discount  = this.getAmount() * (this.getCustomer().getDiscount() / 100d);
		double hasil = this.getAmount() - discount;
		
		return hasil;
	}
}
