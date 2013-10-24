package org.mytestlab.service;

import java.util.ArrayList;

import org.mytestlab.domain.Assignment;
import org.mytestlab.domain.Professor;
import org.mytestlab.domain.Solution;
import org.mytestlab.repository.AssignmentRepository;
import org.mytestlab.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	public String loadTestData() {
		String ret = "";
		
		Professor jack = new Professor();
		jack.setFirstName("Jack");
		jack.setLastName("Smith");
		jack.setPassword("111");
		jack.setUsername("0001");
		
		professorRepository.save(jack);
		
		Professor newJack = professorRepository.findByUsername("jack");
		
		ret = "New Jack's name: "+newJack.getFirstName()+" "+newJack.getLastName();
		System.out.println(ret);
		
		return ret;
	}
	
	public String getTestData() {
		
		Professor newJack = professorRepository.findByUsername("jack");
		
		String ret = "New Jack's name: "+newJack.getFirstName()+" "+newJack.getLastName();
		System.out.println(ret);
		
		return ret;
	}
	
	/*
	public String loadAssignment() {
		
		Assignment assign = new Assignment();
		
	}*/
	
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
		
		
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		
		
		Professor prof = professorRepository.findByUsername(username);
		if (prof == null) { //can't find username
			ret = errorMsg;
		} else if (!prof.getPassword().equals(password)) { //password doesn't match
			ret = errorMsg;
		}
		
		return ret;
	}
	
	public String submitSolution(String username, String assignmentName, ArrayList<String> codeStrings, int cyclomaticNumber) {
		String ret = "";
		
		Professor prof = professorRepository.findByUsername(username);
		Assignment assign = assignmentRepository.findByName(assignmentName);
		
		if (assign == null) {
			ret = "Assignment doesn't exist!";
			return ret;
		}
		
		if (prof == null) {
			ret = "Professor doesn't exist!";
			return ret;
		}
		
		Solution sol = new Solution(prof, assign);
		sol.setCodeStrings(codeStrings);
		sol.setCyclomaticNumber(cyclomaticNumber);
		
		//points
		ArrayList<Double> pts = new ArrayList<Double>();
		double pt = 90 / (codeStrings.size() - 2); //substract the default start and end node.
		for (int i = 0; i < codeStrings.size(); i++) {
			if (i < 2) {
				pts.add(0.0);
			} else {
				pts.add(pt);
			}
		}
		sol.setCodeStringsPoints(pts);		
		sol.setCyclomaticNumberPoint(10);
		
		prof.addSolution(sol);
		assign.setSolution(sol);
		
		professorRepository.save(prof);
		assignmentRepository.save(assign);
		
		return ret;
	}
	
}
