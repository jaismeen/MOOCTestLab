package org.mytestlab.repository;

import org.mytestlab.domain.Student;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface StudentRepository extends GraphRepository<Student> {
	Student findByUsername(String username);
}
