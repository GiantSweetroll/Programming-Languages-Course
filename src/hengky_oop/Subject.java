package hengky_oop;

public class Subject 
{
	private String name, category, id;
	
	public Subject()
	{
		this.name = "";
		this.category = "";
		this.id = "";
	}

	//Setters and Getters
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getCategory() 
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public String getId() 
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
}
