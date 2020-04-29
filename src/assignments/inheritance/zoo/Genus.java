package assignments.inheritance.zoo;

public class Genus
{
	private String genusName;
	
	//Constructor
	public Genus(String g)
	{
		this.genusName = g;
	}
	
	//Setter and Getters
	public String getGenusName()
	{
		return this.genusName;
	}
	
	//Other Methods
	@Override
	public String toString()
	{
		return "Genus: " + this.getGenusName();
	}
}