package hengky_oop;

import java.util.ArrayList;
import java.util.List;

public class Student 
{
	private String name, gender, id;
	private List<Score> scores;

	//Constructor
	public Student()
	{
		this.name = "";
		this.gender = "";
		this.id = "";
		this.scores = new ArrayList<Score>();
	}

	//Setters and Getters
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	public List<Score> getScores()
	{
		return this.scores;
	}
	
	//Student scores
	public int getScore(String subjectID)
	{	
		for (Score score : this.scores) 
		{
			if (score.getSubject().getId().equals(subjectID))
			{
				return score.getValue();
			}
		}
		
		return -1;
	}
	
	public void setScore(Score score)
	{
		this.scores.add(score);
	}
}
