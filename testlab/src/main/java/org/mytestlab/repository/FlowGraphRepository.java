package org.mytestlab.repository;

import org.mytestlab.domain.FlowGraph;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface FlowGraphRepository extends GraphRepository<FlowGraph> {
	FlowGraph findByName(String name);
}
