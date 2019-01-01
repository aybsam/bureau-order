package com.lismart.smartregie.domain;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Past;

@Entity
@Table(name = "Courrier")
public class Courrier {
	
	@Id
	@GeneratedValue
	@Column(insertable=false,updatable=false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_source")
	private User source;
	
	@ManyToOne
	@JoinColumn(name="id_destination")
	private User destination;
	
	 @Temporal(TemporalType.DATE)
	 @Past
	private Date dateEnvoie;
	 
	@Column(name="description")
	private String description;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSource() {
		return source;
	}

	public void setSource(User source) {
		this.source = source;
	}

	public User getDestination() {
		return destination;
	}

	public void setDestination(User destination) {
		this.destination = destination;
	}

	public Date getDateEnvoie() {
		return dateEnvoie;
	}

	public void setDateEnvoie(Date dateEnvoie) {
		this.dateEnvoie = dateEnvoie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
