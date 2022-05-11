package com.football.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(nullable = false, length = 100)
	String name;
	@Column(nullable = false, length = 100)
	String city;
	@Column(nullable = false, length = 100)
	String country;
	@Column(nullable = true)
	int yearFounded;
	
	public Team() {
		
	}
	
	public Team(int id, String name, String city, String country, int yearFounded) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
		this.yearFounded = yearFounded;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}
	

}