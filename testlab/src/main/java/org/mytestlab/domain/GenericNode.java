package org.mytestlab.domain;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
//import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@NodeEntity
public class GenericNode {

	@GraphId
	private Long id;
	
	private String description;
	
	@Indexed
	private String name;
	
	//@RelatedTo(type = "GOES_TO", direction = Direction.INCOMING)
	//private Set<GenericNode> incomingNodes;
	
	//@RelatedTo(type = "GOES_TO")
	//private Set<GenericNode> outgoingNodes;
	
	@Fetch @RelatedToVia(type = "GOES_TO", direction = Direction.INCOMING)
	private Set<Transition> incomingRelationships;
	
	@Fetch @RelatedToVia(type = "GOES_TO")
	private Transition outgoingRelationship;
	
	@Fetch @RelatedToVia(type = "GOES_TO")
	private Transition falseTransition;
	
	public GenericNode() {
		incomingRelationships = new HashSet<Transition>();
	}
	
	public GenericNode(String name) {
		this();
		this.name = name;
	}
	
	public GenericNode(String name, String description) {
		this(name);
		this.description = description;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Transition> getIncomingRelationship() {
		return this.incomingRelationships;
	}
	
	public boolean addIncomingRelationship(Transition transition) {
		return this.incomingRelationships.add(transition);
	}
	
	public boolean addIncomingRelationship(Set<Transition> transitions) {
		return this.incomingRelationships.addAll(transitions);
	}
	
	public boolean removeIncomingRelationship(Transition transition) {
		return this.incomingRelationships.remove(transition);
	}
	
	public boolean removeIncomingRelationship(Set<Transition> transitions) {
		return this.incomingRelationships.removeAll(transitions);
	}
	
	public void clearIncomingRelationship() {
		this.incomingRelationships.clear();
	}
	
	public Transition getOutgoingRelationship() {
		return this.outgoingRelationship;
	}
	
	public void setOutgoingRelationship(Transition outgoingRelationship) {
		this.outgoingRelationship = outgoingRelationship;
	}

	public Transition getFalseTransition() {
		return this.falseTransition;
	}
	
	public void setFalseTransition(Transition falseTransition) {
		this.falseTransition = falseTransition;
	}
}
