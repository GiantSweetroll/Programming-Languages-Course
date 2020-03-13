package hengky_oop;

public class Score
{
	private String id;
	private int value;
	private Subject subject;
	
	//Constructor
	public Score()
	{
		this.id = "";
		this.value = -1;
		this.subject = new Subject();
	}

	//Setters and Getters
	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public Subject getSubject()
	{
		return subject;
	}

	public void setSubject(Subject subject)
	{
		this.subject = subject;
	}
}
