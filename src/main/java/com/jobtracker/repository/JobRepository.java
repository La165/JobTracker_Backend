package com.jobtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobtracker.entity.Job;
import com.jobtracker.entity.User;

public interface JobRepository  extends JpaRepository<Job, Long>{

	
	List<Job> findByUser(User user);
	//List<Job> findByStatus(String status);
	
	List<Job> findByUserAndStatus(User user, com.jobtracker.enums.JobStatus status);
	
}
