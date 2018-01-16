package com.simpleservices;

import javax.persistence.*;

@Entity
@Table(name="applications")
public class Applications {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "APP_SEQ")
	private Integer id;
	
	private String name;
	
	@Column(name="APP_DESCRIPTION")
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Applications [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}
