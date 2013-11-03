package org.mytestlab.service;

import java.util.ArrayList;

import org.mytestlab.domain.Answer;
import org.mytestlab.domain.Assignment;
import org.mytestlab.domain.Professor;
import org.mytestlab.domain.Solution;
import org.mytestlab.domain.Student;
import org.mytestlab.repository.AnswerRepository;
import org.mytestlab.repository.AssignmentRepository;
import org.mytestlab.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	public String loadTestData() {
		String ret = "";
		System.out.println("hi");
		Student amy = new Student();
		amy.setFirstName("Amy");
		amy.setLastName("Johnson");
		amy.setPassword("111");
		amy.setUsername("0002");
		
		studentRepository.save(amy);
		
		Student newAmy = studentRepository.findByUsername("0002");
		
		ret = "New Amy's name: "+newAmy.getFirstName()+" "+newAmy.getLastName();
		System.out.println(ret);
		
		return ret;
	}
	
	public String getTestData() {
		
		Student newAmy = studentRepository.findByUsername("amy");
		
		String ret = "New Amy's name: "+newAmy.getFirstName()+" "+newAmy.getLastName();
		System.out.println(ret);
		
		return ret;
	}
	
	//Return error string if there is an error.  Return empty string if there is no error.
	public String login(String username, String password) {
		String ret = "";
		String errorMsg = "Incorrect user name and password!";
		
		if (username == null ||
			(username != null && username.isEmpty()) || 
			password == null ||
			(password != null && password.isEmpty())) {
			ret = errorMsg + " 1";
		}
		
		Student stu = studentRepository.findByUsername(username);
		if (stu == null) { //can't find username
			ret = errorMsg;
		} else if (!stu.getPassword().equals(password)) { //password doesn't match
			ret = errorMsg;
		}
		
		return ret;
	}
	
	public String submitAnswer(String username, String assignmentName, ArrayList<String> codeStrings, int cyclomaticNumber) {
		
		
		System.out.println("in StudentService.submitSolution()");
		
		
		String ret = "";
		
		Student stu = studentRepository.findByUsername(username);
		Assignment assign = assignmentRepository.findByName(assignmentName);
		
		if (assign == null) {
			ret = "Assignment doesn't exist!";
			return ret;
		}
		
		if (stu == null) {
			ret = "Student doesn't exist!";
			return ret;
		}
		
		
		
		System.out.println("Assignment Name: "+assign.getName());
		
		
		
		Answer ans = new Answer(stu, assign);
		ans.setCodeStrings(codeStrings);
		ans.setCyclomaticNumber(cyclomaticNumber);
		
		stu.addAnswer(ans);
		assign.addAnswer(ans);
		
		Student stu1 = studentRepository.save(stu);
		assignmentRepository.save(assign);
		
		
		
		System.out.println("FirstName: "+ans.getStudent().getFirstName());
		System.out.println("LastName: "+ans.getStudent().getLastName());
		//System.out.println("Total Points: "+ans.getTotalPoints().toString());
		
		System.out.println("Number of solutions: "+stu.getAnswers().size());
		
		Student stu2 = studentRepository.findByUsername(username);
		System.out.println("Number of saved solutions1: "+stu1.getAnswers().size());
		System.out.println("Number of saved solutions2: "+stu2.getAnswers().size());
		
		
		System.out.println("out StudentService.submitSolution()");
		
		
		
		return ret;
	}
	
	public void printAnswers(String username) {
		
		Student stu = studentRepository.findByUsername(username);

		
		System.out.println("Number of solutions: "+stu.getAnswers().size());
		
		
		for (Answer ans : stu.getAnswers()){
			System.out.println("Assignment Name: "+ans.getAssignment().getName());
			System.out.println("Code String");
			for (int i = 0; i < ans.getCodeStrings().size(); i++) {
				System.out.println(ans.getCodeStrings().get(i));
			}
			System.out.println("Code String Points");
			for (int i = 0; i < ans.getCodeStringsPoints().size(); i++) {
				System.out.println(ans.getCodeStringsPoints().get(i));
			}
			System.out.println("Cyclomatic Number: "+ans.getCyclomaticNumber()+", Points: "+ans.getCyclomaticNumberPoint());
		}
	}
}
