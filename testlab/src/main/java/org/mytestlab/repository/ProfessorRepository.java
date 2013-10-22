package org.mytestlab.repository;

import org.mytestlab.domain.Professor;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface ProfessorRepository extends GraphRepository<Professor> {
	Professor findByUsername(String username);
}
