package org.mytestlab.service;

import org.mytestlab.domain.Answer;
import org.mytestlab.domain.Assignment;
import org.mytestlab.domain.Solution;
import org.mytestlab.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradingService {

	@Autowired
	private AssignmentRepository assignmentRepository;
	
	public String gradeAssignment(String assignmentName) {
		String str = "", tmp1 = "", tmp2 = "";
		
		Assignment assign = assignmentRepository.findByName(assignmentName);
		Solution sol = assign.getSolution();
		
		for (Answer an : assign.getAnswers()) {
			an.getCodeStringsPoints().clear();
			an.setTotalPoints(0.0);
			for (int i = 0; i < an.getCodeStrings().size(); i++) {
				tmp1 = an.getCodeStrings().get(i).replaceAll("\\s+", "");
				tmp2 = sol.getCodeStrings().get(i).replaceAll("\\s+", "");
				if (tmp1.equals(tmp2)) {
					an.getCodeStringsPoints().add(i, sol.getCodeStringsPoints().get(i));
					an.setTotalPoints(an.getTotalPoints()+an.getCodeStringsPoints().get(i));
				} else {
					an.getCodeStringsPoints().add(i, 0.0);
				}
			}
			if (an.getCyclomaticNumber() == sol.getCyclomaticNumber()) {
				an.setCyclomaticNumberPoint(sol.getCyclomaticNumberPoint());
			} else {
				an.setCyclomaticNumberPoint(0.0);
			}
		}
		
		assignmentRepository.save(assign);
		
		return str;
	}
}
