package org.mytestlab.controller;

import java.util.ArrayList;
import java.util.Set;

import org.mytestlab.domain.ConditionNode;
import org.mytestlab.domain.FlowGraph;
import org.mytestlab.domain.GenericNode;
import org.mytestlab.domain.Professor;
import org.mytestlab.domain.Transition;
import org.mytestlab.dto.GenericNodeDto;
import org.mytestlab.dto.GenericNodeListDto;
import org.mytestlab.dto.GenericNodeMapper;
import org.mytestlab.service.FlowgraphService;
import org.mytestlab.service.GenericNodeService;
import org.mytestlab.service.GradingService;
import org.mytestlab.service.ProfessorService;
import org.mytestlab.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/main")
public class MainController {

	//@Autowired
	//private FlowgraphService flowGraphService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private GradingService gradingService;
	
	@RequestMapping(value = "/main", method= RequestMethod.GET)
    public String main() {
         
        return "main";
    }
	@RequestMapping(value = "/StudentLogin", method= RequestMethod.GET)
    public String StudentLogin() {
         
        return "StudentLogin";
    }
   
	@RequestMapping(value = "/HomeProfessor", method= RequestMethod.GET)
    public String HomeProfessor() {
         
        return "HomeProfessor";
    }
   
	@RequestMapping(value = "/PracticeList", method= RequestMethod.GET)
    public String PracticeList() {
         
        return "PracticeList";
    }
	@RequestMapping(value = "/Practice", method= RequestMethod.GET)
    public String Practice() {
         
        return "Practice";
    }
	@RequestMapping(value = "/HomeStudent", method= RequestMethod.GET)
    public String HomeStudent() {
         
        return "HomeStudent";
    }
	@RequestMapping(value = "/ProfessorLogin", method= RequestMethod.GET)
    public String ProfessorLogin() {
         
        return "ProfessorLogin";
    }
	@RequestMapping(value = "/SetupLab", method= RequestMethod.GET)
    public String SetupLab() {
         
        return "SetupLab";
    }
	@RequestMapping(value = "/Grading", method= RequestMethod.GET)
    public String Grading() {
         
        return "Grading";
    }
	@RequestMapping(value = "/FlowChart", method= RequestMethod.GET)
    public String FlowChart() {
         
        return "FlowChart";
    }
	final int PROFESSOR = 0;
	final int STUDENT = 1;

	
	
	/*@RequestMapping
	public String MainPage() {
		return "main";
	}
	/*@RequestMapping(value="/StudentLogin")
	public String StudentLogin()
	{	
		return "StudentLogin";
	}*/
	
	@RequestMapping(value="/login")
	public @ResponseBody String login(
			@RequestParam String username, 
			@RequestParam String password, 
			@RequestParam int type) {
		
		String str = "";
		
		try {
			if (type == PROFESSOR) { //professor
				str = professorService.login(username, password);
			} else if (type == STUDENT) { //student
				str = studentService.login(username, password);
			} else { //unknown type
				
			}
		} catch (Exception ex) {
			str = ex.toString();
		}
		
		return str;
	}
	
	@RequestMapping(value="/submitSolution")
	public @ResponseBody String submitSolution(
			@RequestParam String username,
			@RequestParam int type,
			@RequestParam String assignmentName, 
			@RequestParam String codeStrings,
			@RequestParam int cyclomaticNumber
			)
			 {

		String str = "";
		
		try {
			ArrayList<String> arr = new ArrayList<String>();
			
			String[] strs = codeStrings.split("\n");
			for(int i = 0; i < strs.length; i++) {
				arr.add(strs[i]);
			}
			
			if (type == PROFESSOR) {
				str = professorService.submitSolution(username, assignmentName, arr, cyclomaticNumber);
			} else if (type == STUDENT){
				str = studentService.submitAnswer(username, assignmentName, arr, cyclomaticNumber);
			} else {
				
			}
		} catch (Exception ex) {
			str = ex.toString();
		}
		
		return str;
	}
	
	@RequestMapping(value="/grading")
	public @ResponseBody String grading() {

		String str = "";
		try {
		
			str = gradingService.gradeAssignment();
		
		} catch (Exception ex) {
			str = ex.toString();
		}
		return str;
	}
		
	@RequestMapping(value="/gradePractice")
	public @ResponseBody String gradePractice(
			@RequestParam String assignmentName,
			@RequestParam String codestr,
			@RequestParam int cyclomaticNumber) {
	
		String str = "";
		try {
			ArrayList<String> arr = new ArrayList<String>();
			
			String[] strs = codestr.split("\n");
			for(int i = 0; i < strs.length; i++) {
				arr.add(strs[i]);
			}
			
			Double score = gradingService.gradePractice(assignmentName, arr, cyclomaticNumber);
			if (score >= 0.0) {
				str = Double.toString(score);
			} else {
				str = "Not Available.";
			}
		
		} catch (Exception ex) {
			str = ex.toString();
		}
		return str;
	}
	
	@RequestMapping(value="/displayAll")
	public @ResponseBody String displayAll() {
	
		String str = "";
		try {
		
			str = gradingService.displayAllGrades();
		
		} catch (Exception ex) {
			str = ex.toString();
		}
		return str;
	}
	
	@RequestMapping(value="/printProfessorSolutions")
	public @ResponseBody String printProfessorSolutions(
			@RequestParam String username) {
		String str = "";
		try {
			
			System.out.println("Professor's username: "+username);
			
			professorService.printSolutions(username);
			
		} catch (Exception ex) {
			str = ex.toString();
		}
		return str;
	}
	
	@RequestMapping(value="/printStudentAnswers")
	public @ResponseBody String printStudentAnswers(
			@RequestParam String username) {
		String str = "";
		try {
			
			System.out.println("Student's username: "+username);
			
			studentService.printAnswers(username);
			
		} catch (Exception ex) {
			str = ex.toString();
		}
		return str;
	}
	
	@RequestMapping(value="/loadTestData")
	public @ResponseBody String loadTestData(
			@RequestParam int type) {
		
		String str = "";
		try {
			if (type == PROFESSOR) {
				str = professorService.loadTestData();
			} else if (type == STUDENT){
				str = studentService.loadTestData();
			} else { //unknown
				
			}
		} catch (Exception ex) {
			str = ex.toString();
		}
		return str;
	}
	
	@RequestMapping(value="/getTestData")
	public @ResponseBody String getTestData(
			@RequestParam int type) {
		
		String str = "";
		try {
			if (type == PROFESSOR) {
				str = professorService.getTestData();
			} else if (type == STUDENT){
				str = studentService.getTestData();
			} else { //unknown
				
			}
		} catch (Exception ex) {
			str = ex.toString();
		}
		return str;
	}
	
	@RequestMapping(value="/addUser")
	public @ResponseBody String addUser(
			@RequestParam String lastname, 
			@RequestParam String firstname, 
			@RequestParam String username, 
			@RequestParam String password, 
			@RequestParam int type) {
		
		String str = "";
		try {
			if (type == PROFESSOR) { //professor
				// Create new records
				Professor newProf = new Professor();
				newProf.setFirstName(firstname);
				newProf.setLastName(lastname);
				newProf.setPassword(password);
				newProf.setUsername(username);
				
				//professorRepository.save(jack);
			} else if (type == STUDENT) { //student
				
			} else { //unknown type
				
			}
		} catch (Exception ex) {
			str = ex.toString();
		}
		return str;
	}

}
