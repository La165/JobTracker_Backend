package com.jobtracker.service;

import com.jobtracker.dto.JobRequestDTO;
import com.jobtracker.dto.JobResponseDTO;
import com.jobtracker.entity.Job;
import com.jobtracker.entity.User;
import com.jobtracker.repository.JobRepository;
import com.jobtracker.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class JobService {

	@Autowired
    private JobRepository jobRepository;
	

	@Autowired
	private UserRepository userRepository;

	public JobResponseDTO addJob(JobRequestDTO dto) {

	    // 🔥 GET EMAIL FROM JWT
	    String email = (String) SecurityContextHolder
	            .getContext()
	            .getAuthentication()
	            .getPrincipal();

	    // 🔥 FETCH USER FROM DB
	    User user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // 🔽 DTO → ENTITY
	    Job job = new Job();
	    job.setCompanyName(dto.getCompanyName());
	    job.setRole(dto.getRole());
	    job.setStatus(dto.getStatus());
	    job.setAppliedDate(dto.getAppliedDate());
	    job.setExamDate(dto.getExamDate());
	    job.setNotes(dto.getNotes());
	    job.setUser(user);  

	    Job saved = jobRepository.save(job);

	    // 🔽 ENTITY → DTO
	    JobResponseDTO response = new JobResponseDTO();
	    response.setId(saved.getId());
	    response.setCompanyName(saved.getCompanyName());
	    response.setRole(saved.getRole());
	    response.setStatus(saved.getStatus());
	    response.setAppliedDate(saved.getAppliedDate());
	    response.setExamDate(saved.getExamDate());
	    response.setNotes(saved.getNotes());

	    return response;
	}
	
	
	 public List<JobResponseDTO> getAllJobs() {

		 String email = (String) SecurityContextHolder
		            .getContext()
		            .getAuthentication()
		            .getPrincipal();

		    // 🔥 FIND USER
		    User user = userRepository.findByEmail(email)
		            .orElseThrow(() -> new RuntimeException("User not found"));

		    // 🔥 FETCH ONLY THIS USER'S JOBS
		    return jobRepository.findByUser(user)
		            .stream()
		            .map(job -> {
		                JobResponseDTO dto = new JobResponseDTO();
		                dto.setId(job.getId());
		                dto.setCompanyName(job.getCompanyName());
		                dto.setRole(job.getRole());
		                dto.setStatus(job.getStatus());
		                dto.setAppliedDate(job.getAppliedDate());
		                dto.setExamDate(job.getExamDate());
		                dto.setNotes(job.getNotes());
		                return dto;
		            })
		            .collect(java.util.stream.Collectors.toList());
		}
	    
	public List<Job> getJobsByUser(User user)
	{
		return jobRepository.findByUser(user);
	}
	
	public List<Job> getJobsByStatus(String status) {

	    String email = (String) SecurityContextHolder
	            .getContext()
	            .getAuthentication()
	            .getPrincipal();

	    User user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    return jobRepository.findByUserAndStatus(user,
	            com.jobtracker.enums.JobStatus.valueOf(status));
	}
	
	public Job updateJob(Long id, Job updatedJob) {
	    Job job = jobRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Job not found"));

	    job.setCompanyName(updatedJob.getCompanyName());
	    job.setRole(updatedJob.getRole());
	    job.setStatus(updatedJob.getStatus());
	    job.setAppliedDate(updatedJob.getAppliedDate());
	    job.setExamDate(updatedJob.getExamDate());
	    job.setNotes(updatedJob.getNotes());

	    return jobRepository.save(job);
	}
	
	public void deleteJob(Long id) {
	    Job job = jobRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Job not found"));

	    jobRepository.delete(job);
	}
}
