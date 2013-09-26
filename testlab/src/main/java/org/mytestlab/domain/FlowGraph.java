package org.mytestlab.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class FlowGraph {
	@GraphId
	private Long id;
	
	@Indexed
	private String name;
	
	private Set<String> codeStrings;
	
	public FlowGraph() {
		codeStrings = new HashSet<String>();
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
	
	public Set<String> getCodeStrings() {
		return this.codeStrings;
	}
	
	public void setCodeStrings(Set<String> codeStrings) {
		this.codeStrings = codeStrings;
	}
	
	public boolean addCodeString(String codeString) {
		return this.codeStrings.add(codeString);
	}
	
	public boolean addCodeString(Set<String> codeString) {
		return this.codeStrings.addAll(codeString);
	}
	
	public boolean removeCodeString(String codeString) {
		return this.codeStrings.remove(codeString);
	}
	
	public boolean removeCodeString(Set<String> codeStrings) {
		return this.codeStrings.removeAll(codeStrings);
	}
	
	public void clearCodeStrings() {
		this.codeStrings.clear();
	}
}
