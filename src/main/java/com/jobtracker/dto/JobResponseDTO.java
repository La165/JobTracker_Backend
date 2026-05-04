package com.jobtracker.dto;

import java.time.LocalDate;

import com.jobtracker.enums.JobStatus;

public class JobResponseDTO {

	
	private Long id;
	private String companyName;
	private String role;
	private JobStatus status;
	private LocalDate appliedDate;
	private LocalDate  examDate;
	private String notes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public JobStatus getStatus() {
		return status;
	}
	public void setStatus(JobStatus status) {
		this.status = status;
	}
	public LocalDate getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}
	public LocalDate getExamDate() {
		return examDate;
	}
	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
