package assignments.composition;

public class MyPoint 
{
	//Fields
	private int x;
	private int y;
	
	//Constructors
	public MyPoint()
	{
		this.x = 0;
		this.y = 0;
	}
	public MyPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//Setters and Getters
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY() 
	{
		return y;
	}
	public void setY(int y) 
	{
		this.y = y;
	}
	
	//Other Methods
	@Override
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
	
	public double distance(int x, int y)
	{
		double xDiff = x - this.getX();
		double yDiff = y - this.getY();
		
		return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
	}
	
	public double distance(MyPoint point)
	{
		return this.distance(point.getX() , point.getY());
	}
	
	public double distance()
	{
		return this.distance(0,  0);
	}
}
