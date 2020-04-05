package assignments.composition;

public class Book 
{
	//Fields
	private String name;
	private Author[] authors;
	private double price;
	private int qty;
	
	//Constructor
	public Book(String name, Author[] author, double price)
	{
		this.name = name;
		this.authors = author;
		this.price = price;
		this.qty = 0;
	}
	
	public Book (String name, Author[] author, double price, int qty)
	{
		this.name = name;
		this.authors = author;
		this.price = price;
		this.qty = qty;
	}

	//Setters and getters
	public String getName() 
	{
		return name;
	}

	public Author[] getAuthors()
	{
		return authors;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getQty() 
	{
		return qty;
	}

	public void setQty(int qty) 
	{
		this.qty = qty;
	}
	
	//Other Methods
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Book[name=" + this.getName() + ", ");
		for (Author author : this.authors)
		{
			sb.append(author.toString() + ",");
		}
		sb.append(" price=" + this.getPrice() + ", qty=" + this.getQty() + "]");
		return  sb.toString();
	}
	
	public String getAuthorNames()
	{
		StringBuilder sb = new StringBuilder();
		for (Author author : this.authors)
		{
			sb.append(author.getName() + ",");
		}
		String temp = sb.toString();
		
		return temp.substring(0, temp.length()-1);
	}
}
