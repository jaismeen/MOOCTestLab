package org.mytestlab.domain;

import java.util.ArrayList;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "PROVIDE_SOLUTION")
public class Solution {
	
	@GraphId
	private Long id;
	
	@StartNode Professor professor;
	@EndNode Assignment assignment;
	
	private ArrayList<String> codeStrings;
	private ArrayList<Double> codeStringsPoints;
	
	private int cyclomaticNumber;
	private double cyclomaticNumberPoint;
	
	public Solution() {
		codeStrings = new ArrayList<String>();
		codeStringsPoints = new ArrayList<Double>();
	}
	
	public Solution(Professor professor, Assignment assignment) {
		this();
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
}
