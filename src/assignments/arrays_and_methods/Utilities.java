package assignments.arrays_and_methods;

import java.util.Arrays;

public class Utilities 
{
	public static void splitHighestValue(int[] array)
	{
		int max = 0;
		int index = 0;
		
		for (int i=0; i<array.length; i++)
		{
			if (array[i] > max)
			{
				max = array[i];
				index = i;
			}
		}
		
		int secondMax = 0;
		for (int i=0; i<array.length; i++)
		{
			if (array[i] > secondMax && array[i] != max)
			{
				secondMax = array[i];
			}
		}
		
		for (int i=0; i<array.length; i++)
		{
			if (index == i)
			{
				System.out.print(secondMax + " " + (max-secondMax) + " ");
			}
			else
			{
				System.out.print(array[i] + " ");
			}
		}
	}

	public static void shiftRight(int[] array, int amount)
	{
		System.out.println("Original array: " + Arrays.toString(array));
		
		for (int i=0; i<amount; i++)
		{
			int last = array[array.length-1];
			
			for (int a = array.length-1; a>0; a--)
			{
				array[a] = array[a-1];
			}
			
			array[0] = last;
		}
		
		System.out.println("Shifted array (by " + amount + " to the right): " + Arrays.toString(array));
	}

	public static boolean isSymmetric(int[][] matrix)
	{
		boolean sym = true;
		
		int[][] transpose = new int[matrix.length][matrix.length];
		
		//Transpose
		for (int i=0; i<matrix.length; i++)
		{
			for (int a=0; a<matrix[i].length; a++)
			{
				transpose[a][i] = matrix[i][a];
			}
		}
		
		//Check
		for (int i=0; i<matrix.length; i++)
		{
			for (int a=0; a<matrix[i].length; a++)
			{
				if (transpose[a][i] != matrix[a][i])
				{
					sym = false;
					break;
				}
			}
		}
		
		return sym;
	}

	public static boolean isMagicSquare(MagicSquare ms)
	{
		int size = ms.getSize();
		int magicConstant = (size * (size * size + 1))/2;
		
		//Check horizontal
		int[][] matrix = ms.getMatrix();
		for (int i=0; i<matrix.length; i++)
		{
			int sum = 0;
			for (int a=0; a<matrix.length; a++)
			{
				sum += matrix[i][a];
			}
			
			if (sum != magicConstant)
			{
				return false;
			}
		}
		
		//Check Vertical
		for (int i=0; i<matrix.length; i++)
		{
			int sum = 0;
			for (int a=0; a<matrix.length; a++)
			{
				sum += matrix[a][i];
			}
			
			if (sum != magicConstant)
			{
				System.out.println("There");
				return false;
			}
		}
		
		//Check Diagonal 1
		int sum = 0;
		for (int i=0, j=0; i<matrix.length; i++)
		{
			sum += matrix[i][j];
		}
		if (sum != magicConstant)
		{
			System.out.println("Oops");
			return false;
		}
		
		//Check Diagonal 2
		sum = 0;
		for (int i=matrix.length-1, j=0; i>-1; i--, j++)
		{
			sum += matrix[i][j];
		}
		if (sum != magicConstant)
		{
			System.out.println("Stinky");
			return false;
		}
		
		return true;
	}
}