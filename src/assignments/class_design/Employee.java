package assignments.class_design;

public class Employee
{
	//Fields
	private int id, salary;
	private String firstName, lastName;
	
	//Constructor
	public Employee(int id, String firstName, String lastName, int salary)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
	//Setters and Getters
	public int getID()
	{
		return this.id;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public int getSalary()
	{
		return this.salary;
	}
	public void setSalary(int salary)
	{
		this.salary = salary >= 0? salary : this.salary;
	}
	
	//Other Methods
	public int getAnnualSalary()
	{
		return this.getSalary() * 12;
	}
	public void raiseSalary(int percent)
	{
		this.salary = percent >= 0? this.salary + (int)((double)this.salary * ((double)percent/100d)) : this.salary;
	}
	public String toString()
	{
		return "Employee[id=" + this.getID() + ", name=" + this.getFirstName() + " " + this.getLastName() + ", salary= " + this.getSalary() + "]";
	}
}
