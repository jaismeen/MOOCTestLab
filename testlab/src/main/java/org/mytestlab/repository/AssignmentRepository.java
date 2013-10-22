package org.mytestlab.repository;

import org.mytestlab.domain.Assignment;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface AssignmentRepository extends GraphRepository<Assignment> {
	Assignment findByName(String name);
}
