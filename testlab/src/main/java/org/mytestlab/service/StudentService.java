package org.mytestlab.service;

import java.util.ArrayList;

import org.mytestlab.domain.Answer;
import org.mytestlab.domain.Assignment;
import org.mytestlab.domain.Student;
import org.mytestlab.repository.AnswerRepository;
import org.mytestlab.repository.AssignmentRepository;
import org.mytestlab.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
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

		Student stu = new Student();
		stu.setFirstName("Amy");
		stu.setLastName("Johnson");
		stu.setPassword("111");
		stu.setUsername("0002");
		studentRepository.save(stu);
		ret += getStudentInfo("0002");
		
		stu = new Student();
		stu.setFirstName("John");
		stu.setLastName("Don");
		stu.setPassword("111");
		stu.setUsername("0003");
		studentRepository.save(stu);
		ret += getStudentInfo("0003");
		
		stu = new Student();
		stu.setFirstName("Richard");
		stu.setLastName("Lee");
		stu.setPassword("111");
		stu.setUsername("0004");
		studentRepository.save(stu);
		ret += getStudentInfo("0004");
		
		stu = new Student();
		stu.setFirstName("Mary");
		stu.setLastName("Kate");
		stu.setPassword("111");
		stu.setUsername("0005");
		studentRepository.save(stu);
		ret += getStudentInfo("0005");
		
		stu = new Student();
		stu.setFirstName("Sam");
		stu.setLastName("Washington");
		stu.setPassword("111");
		stu.setUsername("0006");
		studentRepository.save(stu);
		ret += getStudentInfo("0006");
		
		stu = new Student();
		stu.setFirstName("Linda");
		stu.setLastName("Wong");
		stu.setPassword("111");
		stu.setUsername("0007");
		studentRepository.save(stu);
		ret += getStudentInfo("0007");
		
		stu = new Student();
		stu.setFirstName("Shawn");
		stu.setLastName("Tran");
		stu.setPassword("111");
		stu.setUsername("0008");
		studentRepository.save(stu);
		ret += getStudentInfo("0008");
		
		stu = new Student();
		stu.setFirstName("Alex");
		stu.setLastName("Patel");
		stu.setPassword("111");
		stu.setUsername("0009");
		studentRepository.save(stu);
		ret += getStudentInfo("0009");
		
		System.out.println(ret);
		return ret;
	}
	
	private String getStudentInfo(String username) {
		Student stu = studentRepository.findByUsername(username);		
		String ret = "Student username: "+stu.getUsername()+", password: "+stu.getPassword()+", name: "+stu.getFirstName()+" "+stu.getLastName()+"\n";
		
		return ret;
	}
	
	public String getTestData() {
		
		Student newAmy = studentRepository.findByUsername("0002");
		
		String ret = "New Amy's name: "+newAmy.getFirstName()+" "+newAmy.getLastName();
		System.out.println(ret);
		
		return ret;
	}
	
	//Return error string if there is an error.  Return empty string if there is no error.
	public String login(String username, String password) {
		String ret = "";
		String errorMsg = "Please enter your Username and Password.";
		String errorMsg2 = "The username doesn't exist.";
		String errorMsg3 = "Wrong password!";
		
		if (username == null ||
			(username != null && username.isEmpty()) || 
			password == null ||
			(password != null && password.isEmpty())) {
			ret = errorMsg;
			return ret;
		}
		
		Student stu = studentRepository.findByUsername(username);
		if (stu == null) { //can't find username
			ret = errorMsg2;
		} else if (!stu.getPassword().equals(password)) { //password doesn't match
			ret = errorMsg3;
		}
		
		return ret;
	}
	
	public String submitAnswer(String username, String assignmentName, ArrayList<String> codeStrings, int cyclomaticNumber) {

		String ret = "";
		String answerName = assignmentName+"_"+username;
		
		Student stu = studentRepository.findByUsername(username);
		Assignment assign = assignmentRepository.findByName(assignmentName);
		Answer ans = null;

		EndResult<Answer> anss = answerRepository.findAll();
		for (Answer an : anss) {
			if (answerName.equals(an.getName())) {
				ans = an;
				break;
			}
		}

		if (stu == null) {
			ret = "Student doesn't exist!";
			return ret;
		}
		
		if (assign == null) {
			ret = "Assignment doesn't exist!";
			return ret;
		}
		
		if (ans == null) {

			ans = new Answer(answerName, stu, assign);
			ans.setCodeStrings(codeStrings);
			ans.setCyclomaticNumber(cyclomaticNumber);
			
			stu.addAnswer(ans);
			assign.addAnswer(ans);
			
			answerRepository.save(ans);
			studentRepository.save(stu);
			assignmentRepository.save(assign);
			
		} else {
			ret = "Resubmission is not allowed.";
		}
		
		return ret;
	}
	
	public void printAnswers(String username) {
		
		Student stu = studentRepository.findByUsername(username);

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
