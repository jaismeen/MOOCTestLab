package org.mytestlab.service;

import java.util.ArrayList;

import org.mytestlab.domain.Answer;
import org.mytestlab.domain.Assignment;
import org.mytestlab.domain.Professor;
import org.mytestlab.domain.Solution;
import org.mytestlab.domain.Student;
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
		
		Answer ans = new Answer(stu, assign);
		ans.setCodeStrings(codeStrings);
		ans.setCyclomaticNumber(cyclomaticNumber);
		
		stu.addAnswer(ans);
		assign.addAnswer(ans);
		
		studentRepository.save(stu);
		assignmentRepository.save(assign);
		
		return ret;
	}
}
