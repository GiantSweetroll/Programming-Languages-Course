package assignments.inheritance.shape;

public class Square extends Rectangle
{
	//Constructors
	public Square()
	{
		super();
	}
	public Square(double side)
	{
		super(side, side);
	}
	public Square(double side, String color, boolean filled)
	{
		super(side, side, color, filled);
	}
	
	//Other Methods
	public double getSide()
	{
		return this.getWidth();
	}
	public void setSide(double side)
	{
		this.setWidth(side);
		this.setLength(side);
	}
	
	@Override
	public void setWidth(double side)
	{
		super.setWidth(side);
		super.setLength(side);
	}
	
	@Override
	public void setLength(double side)
	{
		super.setWidth(side);
		super.setLength(side);
	}
	
	@Override
	public String toString()
	{
		return "A Square with side=" + Double.toString(this.getSide()) + ", which is a subclass of " + super.toString();
	}
}
