package assignments.banking;

public class Bank 
{
	//Fields
	private Customer[] customers;
	private int numberOfCustomers;
	private String bankName;
	
	//Constructor
	public Bank(String bName)
	{
		this.bankName = bName;
		this.customers = new Customer[1];
		this.numberOfCustomers = 0;
	}
	
	//Methods
	public void addCustomer(String f, String l)
	{
		Customer c = new Customer(f, l);
		this.numberOfCustomers++;
		Customer temp[] = new Customer[this.numberOfCustomers];
		System.arraycopy(this.customers, 0, temp, 0, 1);
		this.customers = temp;
		this.customers[this.numberOfCustomers-1] = c;
	}
	public int getNumOfCustomers()
	{
		return this.numberOfCustomers;
	}
	public Customer getCustomer(int index)
	{
		return this.customers[index];
	}
	public String getName()
	{
		return this.bankName;
	}
}
