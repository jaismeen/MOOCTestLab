package org.mytestlab.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import org.mytestlab.domain.GenericNode;

public interface GenericNodeRepository extends GraphRepository<GenericNode> {
	GenericNode findByName(String name);
}
