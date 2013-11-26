package org.mytestlab.service;

import java.util.ArrayList;
import java.util.Iterator;
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
		
		Professor newJack = professorRepository.findByUsername("0001");
		
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

		Professor prof = professorRepository.findByUsername(username);
		if (prof == null) { //can't find username
			ret = errorMsg2;
		} else if (!prof.getPassword().equals(password)) { //password doesn't match
			ret = errorMsg3;
		}
		
		return ret;
	}
	
	public String submitSolution(String username, String assignmentName, ArrayList<String> codeStrings, int cyclomaticNumber) {

		String ret = "";
		String solutionName = assignmentName+"_"+username;
		
		Professor prof = professorRepository.findByUsername(username);
		Assignment assign = assignmentRepository.findByName(assignmentName);
		
		if (prof == null) {
			ret = "Professor doesn't exist!";
			return ret;
		}
		
		if (assign == null) {
			assign = new Assignment(assignmentName);
			assignmentRepository.save(assign);
		}

		Solution sol = new Solution(solutionName, prof, assign);
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

		//remove the old solution if it already exists.
		Set<Solution> sols = prof.getSolutions();
		for (Solution so : sols) {
			if (so.getName().equals(sol.getName())) {
				prof.removeSolution(so);
				break;
			}
		}
		prof.addSolution(sol);
		
		assign.setSolution(sol);
		
		professorRepository.save(prof);
		assignmentRepository.save(assign);

		return ret;
	}
	
	public void printSolutions(String username) {
		
		Professor prof = professorRepository.findByUsername(username);

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
