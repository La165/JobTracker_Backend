package com.jobtracker.dto;

import java.time.LocalDate;
import com.jobtracker.enums.JobStatus;

public class JobResponseDTO {

    private Long id;
    private String companyName;
    private String role;
    private String jobLink;
    private String location;
    private JobStatus status;
    private LocalDate appliedDate;
    private LocalDate examDate;
    private String notes;

    // ✅ NEW FIELD
    private String resumeVersion;

    // getters & setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getJobLink() { return jobLink; }
    public void setJobLink(String jobLink) { this.jobLink = jobLink; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public JobStatus getStatus() { return status; }
    public void setStatus(JobStatus status) { this.status = status; }

    public LocalDate getAppliedDate() { return appliedDate; }
    public void setAppliedDate(LocalDate appliedDate) { this.appliedDate = appliedDate; }

    public LocalDate getExamDate() { return examDate; }
    public void setExamDate(LocalDate examDate) { this.examDate = examDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getResumeVersion() { return resumeVersion; }
    public void setResumeVersion(String resumeVersion) { this.resumeVersion = resumeVersion; }
}