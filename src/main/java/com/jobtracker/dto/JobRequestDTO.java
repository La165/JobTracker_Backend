package com.jobtracker.dto;

import java.time.LocalDate;



import com.jobtracker.enums.JobStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class JobRequestDTO {

	
	@NotBlank(message="company name is required")
	private String companyName;
	
	@NotBlank(message="Role is required")
	private String role;
	
	@NotNull(message="Status is required")
	private JobStatus status;
	
	
	private LocalDate appliedDate;
	private LocalDate examDate;
	private String notes;
	
	
	
	
	
	
	
	
	
	
	
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
