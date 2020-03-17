package assignments.arrays_and_methods;

public class Main 
{
	public static void main(String args[])
	{
		int[][] matrix = {{0, -6, 4}, {-6, 0, 7}, {4, 7, 0}};
		System.out.println(Utilities.isSymmetric(matrix));
		
		MagicSquare ms = new MagicSquare(6);
		ms.show();
		System.out.println(Utilities.isMagicSquare(ms));
	}
}