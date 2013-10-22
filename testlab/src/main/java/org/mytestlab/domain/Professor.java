package org.mytestlab.domain;

import java.util.Set;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class Professor {
	@GraphId
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@Indexed(unique=true)
	private String username;
	
	private String password;
	
	@RelatedToVia(type = "PROVIDE_SOLUTION")
	@Fetch private Set<Solution> solutions;
	
	@RelatedTo(type="TEACHES_IN")
	private Course course;
	
	public Professor() {}
	
	public Professor(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Professor(String username, String firstName, String lastName) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Professor(String username) {
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

}
