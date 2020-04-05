package assignments.composition;

public class MyTriangle
{
	//Fields
	private MyPoint v1, v2, v3;

	//Constructors
	public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) 
	{
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}
	public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3)
	{
		this.v1 = new MyPoint(x1, y1);
		this.v2 = new MyPoint(x2, y2);
		this.v3 = new MyPoint(x3, y3);
	}
	
	//Other Methods
	@Override
	public String toString() 
	{
		return "MyTriangle [v1=" + v1.toString() + ", v2=" + v2.toString() + ", v3=" + v3.toString() + "]";
	}
	
	public double getPerimeter()
	{
		double p = this.v1.distance(v2) + this.v1.distance(v3) + this.v2.distance(v3);
		
		return p;
	}
	
	public String getType()
	{
		double s1 = this.v1.distance(v2);
		double s2 = this.v1.distance(v3);
		double s3 = this.v2.distance(v3);
		
		if (s1 == s2 && s2 == s3)
		{
			return "Equilateral";
		}
		else if (s1 != s2 && s1 != s3 && s2 != s3)
		{
			return "Isosceles";
		}
		else
		{
			return "Scalene";
		}
	}
}
