package assignments.inheritance;

public class Shape 
{
	//Fields
	private String color;
	private boolean filled;
	
	//Constructor
	public Shape()
	{
		this.color = "green";
		this.filled = true;
	}
	public Shape(String color, boolean filled)
	{
		this.color = color;
		this.filled = filled;
	}
	
	//Setters and Getters
	public String getColor() 
	{
		return color;
	}
	public void setColor(String color) 
	{
		this.color = color;
	}
	public boolean isFilled() 
	{
		return filled;
	}
	public void setFilled(boolean filled) 
	{
		this.filled = filled;
	}
	
	//Other Methods
	@Override
	public String toString()
	{
		String temp = "A Shape with color of " + this.color + " and ";
		return this.filled? temp + "filled" : temp + "not filled";
	}
}