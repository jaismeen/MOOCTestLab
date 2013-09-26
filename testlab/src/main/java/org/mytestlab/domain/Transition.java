package org.mytestlab.domain;

import org.springframework.data.neo4j.annotation.*;

@RelationshipEntity(type="GOES_TO")
public class Transition {
	
	@GraphId
	private Long id;
	
	@StartNode 
	GenericNode startNode;
	
	@EndNode 
	GenericNode endNode;
	
	@Indexed
	String name;
	
	public Transition() {}
	
	public Transition(String name) {
		this.name = name;
	}
	
	public Transition(String name, GenericNode startNode, GenericNode endNode) {
		this.name = name;
		this.startNode = startNode;
		this.endNode = endNode;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public GenericNode getStartNode() {
		return this.startNode;
	}
	
	public void setStartNode(GenericNode startNode) {
		this.startNode = startNode;
	}
	
	public GenericNode getEndNode() {
		return this.endNode;
	}
	
	public void setEndNode(GenericNode endNode) {
		this.endNode = endNode;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
