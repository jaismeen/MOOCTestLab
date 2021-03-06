package org.mytestlab.service;

import java.util.ArrayList;

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

		EndResult<Assignment> assignments = assignmentRepository.findAll();
				
		for (Assignment assign: assignments) {
			gradeAssignment(assign.getName());
		}

		return str;
	}
	
	public String gradeAssignment(String assignmentName) {

		String str = "", tmp1 = "", tmp2 = "";
		
		Assignment assign = assignmentRepository.findByName(assignmentName);
		Solution sol = assign.getSolution();

		for (Answer an : assign.getAnswers()) {

			an.getCodeStringsPoints().clear();
			an.getCodeStringsPoints().add(0.0); //since we are not grading the first 2 lines.
			an.getCodeStringsPoints().add(0.0); //since we are not grading the first 2 lines.
			an.setTotalPoints(0.0);

			for (int i = 2; i < an.getCodeStrings().size(); i++) {
				tmp1 = an.getCodeStrings().get(i).replaceAll("\\s+", "");

				if (i < sol.getCodeStrings().size()) { 
					tmp2 = sol.getCodeStrings().get(i).replaceAll("\\s+", "");

					if (tmp1.equals(tmp2)) {

						an.getCodeStringsPoints().add(i, sol.getCodeStringsPoints().get(i));
						an.setTotalPoints(an.getTotalPoints()+an.getCodeStringsPoints().get(i));

					} else {
						an.getCodeStringsPoints().add(i, 0.0);
					}
				} else {
					break; //break out of the loop
				}

			}

			if (an.getCyclomaticNumber() == sol.getCyclomaticNumber()) {
				an.setCyclomaticNumberPoint(sol.getCyclomaticNumberPoint());
				an.setTotalPoints(an.getTotalPoints()+an.getCyclomaticNumberPoint());
			} else {
				an.setCyclomaticNumberPoint(0.0);
			}
			
			answerRepository.save(an);
		}

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

			for (Answer ans : assign.getAnswers()) {
				stu = ans.getStudent();
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
		if (assign == null) {
			totalPoints = -1.0;
			return totalPoints;
		}
		
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
