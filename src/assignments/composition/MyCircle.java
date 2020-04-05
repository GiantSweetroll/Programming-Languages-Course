package assignments.composition;

public class MyCircle
{
	//Fields
	private MyPoint center;
	private int radius;
	
	//Constructors
	public MyCircle()
	{
		this.center = new MyPoint(0, 0);
		this.radius = 1;
	}
	public MyCircle(int x, int y, int radius)
	{
		this.radius = radius;
		this.center = new MyPoint(x, y);
	}
	public MyCircle(MyPoint center, int radius) 
	{
		this.center = center;
		this.radius = radius;
	}
	
	//Setters and Getters
	public MyPoint getCenter() 
	{
		return center;
	}
	public void setCenter(MyPoint center) 
	{
		this.center = center;
	}
	public int getRadius() 
	{
		return radius;
	}
	public void setRadius(int radius)
	{
		this.radius = radius;
	}
	public int getCenterX()
	{
		return this.center.getX();
	}
	public void setCenterX(int x)
	{
		this.center.setX(x);
	}
	public int getCenterY()
	{
		return this.center.getY();
	}
	public void setCenterY(int y)
	{
		this.center.setY(y);
	}
	public int[] getCenterXY()
	{
		int[] pos = new int[2];
		pos[0] = this.getCenterX();
		pos[1] = this.getCenterY();
		
		return pos;
	}
	public void setCenterXY(int x, int y)
	{
		this.setCenterX(x);
		this.setCenterY(y);
	}
	
	//Other Methods
	@Override
	public String toString() {
		return "MyCircle [center=" + center.toString() + ", radius=" + radius + "]";
	}
	
	public double getArea()
	{
		double area = Math.PI * Math.pow(this.getRadius(), 2);
		return area;
	}
	
	public double getCircumferance()
	{
		double p = Math.PI * 2 * this.getRadius();
		return p;
	}
	
	public double distance(MyCircle another)
	{
		return this.center.distance(another.center);
	}
}
