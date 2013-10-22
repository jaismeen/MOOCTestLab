package org.mytestlab.test;

import org.mytestlab.domain.Professor;
import org.mytestlab.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LoadTestData {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public void init() {
		
		Professor oldJack = professorRepository.findByUsername("jack");
		
		System.out.println("Old Jack's name: "+oldJack.getFirstName()+" "+oldJack.getLastName());
		
		if (oldJack != null) {
			//professorRepository.delete(oldJack);
		}

		// Create new records
		Professor jack = new Professor();
		jack.setFirstName("Jack");
		jack.setLastName("Smith");
		jack.setPassword("111");
		jack.setUsername("jack");
		
		professorRepository.save(jack);
		
		Professor newJack = professorRepository.findByUsername("jack");
		
		System.out.println("New Jack's name: "+newJack.getFirstName()+" "+newJack.getLastName());
		
		/*User john = new User();
		john.setFirstName("John");
		john.setLastName("Smith");
		john.setPassword("21232f297a57a5a743894a0e4a801fc3");
		john.setRole(new Role(1));
		john.setUsername("john");
		
		User jane = new User();
		jane.setFirstName("Jane");
		jane.setLastName("Adams");
		jane.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
		jane.setRole(new Role(2));
		jane.setUsername("jane");
		
		john.getRole().setUser(john);
		jane.getRole().setUser(jane);

		userRepository.save(john);
		userRepository.save(jane);
		
		userRepository.findByUsername("john").getRole().getRole();
		*/
	}
}
