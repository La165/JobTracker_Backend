package com.jobtracker.dto;

import java.time.LocalDate;
import com.jobtracker.enums.JobStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class JobRequestDTO {

    @NotBlank
    private String companyName;

    @NotBlank
    private String role;

    private String jobLink;

    private String location;

    @NotNull
    private JobStatus status;

    private LocalDate appliedDate;

    // ✅ NEW FIELD (added in creation)
    private String resumeVersion;

    // getters & setters

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

    public String getResumeVersion() { return resumeVersion; }
    public void setResumeVersion(String resumeVersion) { this.resumeVersion = resumeVersion; }
}