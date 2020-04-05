package assignments.composition;

public class Customer2 
{
	//Fields
	private int ID;
	private String name;
	private char gender;
	
	//Constructor
	public Customer2(int iD, String name, char gender) 
	{
		super();
		ID = iD;
		this.name = name;
		this.gender = gender;
	}

	//Getters
	public int getID() 
	{
		return ID;
	}

	public String getName() 
	{
		return name;
	}

	public char getGender() 
	{
		return gender;
	}
	
	//Other Methods
	public String toString()
	{
		return this.getName() + "(" + this.getID() + ")";
	}
}