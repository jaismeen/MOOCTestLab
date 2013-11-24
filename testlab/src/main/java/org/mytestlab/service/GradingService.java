package org.mytestlab.service;

import java.util.ArrayList;
import java.util.Set;

import org.mytestlab.domain.Answer;
import org.mytestlab.domain.Assignment;
import org.mytestlab.domain.Solution;
import org.mytestlab.domain.Student;
import org.mytestlab.repository.AnswerRepository;
import org.mytestlab.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.stereotype.Service;

@Service
public class GradingService {

	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	public String gradeAssignment() {
		String str = "";
		
		
		System.out.println("in gradeAssignment()");
		System.out.println("Number of Assignments: "+assignmentRepository.count());
		
		
		
		EndResult<Assignment> assignments = assignmentRepository.findAll();
				
		for (Assignment assign: assignments) {
			gradeAssignment(assign.getName());
		}
		
		
		System.out.println("out gradeAssignment()");
		
		return str;
	}
	
	public String gradeAssignment(String assignmentName) {
		
		
		System.out.println("Assignment Name: "+assignmentName);
		
		
		String str = "", tmp1 = "", tmp2 = "";
		
		Assignment assign = assignmentRepository.findByName(assignmentName);
		Solution sol = assign.getSolution();
		
		
		System.out.println("Number of Answers: "+assign.getAnswers().size());
		
		
		for (Answer an : assign.getAnswers()) {
			
			System.out.println("Begin grading.");
			
			an.getCodeStringsPoints().clear();
			an.getCodeStringsPoints().add(0.0); //since we are not grading the first 2 lines.
			an.getCodeStringsPoints().add(0.0); //since we are not grading the first 2 lines.
			an.setTotalPoints(0.0);
			
			
			System.out.println("Code String size: "+an.getCodeStrings().size());
			
			
			for (int i = 2; i < an.getCodeStrings().size(); i++) {
				tmp1 = an.getCodeStrings().get(i).replaceAll("\\s+", "");
				
				
				
				System.out.println("Code String answer: "+tmp1);
				
				
				
				if (i < sol.getCodeStrings().size()) { 
					tmp2 = sol.getCodeStrings().get(i).replaceAll("\\s+", "");
					
					
					System.out.println("Code String solution: "+tmp2);
					
					
					if (tmp1.equals(tmp2)) {
						
						
						System.out.println("Code String answer equals solution.");
						
						
						an.getCodeStringsPoints().add(i, sol.getCodeStringsPoints().get(i));
						
						
						System.out.println("update points for code string line.");
						
						//an.setTotalPoints(an.getTotalPoints()+sol.getCodeStringsPoints().get(i));
						an.setTotalPoints(an.getTotalPoints()+an.getCodeStringsPoints().get(i));
						
						
						System.out.println("update total points");
						
					} else {
						an.getCodeStringsPoints().add(i, 0.0);
						
						System.out.println("update code string line points to 0");
						
					}
				} else {
					break; //break out of the loop
				}
				
				System.out.println("Total Points: "+an.getTotalPoints());
			}
			
			System.out.println("Code String grading done.");
			
			if (an.getCyclomaticNumber() == sol.getCyclomaticNumber()) {
				an.setCyclomaticNumberPoint(sol.getCyclomaticNumberPoint());
				an.setTotalPoints(an.getTotalPoints()+an.getCyclomaticNumberPoint());
			} else {
				an.setCyclomaticNumberPoint(0.0);
			}
			
			answerRepository.save(an);
		}
		
		//check total points
		for (Answer an2 : assign.getAnswers()) {
			System.out.println("Total Points2: "+an2.getTotalPoints());
		}
		
		//assignmentRepository.delete(assign);
		//Assignment assign3 = assignmentRepository.save(assign);
		
		
		//check total points
		//for (Answer an3 : assign3.getAnswers()) {
		//	System.out.println("Total Points3: "+an3.getTotalPoints());
		//}
		
		
		return str;
	}
	
	public String displayAllGrades() {
		String str = "";
		
		EndResult<Assignment> assignments = assignmentRepository.findAll();
		for (Assignment assign: assignments) {
			str = displayGrades(assign.getName(), str);
		}
		
		return str;
	}
	
	public String displayGrades(String assignmentName, String str) {
		Student stu;
		String delimiter = ";";
		
		Assignment assign = assignmentRepository.findByName(assignmentName);
		
		if (assign.getAnswers().size() > 0) { //There are answers to the assignment
		
			str+=assignmentName+delimiter;
			
			
			System.out.println("Assignment Name: "+str);
			
			
			for (Answer ans : assign.getAnswers()) {
				stu = ans.getStudent();
				
				System.out.println("Going through Assignment: "+str);
				
				if (stu == null) {
					System.out.println("Student = null");
				} else {
					System.out.println("Student is not null");
				}
				
				System.out.println("FirstName: "+stu.getFirstName());
				System.out.println("LastName: "+stu.getLastName());
				
				if (ans.getTotalPoints() == null) {
					System.out.println("TotalPoints = "+ans.getTotalPoints());
				} else {
					System.out.println("TotalPoints is not null");
				}
				
				System.out.println("Total Points: "+ans.getTotalPoints().toString());
				
				
				str+=stu.getFirstName()+delimiter+stu.getLastName()+delimiter+ans.getTotalPoints().toString()+delimiter;
			}
		} else {
			//no answers to this assignment
		}
		return str;
	}
	
	public Double gradePractice(String assignmentName, ArrayList<String> codeStrArr, int cyclomaticNumber) {
		String tmp1 = "", tmp2 = "";
		Double totalPoints = 0.0;
		
		Assignment assign = assignmentRepository.findByName(assignmentName);
		Solution sol = assign.getSolution();
		
		for (int i = 2; i < codeStrArr.size(); i++) {
			tmp1 = codeStrArr.get(i).replaceAll("\\s+", "");
			if (i < sol.getCodeStrings().size()) { 
				tmp2 = sol.getCodeStrings().get(i).replaceAll("\\s+", "");
				if (tmp1.equals(tmp2)) {
					totalPoints += sol.getCodeStringsPoints().get(i);
				} else {
					//no points added
				}
			} else {
				break; //break out of the loop
			}
		}
		if (cyclomaticNumber == sol.getCyclomaticNumber()) {
			totalPoints += sol.getCyclomaticNumberPoint();
		} else {
			//no points added
		}
		
		return totalPoints;
	}
}
