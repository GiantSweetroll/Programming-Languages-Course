package assignments.banking;

import java.util.ArrayList;
import java.util.List;

public class Bank 
{
	//Fields
	private List<Customer> customers;
	private int numberOfCustomers;
	private String bankName;
	
	//Constructor
	public Bank(String bName)
	{
		this.bankName = bName;
		this.customers = new ArrayList<Customer>();
		this.numberOfCustomers = 0;
	}
	
	//Methods
	public void addCustomer(String f, String l)
	{
		Customer c = new Customer(f, l);
		Account a = new Account(0d);
		c.setAccount(a);
		this.addCustomer(c);
	}
	public void addCustomer(Customer c)
	{
		this.numberOfCustomers++;
		this.customers.add(c);
	}
	public int getNumOfCustomers()
	{
		return this.numberOfCustomers;
	}
	public Customer getCustomer(int index)
	{
		return this.customers.get(index);
	}
	public String getName()
	{
		return this.bankName;
	}
	public List<Customer> getCustomers(String f, String l)
	{
		List<Customer> list = new ArrayList<Customer>();
		
		for (Customer c : this.customers)
		{
			if (c.getFirstName().equalsIgnoreCase(f) && c.getLastName().equalsIgnoreCase(l))
			{
				list.add(c);
			}
		}
		
		return list;
	}
	public Customer getCustomer(List<Customer> customers, String pin)
	{
		Customer c = null;
		
		for (Customer customer : customers)
		{
			if (customer.checkPIN(pin))
			{
				c = customer;
			}
		}
		
		return c;
	}
}
