package org.mytestlab.service;

import java.util.ArrayList;
import java.util.Random;

import org.mytestlab.domain.Assignment;
import org.mytestlab.domain.CodeType;
import org.mytestlab.domain.Course;
import org.mytestlab.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public String getRandomAssignment(String courseName, CodeType type){
		String str = "";
		ArrayList<Assignment> arr = new ArrayList<Assignment>();
		Random rand = new Random();
		
		Course cou = courseRepository.findByName(courseName);
		for (Assignment assign : cou.getAssignments()) {
			if (assign.getCodeType()==type) {
				arr.add(assign);
			}
		}
		
		if (arr.size() > 0) {
			int r = rand.nextInt(arr.size());
			str = arr.get(r).getName();
		}
		
		return str;
	}
}
