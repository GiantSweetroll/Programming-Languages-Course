package assignments.class_design;

/**
 * I've done this before so I'm just copy pasting my code from my library I hope its ok :)
 * It has a lot of utility methods with the proper input validation
 * I added some of the necessary function to get your requested output
 */
public class Date 
{
	private int day, month, year;
	
	//Format Constants
	public static final int DAY = 0, MONTH = 1, YEAR = 2;
	
	//Constructors
	public Date(int day, int month, int year)
	{
		this.year = year;
		this.parseMonth(month);
		this.parseDay(day);
	}
	
	//Methods
	public int getDay()
	{
		return this.day;
	}
	public int getMonth()
	{
		return this.month;
	}
	public int getYear()
	{
		return this.year;
	}
	public void setDay(int day)
	{
		this.parseDay(day);
	}
	public void setMonth(int month)
	{
		this.parseMonth(month);
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	public boolean monthIsFebruary()
	{
		return this.month == 2;
	}
	public boolean monthIs31Days()
	{
		if (this.month >= 1 && this.month <=7 && this.month!=2)
		{
			return this.month%2 == 1;
		}
		else if (this.month >=8 && this.month <=12)
		{
			return this.month%2 == 0;
		}
		else
		{
			return false;
		}
	}
	public boolean monthIs30Days()
	{
		if (this.month >= 1 && this.month <=7 && this.month!=2)
		{
			return this.month%2 == 0;
		}
		else if (this.month >=8 && this.month <=12)
		{
			return this.month%2 == 1;
		}
		else
		{
			return false;
		}
	}
	public boolean isLeapYear()
	{
		return this.year%4 == 0;
	}
	public boolean isLaterThan(Date date)
	{
		if(this.getYear() > date.getYear())
		{
			return true;
		}
		else if (this.getYear() < date.getYear())
		{
			return false;
		}
		else		//if year is the same
		{
			if (this.getMonth() > date.getMonth())
			{
				return true;
			}
			else if (this.getMonth() < date.getMonth())
			{
				return false;
			}
			else		//same month
			{
				if (this.getDay() > date.getDay())
				{
					return true;
				}
				else if (this.getDay() < date.getDay())
				{
					return false;
				}
				else	//Same day
				{
					return false;
				}
			}
		}
	}
	public boolean isEarlierThan(Date date)
	{
		if(this.getYear() > date.getYear())
		{
			return false;
		}
		else if (this.getYear() < date.getYear())
		{
			return true;
		}
		else		//if year is the same
		{
			if (this.getMonth() > date.getMonth())
			{
				return false;
			}
			else if (this.getMonth() < date.getMonth())
			{
				return true;
			}
			else		//same month
			{
				if (this.getDay() > date.getDay())
				{
					return false;
				}
				else if (this.getDay() < date.getDay())
				{
					return true;
				}
				else	//Same day
				{
					return false;
				}
			}
		}
	}
	public String toString(int first, int mid, int last, String separator)
	{
		return this.getString(first) + separator + this.getString(mid) + separator + this.getString(last);
	}
	public String toString()
	{
		return this.checkDigit(this.getDay(), 2) + "/" + this.checkDigit(this.getMonth(), 2) + "/" + this.checkDigit(this.getYear(), 4);
	}
	
	//Static methods
	public static boolean areSameDate(Date date1, Date date2)
	{
		return haveSameYear(date1, date2) && haveSameMonth(date1, date2) && haveSameDay(date1, date2);
	}
	public static boolean haveSameYear(Date date1, Date date2)
	{
		return date1.getYear() == date2.getYear();
	}
	public static boolean haveSameMonth(Date date1, Date date2)
	{
		return date1.getMonth() == date2.getMonth();
	}
	public static boolean haveSameDay(Date date1, Date date2)
	{
		return date1.getDay() == date2.getDay();
	}
	public static boolean monthIsFebruary(int month)
	{
		return month == 2;
	}
	public static boolean monthIs31Days(int month)
	{
		if (month >= 1 && month <=7 && month!=2)
		{
			return month%2 == 1;
		}
		else if (month >=8 && month <=12)
		{
			return month%2 == 0;
		}
		else
		{
			return false;
		}
	}
	public static boolean monthIs30Days(int month)
	{
		if (month >= 1 && month <=7 && month!=2)
		{
			return month%2 == 0;
		}
		else if (month >=8 && month <=12)
		{
			return month%2 == 1;
		}
		else
		{
			return false;
		}
	}
	public static boolean isLeapYear(int year)
	{
		return year%4 == 0;
	}
	public static int getDaysDifference(Date from, Date to, boolean includeEndDate)
	{
		if (Date.areSameDate(from,  to))		//if same date
		{
			return 0;
		}
		
		//Check if from is later than to
		if (to.isEarlierThan(from))
		{
			//Switch Places
			Date temp = from;
			from = to;
			to = temp;
		}
		
		//Get min date
		int yearMin = from.getYear();
		int monthMin = from.getMonth();
		int dayMin = from.getDay();
		
		//Get max date
		int yearMax = to.getYear();
		int monthMax = to.getMonth();
		int dayMax = to.getDay();
		
		//status
		int days = 0;
		int day = dayMin;
		int month = monthMin;
		int year = yearMin;
		
		//Keep adding by 1, converting days to months, and months to year if needed until reaching max date
		while(true)
		{
			//Check if the current day, month, and year is exactly the same as the max
			if (day==dayMax && month==monthMax && year==yearMax)
			{
				break;
			}
			
			//Keep adding by 1 day
			day++;
			days++;
			//Conversion of days to months
			if (Date.monthIsFebruary(month))
			{
				if (Date.isLeapYear(year))
				{
					if (day > 29)
					{
						day = 1;
						month++;
					}
				}
				else
				{
					if (day > 28)
					{
						day = 1;
						month++;
					}
				}
			}
			else if (Date.monthIs30Days(month))
			{
				if (day > 30)
				{
					day = 1;
					month++;
				}
			}
			else if (Date.monthIs31Days(month))
			{
				if (day > 31)
				{
					day = 1;
					month++;
				}
			}
			
			//Conversion of months to year
			if (month > 12)
			{
				month = 1;
				year++;
			}
		}
		
		if (includeEndDate)
		{
			days++;
		}
		
		return days;
	}
	public static Date getEarlierDate(Date date, Date date2)
	{
		if (date.isEarlierThan(date2))
		{
			return date;
		}
		else if (date.isLaterThan(date2))
		{
			return date2;
		}
		else
		{
			return date;
		}
	}
	public static Date getLaterDate(Date date, Date date2)
	{
		if (date.isEarlierThan(date2))
		{
			return date2;
		}
		else if (date.isLaterThan(date2))
		{
			return date;
		}
		else
		{
			return date;
		}
	}
	
	//Private Methods
	private String checkDigit(int value, int digit)
	{
		String val = Integer.toString(value);
		if (val.length() < digit)
		{
			int diff = digit - val.length();
			for (int i=0; i<diff; i++)
			{
				val = "0" + val;
			}
		}
		
		return val;
	}
	private void parseMonth(int month)
	{
		if (month < 1)
		{
			this.month = 1;
		}
		else if (month > 12)
		{
			this.year += (int)(month/12);
			this.month = (int)(month%12);
		}
		else
		{
			this.month = month;
		}
	}
	private void parseDay(int day)
	{
		if (day<1)
		{
			this.day = 1;
		}
		else
		{
			while(true)
			{
				if (this.monthIsFebruary())
				{
					if (this.isLeapYear())
					{
						if (day<=29)
						{
							this.day = day;
							break;
						}
					}
					else		//not a leap year
					{
						if (day <= 28)
						{
							this.day = day;
							break;
						}
					}
				}
				else			//not February
				{
					if(this.monthIs30Days())
					{
						if (day<=30)
						{
							this.day = day;
							break;
						}
					}
					else if (this.monthIs31Days())
					{
						if (day<=31)
						{
							this.day = day;
							break;
						}
					}
				}
				
				//convert day to next month
				if (this.monthIsFebruary())
				{
					if (this.isLeapYear())
					{
						day -= 29;
						this.month++;
					}
					else	//not leap year
					{
						day -= 28;
						this.month ++;
					}
				}
				else if (this.monthIs30Days())
				{
					day -= 30;
					this.month++;
				}
				else if (this.monthIs31Days())
				{
					day -= 31;
					this.month++;
				}
				
				//Convert month to next year if needed
				if (this.month > 12)
				{
					this.month -= 12;
					this.year++;
				}
			}
		}
	}
	private String getString(int type)
	{
		if (type == Date.DAY)
		{
			return Integer.toString(this.getDay());
		}
		else if (type == Date.MONTH)
		{
			return Integer.toString(this.getMonth());
		}
		else if (type == Date.YEAR)
		{
			return Integer.toString(this.getYear());
		}
		else
		{
			return "";
		}
	}
}
