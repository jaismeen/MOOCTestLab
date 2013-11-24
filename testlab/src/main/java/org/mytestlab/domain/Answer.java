package org.mytestlab.domain;

import java.util.ArrayList;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "DO_LAB")
public class Answer {

	@GraphId
	private Long id;
	
	@Fetch @StartNode Student student;
	@EndNode Assignment assignment;
	
	private ArrayList<String> codeStrings;
	private ArrayList<Double> codeStringsPoints;
	
	private int cyclomaticNumber;
	private double cyclomaticNumberPoint;
	
	@Fetch private Double totalPoints;

	public Answer() {
		codeStrings = new ArrayList<String>();
		codeStringsPoints = new ArrayList<Double>();
	}
	
	public Answer(Student student, Assignment assignment) {
		this();
		this.student = student;
		this.assignment = assignment;
	}
	
	public ArrayList<String> getCodeStrings() {
		return codeStrings;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setCodeStrings(ArrayList<String> codeStrings) {
		this.codeStrings = codeStrings;
	}

	public Double getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(Double totalPoints) {
		this.totalPoints = totalPoints;
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
	
}
