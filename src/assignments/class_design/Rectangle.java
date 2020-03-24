package assignments.class_design;

public class Rectangle
{
	private float length, width;
	
	//Constructor
	Rectangle()
	{
		this.length = 1.0f;
		this.width = 1.0f;
	}
	
	Rectangle(float length, float width)
	{
		this.length = length;
		this.width = width;
	}
	
	//Setter and getter
	public float getLength()
	{
		return this.length;
	}
	public void setLength(float length)
	{
		this.length = length > 0? length : 1.0f;
	}
	public float getWidth()
	{
		return this.width;
	}
	public void setWidth(float width)
	{
		this.width = width > 0? width : 1.0f;
	}
	
	//Other methods
	public double getArea()
	{
		return this.width * this.length;
	}
	public double getPerimeter()
	{
		return 2*this.width + 2* this.length;
	}
	public String toString()
	{
		return "Rectangle[length=" + this.getLength() + ", width=" + this.getWidth() + "]";
	}
}
