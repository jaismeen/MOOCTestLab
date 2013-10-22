package org.mytestlab.repository;

import org.mytestlab.domain.Course;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface CourseRepository extends GraphRepository<Course>{
	Course findByName(String name);
}
