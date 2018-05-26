package gr.athtech.industrial.codehub.controllers;

import gr.athtech.industrial.codehub.model.JobPosts;
import gr.athtech.industrial.codehub.repositories.JobPostsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/jobPosts")
public class JobPostsController {
	private static final Logger log = LoggerFactory.getLogger(JobPostsController.class);
	
	@Autowired
	private JobPostsRepository jobPostsRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/getAll")
    public ResponseEntity<List<JobPosts>> getJobPosts() {
        List<JobPosts> jobPosts = new ArrayList<>();
        if(jobPostsRepository.findAll() != null) {
            for(JobPosts r: jobPostsRepository.findAll()) {
                jobPosts.add(r);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(jobPosts);
    }

    @CrossOrigin(origins = "http://localhost:4200")
 	@GetMapping(path = "/getJobPostsByJobTitle/{jobTitle}")
 	public ResponseEntity<List<JobPosts>> getJobPostsByJobTitle(@PathVariable String jobTitle){
 		List<JobPosts> jobPosts = jobPostsRepository.findJobPostsByJobTitle(jobTitle);
 		if(jobPosts.isEmpty()) {
 			//TODO: CHANGE RESPONSE WITH ERROR API IMPLEMENTATION
 			 return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(jobPosts);
 		}
 		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(jobPosts);
 	   }
   
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getJobPostsByLocation/{location}")
    public ResponseEntity<List<JobPosts>> getJobPostsByLocation(@PathVariable String location){
    	List<JobPosts> jobPosts = jobPostsRepository.findJobPostsByLocation(location);
	    if(jobPosts.isEmpty()) {
		 //TODO: CHANGE RESPONSE WITH ERROR API IMPLEMENTATION
			 return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(jobPosts);
		}
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(jobPosts);
	    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getJobPostsByQualifications/{qualifications}")
    public ResponseEntity<List<JobPosts>> getJobPostsByQualifications(@PathVariable String qualifications){
    	List<JobPosts> jobPosts = jobPostsRepository.findJobPostsByQualifications(qualifications);
    	if(jobPosts.isEmpty()) {
   		 //TODO: CHANGE RESPONSE WITH ERROR API IMPLEMENTATION
   			 return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(jobPosts);
   		}
   		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(jobPosts);
   	    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getJobPostsByCompanyTitle/{companyTitle}")
    public ResponseEntity<List<JobPosts>> getJobPostsByCompanyTitle(@PathVariable String companyTitle){
    	List<JobPosts> jobPosts = jobPostsRepository.findJobPostsByCompanyTitle(companyTitle);
    	if(jobPosts.isEmpty()) {
      		 //TODO: CHANGE RESPONSE WITH ERROR API IMPLEMENTATION
      			 return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(jobPosts);
      		}
      		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(jobPosts);
      	    }
    }