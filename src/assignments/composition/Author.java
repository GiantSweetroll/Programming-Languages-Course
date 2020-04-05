package assignments.composition;

public class Author 
{
	//Fields
	private String name, email;
	private char gender;
	
	//Constructor
	public Author(String name, String email, char gender)
	{
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	//Setter and Getter
	public String getName() 
	{
		return name;
	}

	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}

	public char getGender() 
	{
		return gender;
	}
	
	//Other Methods
	public String toString()
	{
		return "Author[name=" + this.getName() + ", email=" + this.getEmail() + ", gender=" + this.getGender() + "]";
	}
}