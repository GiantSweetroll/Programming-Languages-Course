package assignments.arrays_and_methods;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MagicSquare 
{
	private int[][] matrix;
	private int size;
	
	//Constructor
	public MagicSquare(int size)
	{
		this.size = size;
		this.create(size);
	}
	
	//Public Methods
	public int[][] getMatrix()
	{
		return this.matrix;
	}
	public int getSize()
	{
		return this.size;
	}
	public void create(int size)
	{
		this.matrix = new int[size][size];
		
		//If it's odd
		if (size%2==1)
		{
			this.generateOdd(size, 1, size*size, new Point(0, 0), new Point(size-1, size-1));
		}
		else	//If it's even
		{
			if (size%4 != 0)	//Singly even magic square
			{
				this.generateSinglyEven(size);
			}
			else	//Divisible by 4, doubly even magic square
			{
				this.generateDoublyEven(size);
			}
		}
	}

	public void show()
	{
		for (int[] arr : this.matrix)
		{
			for (int value : arr)
			{
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	
	//Private methods
	private void fillDoublyCornerBoxes(int magicSquareSize, int boxSize, int min, Point start, Point end)
	{
		int afr = 0;
		int counter = min;
		
		for (int a=start.x; a<=end.x; a++)
		{
			for (int b=start.y; b<=end.y; b++)
			{
				this.matrix[a][b] = counter;
				afr++;
				if (afr >= boxSize)
				{
					int diff = magicSquareSize-boxSize + 1;
					counter += diff;
					afr = 0;
				}
				else
				{
					counter++;
				}
			}
		}
	}
	private void fillDoublyCenterBoxes(int magicSquareSize, int boxSize, int min, Point start, Point end)
	{
		int afr = 0;
		int counter = min;
		
		for (int a=start.x; a<=end.x; a++)
		{
			for (int b=start.y; b<=end.y; b++)
			{
				this.matrix[a][b] = counter;
				afr++;
				if (afr > boxSize)
				{
					int diff = magicSquareSize-boxSize;
					counter += diff;
					afr = 0;
				}
				else
				{
					counter++;
				}
			}
		}
	}
	private void generateOdd(int size, int min, int max, Point start, Point end)
	{
		//Place the number 1 on the center of the top row
		int currentRow = start.x;
		int currentCol = start.y + ((end.y-start.y)/2);
		int counter = min;
		this.matrix[currentRow][currentCol] = counter;
		counter++;	//Move to next number
		
		//one up, one right
		int newRow = -1;
		int newCol = -1;
		while(counter <= max)
		{
			//Update pos
			newRow = currentRow - 1;	//-1 means go up
			newCol = currentCol + 1;
			//Check if it's outside the box
			if (newRow < start.x)
			{
				newRow = end.x;
			}
			if (newCol > end.y)
			{
				newCol = start.y;
			}
			
			//Check if it's filled and update pos
			if (this.matrix[newRow][newCol] == 0)
			{
				currentRow = newRow;
				currentCol = newCol;
			}
			else
			{
				//Move to box directly under it
				currentRow = currentRow + 1; //+1 means under it
				if (currentRow > end.x)
				{
					currentRow = start.x;
				}
			}
			
			//Place next number
			this.matrix[currentRow][currentCol] = counter;
			counter++;	//Increment counter by 1
		}
	}
	private void generateSinglyEven(int size)
	{
		//Divide square into 4 sections
		int[][] ranges = new int[4][2];		//Array to store the min and max value, and min and max index for each quadrant
		int boxesInEachRowQ = size/2;
		int currentVal = 0;
		int nBoxesInEachQ = boxesInEachRowQ*boxesInEachRowQ;
		for (int i=0; i<ranges.length; i++)
		{
			ranges[i][0] = currentVal + 1;		//Min value
			currentVal += nBoxesInEachQ;
			ranges[i][1] = currentVal;			//Max Value
		}
		//Switch the ranges
		/*
		 * Switch Quadrant 3 and 4
		 * Switch Quadrant 2 and 4
		 */
		int[] temp = ranges[2];
		ranges[2] = ranges[3];
		ranges[3] = temp;
		temp = ranges[1];
		ranges[1] = ranges[3];
		ranges[3] = temp;
		
		//Calculate the start and end indexes for each quadrant
		Point[][] indexes = new Point[4][2];
		int currentRow = 0;
		int currentCol = 0;
		for (int i=0; i<indexes.length; i++)
		{
			Point start = new Point(currentRow, currentCol);
			indexes[i][0] = start;
			Point end = new Point(start.x + boxesInEachRowQ-1, start.y + boxesInEachRowQ-1);
			indexes[i][1] = end;
			currentCol = end.y + 1;
			if (currentCol > size-1)
			{
				currentCol  = 0;
				currentRow += boxesInEachRowQ;
			}
		}
		
		//Fill in the numbers
		for (int i=0; i<ranges.length; i++)
		{
			this.generateOdd(size, 
									ranges[i][0], 
									ranges[i][1], 
									indexes[i][0], 
									indexes[i][1]);
		}
		
		//Identify the numbers to be swapped
		List<Point>[][] indexesForSwapping = new List[2][3];
		for (int a=0, b=0; a<3; a+=2, b++)
		{
			//Get the top left indexes before the median
			int counter = 0;
			List<Point> topAIndexes = new ArrayList<Point>();
			while (counter < boxesInEachRowQ/2)
			{
				topAIndexes.add(new Point(indexes[a][0].x, counter));
				counter++;
			}
			//Get the middle indexes
			List<Point> middleAIndexes = new ArrayList<Point>();
			Point point = new Point(topAIndexes.get(0).x+1, 1);
			for (int i=0; i<topAIndexes.size(); i++)
			{
				middleAIndexes.add(new Point(point.x, point.y));
				point.y++;
			}
			//Get lower left indexes
			List<Point> lowerAIndexes = new ArrayList<Point>();
			counter = 0;
			for (int i=0; i<topAIndexes.size(); i++)
			{
				lowerAIndexes.add(new Point(indexes[a][0].x + boxesInEachRowQ-1, counter));
				counter++;
			}
			
			//Add to the array
			indexesForSwapping[b][0] = topAIndexes;
			indexesForSwapping[b][1] = middleAIndexes;
			indexesForSwapping[b][2] = lowerAIndexes;
		}
		
		//Swap quadrant A and D
		for (int i=0; i<indexesForSwapping[0].length; i++)
		{
			for (int a=0; a<indexesForSwapping[0][i].size(); a++)
			{
				Point pointA = indexesForSwapping[0][i].get(a);
				Point pointD = indexesForSwapping[1][i].get(a);
				int num = this.matrix[pointA.x][pointA.y];
				this.matrix[pointA.x][pointA.y] = this.matrix[pointD.x][pointD.y];
				this.matrix[pointD.x][pointD.y] = num;
			}
		}
		
		//Identify points to be swapped between B and C
		int highlightEachRow = indexesForSwapping[0][0].size()-1;
		if (highlightEachRow > 0)
		{
			for (int i=0, j=indexesForSwapping[1][0].get(0).x; i<=indexesForSwapping[0][2].get(indexesForSwapping[0][2].size()-1).x; i++, j++)
			{
				for (int a=size-2; a<size; a++)	//size-2 because get second last index
				{
					int num = this.matrix[i][a];
					this.matrix[i][a] = this.matrix[j][a];
					this.matrix[j][a] = num;
				}
			}
		}
	}
	private void generateDoublyEven(int size)
	{
		int minisquareSize = size/4;
		
		//Identify corners
		Point[][] cornerHighlights = new Point[4][2];
		int currentRow = 0;
		int currentCol = 0;
		for (int i=0; i<cornerHighlights.length; i++)
		{
			Point start = new Point(currentRow, currentCol);
			cornerHighlights[i][0] = start;
			Point end = new Point(start.x + minisquareSize -1, start.y + minisquareSize-1);
			cornerHighlights[i][1] = end;
			
			if ((i+1) % 2 == 1)
			{
				currentCol = size-minisquareSize;
			}
			else
			{
				currentCol = 0;
				currentRow = size-minisquareSize;
			}
		}
		
		//Identify Center highlights
		Point[] centerHighlight = new Point[2];
		centerHighlight[0] = new Point(cornerHighlights[0][1].x+1, cornerHighlights[0][1].y+1);
		centerHighlight[1] = new Point(cornerHighlights[3][0].x-1, cornerHighlights[3][0].y-1);
		
		//Fill in numbers in the corner highlight
		int min = 1;
		int diff = size - minisquareSize;
		this.fillDoublyCornerBoxes(size, minisquareSize, min, cornerHighlights[0][0], cornerHighlights[0][1]);
		min += diff;
		this.fillDoublyCornerBoxes(size, minisquareSize, min, cornerHighlights[1][0], cornerHighlights[1][1]);
		int centerBoxSize = centerHighlight[1].x - centerHighlight[0].x;
		Dimension dimOutsideCenter = new Dimension(centerHighlight[0].x-cornerHighlights[0][0].x+1, centerHighlight[1].y-centerHighlight[0].y+1);
		min = this.matrix[cornerHighlights[1][1].x][cornerHighlights[1][1].y] + centerBoxSize*centerBoxSize + dimOutsideCenter.width*dimOutsideCenter.height*2;
		this.fillDoublyCornerBoxes(size, minisquareSize, min, cornerHighlights[2][0], cornerHighlights[2][1]);
		min += diff;
		this.fillDoublyCornerBoxes(size, minisquareSize, min, cornerHighlights[3][0], cornerHighlights[3][1]);
		
		//Fill in numbers in the center highlight
		min = this.matrix[cornerHighlights[1][1].x][cornerHighlights[1][1].y] + dimOutsideCenter.width;
		this.fillDoublyCenterBoxes(size, centerBoxSize, min, centerHighlight[0], centerHighlight[1]);
		
		//Fill in numbers in the non-highlighted area (counting backwards)
		for (int i=0, counter = size*size; i<this.matrix.length; i++)
		{
			for (int a=0; a<this.matrix[i].length; a++, counter--)
			{
				if (this.matrix[i][a] == 0)
				{
					this.matrix[i][a] = counter;
				}
			}
		}
	}
}