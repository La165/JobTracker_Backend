package com.jobtracker.entity;


import java.time.LocalDate;

import com.jobtracker.enums.JobStatus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String companyName;
	private String role;
	private String jobLink;
	private String location;
	private String jobType;
	
	@Enumerated(EnumType.STRING)
	private JobStatus status;
	private LocalDate appliedDate;
	private LocalDate examDate;
	private String resumeVersion;
	
	@Column(length=1000)
	private String notes;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;



}
