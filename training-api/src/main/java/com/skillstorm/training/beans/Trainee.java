package com.skillstorm.training.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TRAINEE")
public class Trainee {

	@Id
	@Column(name = "TRAINEE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "TRAINEE_NAME")
	private String name;
	
	@Column(name = "MAJOR")
	private String major;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BATCH_ID")
	@JsonBackReference(value = "batch-trainees")
	private Batch batch;

	public Trainee() {
		super();
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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", major=" + major + ", batch=" + batch + "]";
	}
}
