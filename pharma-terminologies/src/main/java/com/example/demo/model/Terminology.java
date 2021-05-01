package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(indexes = { @Index(name = "sf_asc_index", columnList = "shortForm ASC"),
		@Index(name = "sf_desc_index", columnList = "shortForm DESC") })
public class Terminology {

	@Id
	@SequenceGenerator(name = "terminology_sequence", sequenceName = "terminology_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminology_sequence")
	Integer id;

	@Column(nullable = false, unique = true)
	String shortForm;

	@Column(nullable = false)
	String fullForm;

	@Column(nullable = true)
	String description;

	public Terminology(String shortForm, String fullForm, String description) {
		this.shortForm = shortForm;
		this.fullForm = fullForm;
		this.description = description;
	}
}
