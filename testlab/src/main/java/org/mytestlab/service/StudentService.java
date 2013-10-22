package org.mytestlab.service;

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
		
		Student amy = new Student();
		amy.setFirstName("Amy");
		amy.setLastName("Johnson");
		amy.setPassword("111");
		amy.setUsername("amy");
		
		studentRepository.save(amy);
		
		Student newAmy = studentRepository.findByUsername("amy");
		
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
}
