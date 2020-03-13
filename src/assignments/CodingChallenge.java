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
	
	public void correctPath(String incompletePath)
	{
		String[] choices = {"r", "l", "u", "d"};
		
		List<Point> prevPaths = new ArrayList<Point>();
		prevPaths.add(new Point(0, 0));
		
		String path = this.findPath(incompletePath, 
									incompletePath.substring(0, 1), 
									choices, 
									prevPaths, 
									new Dimension(5, 5));
		
		System.out.println("Path: " + path);
	}
	
	public String findPath(String incompletePath,
							String currentPath,
							String[] choices, 
							List<Point> prevPath,
							Dimension boardDim)
	{
		if (currentPath.length() == incompletePath.length())
		{
			Point finalPos = prevPath.get(prevPath.size());
			Point finishPos = new Point(boardDim.width-1, boardDim.height-1);
			if (finalPos.x == finishPos.x && finalPos.y == finishPos.y)
			{
				return currentPath;
			}
			else
			{
				return "Not Possible";
			}
		}
		else
		{
			String currentChoice = currentPath.substring(currentPath.length()-1);
			if (!currentChoice.equals("?"))
			{
				Point point = this.updateCoordinate(prevPath.get(prevPath.size()-1), 
													currentPath.substring(currentPath.length()-1), 
													boardDim);
				if (point == null)
				{
					return "";
				}
				else
				{
					//Check if new location has been traversed before
					for (Point pt : prevPath)
					{
						if (pt.x == point.x && pt.y == point.y)
						{
							return "";
						}
					}
					
					//If new cell is unique
					prevPath.add(point);
					return findPath(incompletePath,
									currentPath + incompletePath.substring(currentPath.length(), currentPath.length() +1),
									choices,
									prevPath,
									boardDim);
				}
			}
			else	//If current cell is "?"
			{
				List<String> branches = new ArrayList<String>();
				for (String choice : choices)
				{
					branches.add(this.findPath(incompletePath, 
												currentPath.substring(currentPath.length()-1) + choice,
												choices, 
												prevPath, 
												boardDim));
				}
				
				//return the path that exists
				for (String branch : branches)
				{
					if (!branch.equals(""))
					{
						return branch;
					}
				}
				System.out.println("HelloWlrd");
				return "";
			}
		}
	}
	
	public Point updateCoordinate(Point currentCell, String chosenPath, Dimension boardDim)
	{
		Point point;
		//Update to new position
		if (chosenPath.equals("u"))
		{
			point = new Point(currentCell.x, currentCell.y-1);
		}
		else if (chosenPath.equals("l"))
		{
			point = new Point(currentCell.x-1, currentCell.y);
		}
		else if (chosenPath.equals("d"))
		{
			point = new Point(currentCell.x, currentCell.y+1);
		}
		else	//(chosenPath.equals("r"))
		{
			point = new Point(currentCell.x+1, currentCell.y);
		}
		
		//Check if new position exists on the board
		if ((point.x >= 0 && point.x < boardDim.width) && (point.y <= 0 && point.y < boardDim.height))
		{
			return point;
		}
		else
		{
			return null;
		}
	}
	
	public static void main (String argsp[])
	{
		CodingChallenge cc = new CodingChallenge();
		
//		//Challenge 1
//		cc.balanceScale(new String[] {"5, 9", "1, 2, 6, 7"});
//		cc.balanceScale(new String[] {"3, 4", "1, 2, 7, 7"});
//		cc.balanceScale(new String[] {"13, 4", "1, 2, 3, 6, 14"});
//		cc.balanceScale(new String[] {"2, 4", "1, 5, 10"});
		
		//Challenge 2
//		cc.correctPath("???rrurdr?");
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<5; i++)
		{
			list.add(i);
		}
		
		for (int i=0; i<list.size()-2; i++)
		{
			list.remove(0);
		}
		System.out.println(list.get(1));
	}
}