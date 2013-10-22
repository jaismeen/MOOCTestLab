package org.mytestlab.domain;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Transcript {

	@GraphId
	private Long id;
	
	@Fetch @RelatedTo(type = "HAS_TRANSCRIPT", direction = Direction.INCOMING) @Indexed(unique=true)
	private Student student;
	
	private Set<CourseStudentInfo> courses;

	public Set<CourseStudentInfo> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseStudentInfo> courses) {
		this.courses = courses;
	}
	
}

