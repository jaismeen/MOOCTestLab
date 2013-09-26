package org.mytestlab.dto;

import java.io.Serializable;
import java.util.List;

import org.mytestlab.domain.Transition;

public class GenericNodeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String description;
	private String name;
	//private Set<String> incomingNodes;
	//private Set<GenericNode> outgoingNodes;
	private List<String> incomingRelationships;
	private String outgoingRelationship;
	
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
	
	public List<String> getIncomingRelationships() {
		return this.incomingRelationships;
	}

	public void setIncomingRelationships(List<String> incomingRelationships) {
		this.incomingRelationships = incomingRelationships;
	}
	
	/*public Set<Transition> getIncomingRelationships() {
		return this.incomingRelationships;
	}
	
	public void setIncomingRelationships(Set<Transition> incomingRelationships) {
		this.incomingRelationships = incomingRelationships;
	}*/
	
	public String getOutgoingRelationship() {
		return this.outgoingRelationship;
	}
	
	public void setOutgoingRelationship(String outgoingRelationship) {
		this.outgoingRelationship = outgoingRelationship;
	}
}
