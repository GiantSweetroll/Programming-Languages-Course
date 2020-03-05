package assignments;

public class BitManipulation 
{
	public char toLowerCase(char upper)
	{
		int mask = '\u0020';
		int uc = upper;
		int lc = uc | mask;
		
		return (char)lc;
	}
	
	public char toUpperCase(char lower)
	{
		int mask = '\u00DF';
		int lc = lower;
		int uc = lc & mask;
		return (char)uc;
	}
	
	public char digitToASCII(char num)
	{
		int mask = '\u00CF';
		int ascii_int = num & mask;
		
		return (char)ascii_int;
	}
	
	public char asciiToDigit(int ascii)
	{
		int mask = '\u0030';
		int digit = ascii | mask;
		
		return (char) digit;
	}
	
	public static void main(String args[])
	{
		BitManipulation bm = new BitManipulation();
		
		System.out.println(bm.toLowerCase('C'));
		System.out.println(bm.toUpperCase('c'));
		
		System.out.println();
		
		System.out.println(bm.digitToASCII('9'));
		System.out.println((int)bm.digitToASCII('9'));
		
		System.out.println();
		
		System.out.println(bm.asciiToDigit(1));
		System.out.println((int)bm.asciiToDigit(1));
	}
}
