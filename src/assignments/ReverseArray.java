package assignments;

import java.util.Arrays;

public class ReverseArray 
{
	public static void main(String args[])
	{
		int x[] = {1, 2, 3, 4, 5};
		for (int a=0; a<x.length/2; a++)
		{
			int temp = x[a];
			x[a] = x[x.length-a-1];
			x[x.length-a-1] = temp;
		}
		System.out.println(Arrays.toString(x));
	}
}
