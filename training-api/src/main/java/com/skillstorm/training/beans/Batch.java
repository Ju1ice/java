package com.skillstorm.training.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "BATCH")
public class Batch {

	@Id
	@Column(name = "BATCH_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "BATCH_NAME")
	private String name;
	
	@Column(name = "TRAINER_NAME")
	private String trainer;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date start;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date end;
	
	@OneToMany(mappedBy = "batch")
	@JsonManagedReference(value = "batch-trainees")
	private Set<Trainee> trainees;

	public Batch() {
		super();
		trainees = new HashSet<>();
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

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", trainer=" + trainer + ", start=" + start + ", end=" + end
				+ "]";
	}

}
