package org.mytestlab.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.mytestlab.domain.Transition;

public interface TransitionRepository extends GraphRepository<Transition>{
	Transition findByName(String name);
}
