package org.mytestlab.domain;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.RelatedToVia;

public class ConditionNode extends GenericNode {

	@Fetch @RelatedToVia(type = "GOES_TO")
	private Transition falseTransition;
	
	private String test;
	
	public ConditionNode() {
		super();
	}
	
	public ConditionNode(String name) {
		super(name);
	}
	
	public ConditionNode(String name, String description) {
		super(name, description);
	}
	
	public Transition getFalseTransition() {
		return this.falseTransition;
	}
	
	public void setFalseTransition(Transition falseTransition) {
		this.falseTransition = falseTransition;
	}
	
	public String getTest() {
		return this.test;
	}
	
	public void setTest(String test) {
		this.test = test;
	}
}
