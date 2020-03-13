package hengky_oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main 
{
	//Fields
	private List<Subject> subjects;
	private List<Student> students;
	
	//Constructor
	public Main()
	{
		this.subjects = new ArrayList<Subject>();
		this.students = new ArrayList<Student>();
	}
	
	//Show Main Menu
	public void displayMainMenu(Scanner sc)
	{
		while(true)
		{
			Methods.printLine("Bee School");
			Methods.printLine("==========================");
			Methods.printLine("1. Insert New Subject");
			Methods.printLine("2. View All Subject");
			Methods.printLine("3. Insert New Students");
			Methods.printLine("4. View All Students");
			Methods.printLine("5. Insert Student Score");
			Methods.printLine("6. View Student Score");
			Methods.printLine("7. Exit");
			Methods.print("Choose menu: ");
			int response = sc.nextInt();
			sc.nextLine();
			switch(response)
			{
				case 1:
					this.insertNewSubject(sc);
					break;
					
				case 2:
					this.viewAllSubject();
					break;
					
				case 3:
					this.insertNewStudent(sc);
					break;
					
				case 4:
					this.viewAllStudent();
					break;
					
				case 5:
					this.insertStudentScore(sc);
					break;
					
				case 6:
					this.viewStudentScore();
					break;
					
				case 7:
					System.exit(0);
					break;
					
				default:
					continue;
			}
		}
	}
	public void insertNewSubject(Scanner sc)
	{
		Subject subject = new Subject();
		String response;
		//Enter name
		checkName:
		while(true)
		{
			Methods.print("Input subject name [3-25 characters | ends with ' Subject']: ");
			response = sc.nextLine();
			int subjectIndex = response.indexOf(" Subject");
			if (subjectIndex != -1 && response.substring(0, subjectIndex).length() >= 3 && response.substring(0, subjectIndex).length() <= 25)
			{
				//Check if unique
				for (Subject sub : this.subjects)
				{
					if (sub.getName().equals(response))
					{
						Methods.printLine("Subject already exists!");
						continue checkName;
					}
				}
				subject.setName(response);
				break;
			}
		}
		
		//Enter category
		while(true)
		{
			Methods.print("Input subject category [Main | Elective]: ");
			response = sc.nextLine();
			if (response.equalsIgnoreCase("Main") || response.equalsIgnoreCase("Elective"))
			{
				subject.setCategory(response);
				break;
			}
		}
		
		//Insert ID
		subject.setId(this.generateID("SB", this.subjects));
		
		//Add to list
		this.subjects.add(subject);
		
		Methods.printLine();
		Methods.printLine("Success insert new subject!");
	}
	public void viewAllSubject()
	{
		if (this.subjects.size()==0)
		{
			Methods.printLine("No Data!");
		}
		else
		{
			Methods.printLine("Subject ID	Subject Name			Subject Category");
			Methods.printLine("=================================================================");
			for (Subject subject : this.subjects)
			{
				Methods.printLine(subject.getId() + "		" + subject.getName() + "			" + subject.getCategory());
			}
			Methods.printLine("=================================================================");
		}
	}
	public void insertNewStudent(Scanner sc)
	{
		Student student = new Student();
		String response;
		
		//Insert name
		while(true)
		{
			Methods.print("Input student name [3-25 characters]: ");
			response = sc.nextLine();
			if (response.length() >= 3 && response.length() <= 25)
			{
				student.setName(response);
				break;
			}
		}
		
		//Insert gender
		while(true)
		{
			Methods.print("Input student gender [Male | Female]: ");
			response = sc.nextLine();
			if (response.equalsIgnoreCase("Male") || response.equalsIgnoreCase("Female"))
			{
				student.setGender(response);
				break;
			}
		}
		
		//Insert ID:
		student.setId(this.generateID("ST", this.students));
		
		//Add to list
		this.students.add(student);

		Methods.printLine();
		Methods.printLine("Success insert new student!");
	}
	public void viewAllStudent()
	{
		if (this.students.size()==0)
		{
			Methods.printLine("No Data!");
		}
		else
		{
			Methods.printLine("Student ID	Student Name			Student Gender");
			Methods.printLine("=================================================================");
			for (Student student : this.students)
			{
				Methods.printLine(student.getId() + "		" + student.getName() + "			" + student.getGender());
			}
			Methods.printLine("=================================================================");
		}
	}
	public void insertStudentScore(Scanner sc)
	{
		if (this.students.size() != 0 && this.subjects.size() != 0)
		{
			Methods.printLine("Student Data:");
			this.viewAllStudent();
			Methods.printLine("Subject Data:");
			this.viewAllSubject();
			String response;
			
			//Enter student id
			Student student;
			studentID:
			while(true)
			{
				Methods.print("Enter student id: ");
				response = sc.nextLine();
				
				//Check if ID exists
				for (Student std : this.students)
				{
					if (response.equals(std.getId()))
					{
						student = std;
						break studentID;
					}
				}
			}
			
			//Enter subject ID
			Subject subject = null;
			while (true)
			{
				Methods.print("Enter subject id: ");
				String subjectID  = sc.nextLine();
				
				//Check if ID exists
				boolean exists = false;
				for (Subject sbj : this.subjects)
				{
					if (sbj.getId().equals(subjectID))
					{
						subject = sbj;
						exists = true;
						break;
					}
				}
				if (exists)
				{
					//Check if subject already has a score
					if (student.getScore(subjectID) != -1)
					{
						Methods.printLine("Subject score already inserted!");
					}
					else
					{
						break;
					}
				}
			}
			
			//Enter score
			Score score = new Score();
			score.setSubject(subject);
			while(true)
			{
				Methods.print("Input score [0-100]: ");
				response = sc.nextLine();
				int inputtedScore = Integer.parseInt(response);
				if (inputtedScore >= 0 && inputtedScore <= 100)
				{
					score.setValue(inputtedScore);
					break;
				}
			}
			
			//Generate score id
			score.setId(this.generateID("SC", student.getScores()));
			
			//Save score
			student.setScore(score);
			
			Methods.printLine("Success inset student score!");
		}
		else
		{
			Methods.printLine("Student and Subject data must exists!");
		}
	}
	public void viewStudentScore()
	{
		for (Student student : this.students)
		{
			Methods.printLine("Student ID	Student Name			Student Gender");
			Methods.printLine("=================================================================");
			Methods.printLine(student.getId() + "		" + student.getName() + "			" + student.getGender());
			Methods.printLine();
			Methods.printLine("Scores: ");
			Methods.printLine("-----------------------------------------------------------------");
			if (student.getScores().size() == 0)
			{
				Methods.printLine("No Data");
			}
			else
			{
				for (Score score : student.getScores())
				{
					Methods.printLine(score.getId() + "		" + score.getSubject().getName() + "			" + Integer.toString(score.getValue()));
				}
			}
			Methods.printLine("=================================================================");
		}
	}
	
	public String generateID(String suffix, List<?> list)
	{
		String num = Integer.toString(list.size() + 1);
		if (num.length() < 3)
		{
			int length = num.length();
			for (int i=0; i<3-length; i++)
			{
				num = "0" + num;
			}
		}
		return suffix + num;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		main.displayMainMenu(sc);
	}
}
