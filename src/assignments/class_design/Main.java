package assignments.class_design;

public class Main 
{
	public static void main(String args[])
	{
		Employee e = new Employee(1, "My", "Name", 12000);
		System.out.println(e.getSalary());
		e.raiseSalary(12);
		System.out.println(e.getSalary());
	}
}
