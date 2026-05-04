package com.jobtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.dto.JobRequestDTO;
import com.jobtracker.dto.JobResponseDTO;
import com.jobtracker.entity.Job;
import com.jobtracker.service.JobService;

import jakarta.validation.Valid;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/jobs")
public class JobContoller {
	@Autowired
	private JobService jobService;
	
	@PostMapping
	public JobResponseDTO addJob(@Valid @RequestBody JobRequestDTO dto) {
	    return jobService.addJob(dto);
	}
	
	@GetMapping
	public List<JobResponseDTO> getAllJobs() {
	    return jobService.getAllJobs();
	}

	@GetMapping("/status")
	public List<Job> getByStatus(@RequestParam String status)
	{
		return jobService.getJobsByStatus(status);
	}
	
	@PutMapping("/{id}")
	public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
	    return jobService.updateJob(id, job);
	}
	
	@DeleteMapping("/{id}")
	public String deletJob(@PathVariable Long id)
	{
		jobService.deleteJob(id);
		return "Job deleted successfully";
	}
}
