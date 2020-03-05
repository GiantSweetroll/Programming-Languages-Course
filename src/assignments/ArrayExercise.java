package assignments;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExercise
{
	public int[] inputToArray(Scanner scanner, int size)
	{
		int[] array = new int[size];
		
		for (int i=0; i<size; i++)
		{
			System.out.print("Enter you number (" + (i+1) + "/" + size + "): ");
			array[i] = scanner.nextInt();
			scanner.nextLine();
		}
		
		System.out.println();
		System.out.println("Your array:");
		System.out.println(Arrays.toString(array));
		
		return array;
	}
	
	public void isPresentInArray(Scanner sc, int[] array)
	{
		System.out.print("Enter number to search in array: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		boolean present = false;
		
		for (int num : array)
		{
			if (num == number)
			{
				present = true;
				break;
			}
		}
		
		if (present)
		{
			System.out.println("The number is present!");
		}
		else
		{
			System.out.println("The number is not present :(");
		}
	}
	
	public void arrayContents(Scanner sc, int size)
	{
		//take user input
		int[] array = new int[size];
		int[] contents = new int[5];
		
		for (int i=0; i<size; i++)
		{
			System.out.print("Enter you number (" + (i+1) + "/" + size + "): ");
			array[i] = sc.nextInt();
			sc.nextLine();
			
			//Adding to contents array
			int num = array[i];
			if (num == 0)
			{
				contents[4] += 1;
			}
			else if (num > 0)
			{
				contents[0] += 1;
			}
			else
			{
				contents[1] += 1;
			}
			
			if (num % 2 == 0)
			{
				contents[2] += 1;
			}
			else
			{
				contents[3] += 1;
			}
		}
		
		//Print contents
		System.out.println("Number of positive numbers: " + contents[0]);
		System.out.println("Number of negative numbers: " + contents[1]);
		System.out.println("Number of even numbers: " + contents[2]);
		System.out.println("Number of odd numbers: " + contents[3]);
		System.out.println("Number of 0's: " + contents[4]);
	}
	
	public void calcSumAndProduct(int[] array)
	{
		int sum = 0;
		int product = array[0];
		
		for (int i=1; i<array.length; i++)
		{
			sum += array[i-1];
			product *= array[i];
		}
		
		System.out.println("Sum: " + sum);
		System.out.println("Product: " + product);
	}
	
	public void findLargestAndSmallest(int[] array)
	{
		int min = Integer.MAX_VALUE;
		int max = 0;
		
		for (int num : array)
		{
			if (num > max)
			{
				max = num;
			}
			
			if (num < min)
			{
				min = num;
			}
		}
		
		System.out.println("Smallest element: " + min);
		System.out.println("Largest element: " + max);
	}
	
	public void palendrome(int[] array)
	{
		boolean b = true;
		
		for (int i=0, j=array.length-1; i<array.length && j>=0; i++, j--)
		{
			if (array[i] != array[j])
			{
				b = false;
				break;
			}
		}
		
		System.out.println("This array is a palendrome: " + b);
	}
	
	public void split(int[] array)
	{
		int[] arr1 = new int[array.length/2];
		int[] arr2 = new int[arr1.length];
		
		for (int i=0, j=array.length/2, k=0; i<array.length/2 && j<array.length && k<array.length; i++, j++, k++)
		{
			arr1[k] = array[i];
			arr2[k] = array[j];
		}
		
		System.out.println("First half: " + Arrays.toString(arr1));
		System.out.println("Second half: " + Arrays.toString(arr2));
	}
	
	public void shiftRight(int[] array, int amount)
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
	
	public void sort(int[] array)
	{
		System.out.println("Original Array: " + Arrays.toString(array));
		
		//Via bubble sort
		for (int i=0; i<array.length-2; i++)
		{
			for (int a=i+1; a<array.length; a++)
			{
				if (array[i] > array[a])
				{
					int temp = array[i];
					array[i] = array[a];
					array[a] = temp;
				}
			}
		}
		
		System.out.println("Sorted Array: " + Arrays.toString(array));
	}
	
	public static void main(String args[])
	{
		ArrayExercise ae = new ArrayExercise();
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(",|\\s+");
		
		int[] array10 = new int[10];
		
		//No. 1
		array10 = ae.inputToArray(sc, 10);
		System.out.println();
		//No. 2
		ae.isPresentInArray(sc, array10);
		System.out.println();
		//No. 3
		ae.arrayContents(sc, 20);
		System.out.println();
		//No. 4
		ae.calcSumAndProduct(array10);
		System.out.println();
		//No. 5
		ae.findLargestAndSmallest(array10);
		System.out.println();
		//No. 6
		ae.palendrome(array10);
		System.out.println();
		//No. 7
		ae.split(array10);
		System.out.println();
		//No. 8
		
		//No. 9
		ae.shiftRight(array10, 1);
		System.out.println();
		//No. 10
		ae.sort(array10);
		
		sc.close();
	}
}
