package org.mytestlab.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class Student {

	@GraphId
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@Indexed(unique=true)
	private String username;
	private String password;
	
	@Fetch @RelatedToVia(type = "DO_LAB")
	private Set<Answer> answers;
	
	@Fetch @RelatedTo(type = "HAS_TRANSCRIPT")
	private Transcript transcript;
	
	@RelatedTo(type="TAKE_COURSE")
	private Course course;
	
	public Student() {
		this.answers = new HashSet<Answer>();
	}
	
	public Student(String username, String password, String firstName, String lastName) {
		this();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Student(String username, String firstName, String lastName) {
		this();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Student(String username) {
		this.username = username;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addAnswer(Answer ans) {
		this.answers.add(ans);
	}
}
