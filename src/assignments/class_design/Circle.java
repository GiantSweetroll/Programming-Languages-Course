package assignments.class_design;
public class Circle 
{
	//Fields
    private double radius;
    private String color;
    
    //Constructors
    public Circle()
    {
        this.radius = 1.0;
        this.color = "red";
    }
    
    public Circle(double radius)
    {
        this.setRadius(radius);
        this.color = "red";
    }
    
    public Circle(double radius, String color)
    {
        this.setRadius(radius);
        this.color = color;
    }
    
    //Setters and Getters
    public double getRadius()
    {
        return this.radius;
    }
    
    public double getArea()
    {
        return Math.PI * Math.pow(radius, 2);
    }
    
    public String getColor()
    {
        return this.color;
    }
    
    public void setRadius(double radius)
    {
    	this.radius = radius <=0? 1.0 : radius;
    }
    
    public void setColor(String color)
    {
        this.color = color;
    }

    //Other Methods
    public String toString() 
    {
        return "Circle [" + "radius=" + this.getRadius() + ", color=" + this.getColor() + "]";
    }
}
