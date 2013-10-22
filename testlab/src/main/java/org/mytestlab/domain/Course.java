package org.mytestlab.domain;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Course {

	@GraphId
	private Long id;
	
	@Indexed(unique=true)
	private String name;
	
	@RelatedTo(type="TEACHES_IN", direction = Direction.INCOMING)
	private Professor professor;
	
	@RelatedTo(type="TAKE_COURSE", direction = Direction.INCOMING)
	private Set<Student> students;
	
	@RelatedTo(type="HAS_ASSIGNMENTS", direction = Direction.OUTGOING)
	private Set<Assignment> assignments;
	
	private String description;
	private GradingScale gradingScale;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public GradingScale getGradingScale() {
		return gradingScale;
	}
	public void setGradingScale(GradingScale gradingScale) {
		this.gradingScale = gradingScale;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}
}
