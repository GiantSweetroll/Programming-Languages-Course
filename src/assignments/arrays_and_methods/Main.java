package assignments.arrays_and_methods;

import java.util.Scanner;

public class Main 
{
	public static void main(String args[])
	{
		int[][] matrix = {{0, -6, 4}, {-6, 0, 7}, {4, 7, 0}};
		System.out.println(Utilities.isSymmetric(matrix));
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of magic square: ");
		int size = sc.nextInt();
		sc.nextLine();
		
		MagicSquare ms = new MagicSquare(size);
		ms.show();
		
		sc.close();
	}
}