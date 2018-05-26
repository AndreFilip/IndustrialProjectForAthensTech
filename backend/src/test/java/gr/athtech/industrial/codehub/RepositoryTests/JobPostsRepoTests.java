package gr.athtech.industrial.codehub.RepositoryTests;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.JobPosts;
import gr.athtech.industrial.codehub.repositories.JobPostsRepository;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import gr.athtech.industrial.codehub.services.CodeHubUserDetailsService;
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
public class JobPostsTests {
    private static final Logger log = LoggerFactory.getLogger(CodeHubUserRepoTest.class);

    @Autowired
    private JobPostsRepository jobPostsRepository;
    @Autowired
    private CodeHubUserDetailsService codeHubUserDetailsService;
    @Autowired
    private UserRepository userRepository;


    @Test
    public void createNewJobPost(){
        JobPosts jobPost = new JobPosts("New Test Job Title", "DEMO LOCATION","TEST DESCRIPTION!");
        jobPostsRepository.save(jobPost);
    }

    @Test
    public void assignUserForJobPostTest(){
        JobPosts jobPosts = jobPostsRepository.findById(1l).get();
        CodeHubUser codeHubUser = userRepository.findUserByUsername("user0");
        codeHubUserDetailsService.assignJobPostsToUser(jobPosts, codeHubUser);
    }
}
