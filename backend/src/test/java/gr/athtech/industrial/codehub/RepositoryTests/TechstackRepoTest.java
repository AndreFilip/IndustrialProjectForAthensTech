package gr.athtech.industrial.codehub.RepositoryTests;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.Techstack;
import gr.athtech.industrial.codehub.repositories.TechstackRepository;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import gr.athtech.industrial.codehub.services.CodeHubUserDetailsService;

import java.util.List;

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
public class TechstackRepoTest {
		 private static final Logger log = LoggerFactory.getLogger(CodeHubUserRepoTest.class);

		 @Autowired
		 private TechstackRepository techstackRepository;
		 @Autowired
		 private CodeHubUserDetailsService codeHubUserDetailsService;
		 @Autowired
		 private UserRepository userRepository;
		 
		 @Test
		    public void getTechstackByStackTest() {
		    	Techstack techstack = techstackRepository.findTechstackByStack("J2EE");
		    	log.info("Techstack : {}", techstack.toString());
			}

}
