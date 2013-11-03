package org.mytestlab.service;

import java.util.ArrayList;
import java.util.Set;

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
		
		Professor newJack = professorRepository.findByUsername("0001");
		
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
		
		
		System.out.println("in ProfessorService.submitSolution()");
		
		
		String ret = "";
		
		Professor prof = professorRepository.findByUsername(username);
		Assignment assign = assignmentRepository.findByName(assignmentName);
		
		if (assign == null) {
			assign = new Assignment(assignmentName);
			assignmentRepository.save(assign);
		}
		
		if (prof == null) {
			ret = "Professor doesn't exist!";
			return ret;
		}

		
		System.out.println("Assignment Name: "+assign.getName());
		
		
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
		
		Professor prof1 = professorRepository.save(prof);
		assignmentRepository.save(assign);
		
		
		System.out.println("Number of solutions: "+prof.getSolutions().size());
		
		Professor prof2 = professorRepository.findByUsername(username);
		System.out.println("Number of saved solutions1: "+prof1.getSolutions().size());
		System.out.println("Number of saved solutions2: "+prof2.getSolutions().size());
		
		
		System.out.println("out ProfessorService.submitSolution()");
		
		return ret;
	}
	
	public void printSolutions(String username) {
		
		Professor prof = professorRepository.findByUsername(username);

		
		System.out.println("Number of solutions: "+prof.getSolutions().size());
		
		
		for (Solution sol : prof.getSolutions()){
			System.out.println("Assignment Name: "+sol.getAssignment().getName());
			System.out.println("Code String");
			for (int i = 0; i < sol.getCodeStrings().size(); i++) {
				System.out.println(sol.getCodeStrings().get(i));
			}
			System.out.println("Code String Points");
			for (int i = 0; i < sol.getCodeStringsPoints().size(); i++) {
				System.out.println(sol.getCodeStringsPoints().get(i));
			}
			System.out.println("Cyclomatic Number: "+sol.getCyclomaticNumber()+", Points: "+sol.getCyclomaticNumberPoint());
		}
	}
	
}
