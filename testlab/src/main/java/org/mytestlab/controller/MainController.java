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
		
		if (type == PROFESSOR) { //professor
			str = professorService.login(username, password);
		} else if (type == STUDENT) { //student
			str = studentService.login(username, password);
		} else { //unknown type
			
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
		
		
		System.out.println("in MainController.submitSolution()");
		
		
		String str = "";
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
//<<<<<<< HEAD

//=======
		
		
		
		System.out.println("out MainController.submitSolution()");
		
		
//>>>>>>> 11aff0cdb9d43bf70d250b78c69112646651b10c
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
		ArrayList<String> arr = new ArrayList<String>();
		
		String[] strs = codestr.split("\n");
		for(int i = 0; i < strs.length; i++) {
			arr.add(strs[i]);
		}
		
		str = Double.toString(gradingService.gradePractice(assignmentName, arr, cyclomaticNumber));
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
		
		if (type == PROFESSOR) {
			str = professorService.loadTestData();
		} else if (type == STUDENT){
			str = studentService.loadTestData();
		} else { //unknown
			
		}
		
		return str;
	}
	
	@RequestMapping(value="/getTestData")
	public @ResponseBody String getTestData(
			@RequestParam int type) {
		
		String str = "";
		
		if (type == PROFESSOR) {
			str = professorService.getTestData();
		} else if (type == STUDENT){
			str = studentService.getTestData();
		} else { //unknown
			
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
		
		return str;
	}
	
	/*
	@Autowired
	private GenericNodeService service;
	
	@Autowired
	private FlowgraphService flowGraphService;
	
	@RequestMapping
	public String getMainPage() {
		return "main";
	}
	
	@RequestMapping(value="/records")
	public @ResponseBody GenericNodeListDto getNodes() {
		
		GenericNodeListDto nodeListDto = new GenericNodeListDto();
		nodeListDto.setNodes(GenericNodeMapper.map(service.readAll()));
		return nodeListDto;
	}
	
	@RequestMapping(value="/get")
	public @ResponseBody GenericNode get(@RequestBody GenericNode node) {
		return service.read(node);
	}*/

	/*static int tmpName = 1;
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody ArrayList<String> create(
			@RequestParam String codestr) {

		System.out.println("In create()");
		
		FlowGraph fg = new FlowGraph();
		
		//fg.setName(Integer.toString(tmpName));
		//tmpName++;
		
		fg.setName(Long.toString(System.currentTimeMillis()));
		
		
		System.out.println("String from javascript");
		
		String[] strs = codestr.split("\n");
		for(int i = 0; i < strs.length; i++) {
			fg.addCodeString(strs[i]);
			
			System.out.println(strs[i]);
			
		}
		
		flowGraphService.create(fg);
		
		FlowGraph fg2 = flowGraphService.read(fg.getName());
		
		System.out.println("String from database");
		
		//for (String str: fg2.getCodeStrings()) {
			//System.out.println(str);
		//}
		
		for(int i = 0; i < fg2.getCodeStrings().size(); i++) {	
			System.out.println(fg2.getCodeStrings().get(i));
		}
		
		System.out.println("Out create()");
		
		
		return fg2.getCodeStrings();
	}
	/*
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody GenericNodeDto create(
			@RequestParam String name,
			@RequestParam String description,
			@RequestParam Integer type) {

		GenericNode newNode;
		Transition newTransition = new Transition("tmpTransition");
		
		if(type==1) {
			newNode = new ConditionNode(name, description);
			
			System.out.println("Create condition node");
			
		} else {
			newNode = new GenericNode(name, description);
		}
		
		newNode.setOutgoingRelationship(newTransition);
		
		
		//System.out.println("Add incoming relationship");
		
		//Transition newTransition2 = new Transition("test2"+name);	
		//newNode.addIncomingRelationship(newTransition2);
		
		//System.out.println("Added incoming relationship");
		
		//newNode.setTest("test"+description);
		
		
		System.out.println("Create node in service");
		
		
		return GenericNodeMapper.map(service.create(newNode));
	}	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody GenericNodeDto update(
			@RequestParam String name,
			@RequestParam String description,
			@RequestParam String transitionName) {

		Transition newTransition = new Transition(transitionName);
		
		GenericNode existingNode = new GenericNode(name, description);
		existingNode.setOutgoingRelationship(newTransition);
		
		return GenericNodeMapper.map(service.update(existingNode));
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Boolean delete(
			@RequestParam String name) {

		GenericNode existingNode = new GenericNode();
		existingNode.setName(name);
		
		return service.delete(existingNode);
	}
	*/
}
