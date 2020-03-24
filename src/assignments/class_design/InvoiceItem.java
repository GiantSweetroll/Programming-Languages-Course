package assignments.class_design;

public class InvoiceItem
{
	//Fields
	public String id, desc;
	private int qty;
	private double unitPrice;
	
	//Constructor
	public InvoiceItem(String id, String desc, int qty, double unitPrice)
	{
		this.id = id;
		this.desc = desc;
		this.qty = qty >= 0? qty : 0;
		this.unitPrice = unitPrice >= 0? unitPrice : 0;
	}
	
	//Setters and getters
	public String getID()
	{
		return this.id;
	}
	public String getDesc()
	{
		return this.desc;
	}
	public int getQty()
	{
		return this.qty;
	}
	public void setQty(int qty)
	{
		this.qty = qty >= 0? qty : this.qty;
	}
	public double getUnitPrice()
	{
		return this.getUnitPrice();
	}
	public void setUnitPrice(double unitPrice)
	{
		this.unitPrice = unitPrice >= 0? unitPrice : this.unitPrice;
	}
	
	//Other Methods
	public double getTotal()
	{
		return this.getUnitPrice() * this.getQty();
	}
	public String toString()
	{
		return "InvoiceItem[id=" + this.getID() + ", desc=" + this.getDesc() + ", qty=" + this.getQty() + ", unitPrice=" + this.getUnitPrice() + "]";
	}
}
