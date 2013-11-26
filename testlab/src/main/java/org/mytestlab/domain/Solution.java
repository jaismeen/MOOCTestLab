package org.mytestlab.domain;

import java.util.ArrayList;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "PROVIDE_SOLUTION")
public class Solution {
	
	@GraphId
	private Long id;
	
	@Indexed(unique=true)
	private String name;
	
	@StartNode Professor professor;
	@Fetch @EndNode Assignment assignment;
	
	private ArrayList<String> codeStrings;
	private ArrayList<Double> codeStringsPoints;
	
	private int cyclomaticNumber;
	private double cyclomaticNumberPoint;
	
	public Solution() {
		codeStrings = new ArrayList<String>();
		codeStringsPoints = new ArrayList<Double>();
	}
	
	public Solution(String name) {
		this();
		this.name=name;
	}
	
	public Solution(String name, Professor professor, Assignment assignment) {
		this();
		this.name=name;
		this.professor = professor;
		this.assignment = assignment;
	}
	
	public ArrayList<String> getCodeStrings() {
		return codeStrings;
	}
	public void setCodeStrings(ArrayList<String> codeStrings) {
		this.codeStrings = codeStrings;
	}
	public ArrayList<Double> getCodeStringsPoints() {
		return codeStringsPoints;
	}
	public void setCodeStringsPoints(ArrayList<Double> codeStringsPoints) {
		this.codeStringsPoints = codeStringsPoints;
	}
	public int getCyclomaticNumber() {
		return cyclomaticNumber;
	}
	public void setCyclomaticNumber(int cyclomaticNumber) {
		this.cyclomaticNumber = cyclomaticNumber;
	}
	public double getCyclomaticNumberPoint() {
		return cyclomaticNumberPoint;
	}
	public void setCyclomaticNumberPoint(double cyclomaticNumberPoint) {
		this.cyclomaticNumberPoint = cyclomaticNumberPoint;
	}
	
	public Assignment getAssignment() {
		return this.assignment;
	}
	
	public Professor getProfessor() {
		return this.professor;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
