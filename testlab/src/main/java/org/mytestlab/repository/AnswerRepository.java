package org.mytestlab.repository;

import org.mytestlab.domain.Answer;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface AnswerRepository extends GraphRepository<Answer> {

}
