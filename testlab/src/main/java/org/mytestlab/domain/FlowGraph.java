package org.mytestlab.domain;

import java.util.ArrayList;
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
	
	private ArrayList<String> codeStrings;
	
	public FlowGraph() {
		codeStrings = new ArrayList<String>();
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
	
	public ArrayList<String> getCodeStrings() {
		return this.codeStrings;
	}
	
	public void setCodeStrings(ArrayList<String> codeStrings) {
		this.codeStrings = codeStrings;
	}
	
	public boolean addCodeString(String codeString) {
		return this.codeStrings.add(codeString);
	}
	
	public boolean addCodeString(ArrayList<String> codeString) {
		return this.codeStrings.addAll(codeString);
	}
	
	public boolean removeCodeString(String codeString) {
		return this.codeStrings.remove(codeString);
	}
	
	public boolean removeCodeString(ArrayList<String> codeStrings) {
		return this.codeStrings.removeAll(codeStrings);
	}
	
	public void clearCodeStrings() {
		this.codeStrings.clear();
	}
}
