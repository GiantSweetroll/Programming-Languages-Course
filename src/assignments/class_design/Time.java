package assignments.class_design;

public class Time 
{
	//Fields
	private int hour, minute, second;
	
	//Constructor
	public Time(int hour, int minute, int second)
	{
		this.setTime(hour, minute, second);
	}

	//Setters and Getters
	public int getHour() 
	{
		return hour;
	}

	public void setHour(int hour) 
	{
		this.hour = hour >= 0 ? hour : 0;
	}

	public int getMinute() 
	{
		return minute;
	}

	public void setMinute(int minute)
	{
		this.minute = minute >= 0 && minute <60? minute : 0;
	}

	public int getSecond() 
	{
		return second;
	}

	public void setSecond(int second) 
	{
		this.second = second >= 0 && second <60? second : 0;
	}
	
	//Other Methods
	private String checkDigit(int value)
	{
		String val = Integer.toString(value);
		if (val.length() < 2)
		{
			int diff = 2 - val.length();
			for (int i=0; i<diff; i++)
			{
				val = "0" + val;
			}
		}
		
		return val;
	}
	public void setTime(int hour, int minute, int second)
	{
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}
	public String toString()
	{
		return this.checkDigit(this.getHour()) + ":" + this.checkDigit(this.getMinute()) + ":" + this.checkDigit(this.getSecond());
	}
	public Time nextSecond()
	{
		int second = this.getSecond()+1;
		int minute = this.getMinute();
		if (second == 60)
		{
			minute++;
			second = 0;
		}
		int hour = 0;
		if (minute == 60)
		{
			hour++;
			minute = 0;
		}
		
		return new Time(hour, minute, second);
	}
	public Time previousSecond()
	{
		int second = this.getSecond()-1;
		int minute = this.getMinute();
		if (second < 0)
		{
			minute--;
			second = 59;
		}
		int hour = 0;
		if (minute < 0)
		{
			hour--;
			minute = 59;
		}
		
		return new Time(hour, minute, second);
	}
}
