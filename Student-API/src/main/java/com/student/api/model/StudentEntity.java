package com.student.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="student")
public class StudentEntity {

	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	@NotNull(message="First name not null")
	@Size(min=3, max=15)
	@Column(name="first_name")
	private String first_name;
	
	@NotNull(message="Last name not null")
	@Size(min=3, max=10)
	@Column(name="last_name")
	private String last_name;
	
	@NotNull(message="year level not null")
	@Column(name="year_level")
	private int year_lavel;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getYear_lavel() {
		return year_lavel;
	}
	public void setYear_lavel(int year_lavel) {
		this.year_lavel = year_lavel;
	}
	
}
