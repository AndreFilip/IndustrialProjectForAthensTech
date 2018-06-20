package gr.athtech.industrial.codehub.RepositoryTests;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.JobPosts;
import gr.athtech.industrial.codehub.repositories.JobPostsRepository;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import gr.athtech.industrial.codehub.services.CodeHubUserDetailsService;

import java.util.List;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JobPostsRepoTests {
    private static final Logger log = LoggerFactory.getLogger(CodeHubUserRepoTest.class);

    @Autowired
    private JobPostsRepository jobPostsRepository;
    @Autowired
    private CodeHubUserDetailsService codeHubUserDetailsService;
    @Autowired
    private UserRepository userRepository;


    @Test
    public void createNewJobPost(){
        JobPosts jobPost = new JobPosts("New Test Job Title", "DEMO LOCATION","TEST DESCRIPTION!", 
        		"TEST COMP TITLE!", "TEST COMP DESC!", "TEST QUALIFICATIONS", "TEST COMP LOGO");
                jobPostsRepository.save(jobPost);
        JobPosts jobPost2 = new JobPosts("Engineer", "Athens","TEST DESCRIPTION2", 
        		"TEST COMP TITLE2", "TEST COMP DESC2", "TEST QUALIFICATIONS 2", "TEST COMP LOGO 2");
        jobPostsRepository.save(jobPost2);
        }
    
    @Test
    public void assignUserForJobPostTest(){
        JobPosts jobPosts = jobPostsRepository.findById(1l).get();
        CodeHubUser codeHubUser = userRepository.findUserByUsername("user0");
        codeHubUserDetailsService.assignJobPostsToUser(jobPosts, codeHubUser);
    }
    
    @Test
    public void getJobPostByJobTitleTest(){
    	log.info("***********STARTING getJobPostsyTitle Tests");
        List<JobPosts> jobPosts = jobPostsRepository.findJobPostsByJobTitle("New Test Job Title");
        for(JobPosts jp: jobPosts) {
        	log.info("JOB post : {}", jp.toString());
        }
    }
    
   @Test
    public void getJobPostsByLocationTest() {
    	List<JobPosts> jobPosts = jobPostsRepository.findJobPostsByLocation("Athens");
    	for(JobPosts jp1: jobPosts) {
    		log.info("JOB post : {}", jp1.toString());
    	}
    }
   
   @Test
   public void getJobPostsByCompanyTitleTest() {
   	List<JobPosts> jobPosts = jobPostsRepository.findJobPostsByCompanyTitle("TEST COMP TITLE2");
   	for(JobPosts jp4: jobPosts) {
   		log.info("JOB post : {}", jp4.toString());
   	}
   }
   
   @Test
   public void getJobPostsByQualificationsTest() {
	   List<JobPosts> jobPosts = jobPostsRepository.findJobPostsByQualifications("TEST QUALIFICATIONS");
	   for(JobPosts jp2: jobPosts) {
		   log.info("JOB post : {}", jp2.toString());
	   }
   }
/**   
   @Test
   public void getJobPostsByDateCreatedTest() {
	   List<JobPosts> jobPosts = jobPostsRepository.findJobPostsByDateCreated(2018, 05, 19);
	   for(JobPosts jp3: jobPosts) {
		   log.info("JOB post : {}", jp3.toString());
	   }
   }
*/

}
