package assignments;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingChallenge
{
	public void balanceScale(String[] array)
	{
		//Get scales and available weights
		int left = Integer.parseInt(array[0].substring(0, array[0].indexOf(", ")));
		int right = Integer.parseInt(array[0].substring(array[0].indexOf(", ")+2));
		String[] sWeights = array[1].split(", ");
		int[] weights = new int[sWeights.length];
		for (int i=0; i<weights.length; i++)
		{
			weights[i] = Integer.parseInt(sWeights[i]);
		}
		
		//Preparation
		int newWeights[] = new int[2];
		
		//Process
		//Calculate by difference
		int difference = Math.abs(left - right);
		for (int i=0; i<weights.length-1; i++)
		{
			if (weights[i] == difference)
			{
				newWeights[0] = difference;
				break;
			}
			else
			{
				for (int a = i+1; a < weights.length; a++)
				{
					if (weights[i] + weights[a] == difference)
					{
						newWeights[0] = weights[i];
						newWeights[1] = weights[a];
						break;
					}
				}
			}
		}
		//Calculate by gradual addition
		if (newWeights[0] == 0 && newWeights[1] == 0)
		{
			int[] leftRightWeights = {left, right};
			int[][] matrix = new int[2][weights.length];
			
			//Adding them all into matrix
			for(int i=0; i<matrix.length; i++)
			{
				for (int a=0; a<matrix[i].length; a++)
				{
					matrix[i][a] = leftRightWeights[i] + weights[a];
				}
			}
			
			//Check for similarity
			for(int i=0; i<matrix[0].length; i++)
			{
				for (int a=0; a<matrix[1].length; a++)
				{
					if (matrix[0][i] == matrix[1][a])
					{
						newWeights[0] = weights[i];
						newWeights[1] = weights[a];
					}
				}
			}
		}
		
		//Sort array
		Arrays.sort(newWeights);
		
		//Convert to String
		String str = Integer.toString(newWeights[0]) + "," + Integer.toString(newWeights[1]);
		if(str.substring(0, 1).equals("0"))
		{
			str = str.substring(2);	//Cut the "0,"
			//If the second is also 0
			if(str.substring(0, 1).equals("0"))
			{
				str = "Not Possible";
			}
		}
		
		System.out.println(str);
	}
	
	public String correctPath(String incompletePath, Dimension boardDim, Point startPos, Point endPos)
	{
		//Check if starting and end position is in the board
		if (this.isInTheBoard(startPos, boardDim) && this.isInTheBoard(endPos, boardDim))
		{
			String[] choices = {"r", "l", "u", "d"};
			
			List<Point> prevPaths = new ArrayList<Point>();
			prevPaths.add(startPos);
			
			StringBuilder path = new StringBuilder("Not Possible");	//By default the path is "Not Possible"
			
			this.findPath(incompletePath, 
							incompletePath.substring(0, 1), 
							choices, 
							prevPaths, 
							new Dimension(5, 5),
							endPos,
							path);
			
			return path.toString();
		}
		else
		{
			return "Not Possible";
		}
	}
	
	public void findPath(String incompletePath,
							String currentPath,
							String[] choices,
							List<Point> prevPath,
							Dimension boardDim,
							Point endPos,
							StringBuilder path)
	{
		if (currentPath.length() == incompletePath.length() && !currentPath.substring(currentPath.length()-1).equals("?"))
		{
			//Update position to check if its a legit location on the board
			Point finalPos = updateCoordinate(prevPath.get(prevPath.size()-1), 
												currentPath.substring(currentPath.length()-1), 
												boardDim);
			if (finalPos != null)
			{
				//Check if the final position is proper
				if (finalPos.x == endPos.x && finalPos.y == endPos.y)
				{
					path.replace(0, path.length(), currentPath);
				}
			}
		}
		else
		{
			String currentChoice = currentPath.substring(currentPath.length()-1);	//u, d, l, r, or ?
			if (!currentChoice.equals("?"))
			{
				//Update position
				Point point = this.updateCoordinate(prevPath.get(prevPath.size()-1), 
													currentChoice, 
													boardDim);
				
				if (point != null)		//If its a valid path
				{
					//Check if new location has been traversed before
					boolean unique = true;
					for (Point pt : prevPath)
					{
						if (pt.x == point.x && pt.y == point.y)
						{
							unique = false;
							break;
						}
					}
					
					//If new cell is unique
					if (unique)
					{
						prevPath.add(point);
						findPath(incompletePath,
									currentPath + incompletePath.substring(currentPath.length(), currentPath.length()+1),
									choices,
									prevPath,
									boardDim,
									endPos,
									path);
					}
				}
			}
			else	//If current cell is "?"
			{
				//Try all possible outcomes
				for (String choice : choices)
				{
					List<Point> newPath = new ArrayList<Point>();
					newPath.addAll(prevPath);
					this.findPath(incompletePath, 
									currentPath.substring(0, currentPath.length()-1) + choice, //Removes the "?" and replaces it with one of the four choices (u, d, l, r)
									choices, 
									newPath, 
									boardDim,
									endPos,
									path);
				}
			}
		}
	}
	
	public Point updateCoordinate(Point currentCell, String chosenPath, Dimension boardDim)
	{
		Point point;
		//Update to new position
		if (chosenPath.equals("u"))
		{
			point = new Point(currentCell.x, currentCell.y+1);
		}
		else if (chosenPath.equals("l"))
		{
			point = new Point(currentCell.x-1, currentCell.y);
		}
		else if (chosenPath.equals("d"))
		{
			point = new Point(currentCell.x, currentCell.y-1);
		}
		else	//(chosenPath.equals("r"))
		{
			point = new Point(currentCell.x+1, currentCell.y);
		}
		
		//Check if new position exists on the board
		if (this.isInTheBoard(point, boardDim))
		{
			return point;
		}
		else
		{
			return null;
		}
	}
	
	public boolean isInTheBoard(Point point, Dimension boardDim)
	{
		return (point.x >= 0 && point.x < boardDim.width) && (point.y >= 0 && point.y < boardDim.height);
	}
	
	public static void main (String argsp[])
	{
		CodingChallenge cc = new CodingChallenge();
		
		//Challenge 1
		System.out.println("Challenge 1:");
		cc.balanceScale(new String[] {"5, 9", "1, 2, 6, 7"});
		cc.balanceScale(new String[] {"3, 4", "1, 2, 7, 7"});
		cc.balanceScale(new String[] {"13, 4", "1, 2, 3, 6, 14"});
		cc.balanceScale(new String[] {"2, 4", "1, 5, 10"});
		
		System.out.println();
		
		//Challenge 2
		System.out.println("Challenge 2:");
		Dimension boardDim = new Dimension(5, 5);
		Point startPos = new Point(0, 4);		//Top left
		Point endPos = new Point(4, 0);			//Bottom right
		System.out.println(cc.correctPath("r?d?drdd", boardDim, startPos, endPos));
		System.out.println(cc.correctPath("???rrurdr?", boardDim, startPos, endPos));
		System.out.println(cc.correctPath("drdr??rrddd?", boardDim, startPos, endPos));
	}
}