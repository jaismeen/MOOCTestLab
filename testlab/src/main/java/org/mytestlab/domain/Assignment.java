package org.mytestlab.domain;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class Assignment {

	@GraphId
	private Long id;
	
	@Indexed(unique=true)
	private String name;
	
	@RelatedTo(type="HAS_ASSIGNMENTS", direction = Direction.INCOMING)
	private Course course;
	
	@Fetch @RelatedToVia(type = "DO_LAB", direction = Direction.INCOMING)
	private Set<Answer> answers;
	
	@Fetch @RelatedToVia(type = "PROVIDE_SOLUTION", direction = Direction.INCOMING)
	private Solution solution;
	
	private String description;
	private String filePath;
	private CodeType codeType;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public Solution getSolution() {
		return solution;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}
	public CodeType getCodeType() {
		return codeType;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCodeType(CodeType codeType) {
		this.codeType = codeType;
	}
}
