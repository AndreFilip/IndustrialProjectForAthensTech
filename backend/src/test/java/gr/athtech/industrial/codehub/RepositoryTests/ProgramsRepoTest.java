package gr.athtech.industrial.codehub.RepositoryTests;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.JobPosts;
import gr.athtech.industrial.codehub.model.Programs;
import gr.athtech.industrial.codehub.repositories.ProgramsRepository;
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
public class ProgramsRepoTest {
	private static final Logger log = LoggerFactory.getLogger(CodeHubUserRepoTest.class);

    @Autowired
    private ProgramsRepository programsRepository;
    @Autowired
    private CodeHubUserDetailsService codeHubUserDetailsService;
    @Autowired
    private UserRepository userRepository;
    
    
    @Test
    public void createNewProgram(){
    	Programs program = new Programs("TEST PROGRAM TITLE 1", "TEST PRICE 1", "TEST SMALL DESCRIPTION 1",
    			"TEST MAIN DESCRIPTION 1", "TEST ADDITIONAL INFO 1", "TEST CATEGORY 1", "TEST PROGRAM LOGO 1");
    	programsRepository.save(program);
    	Programs program2 = new Programs("TEST PROGRAM TITLE 2", "TEST PRICE 2", "TEST SMALL DESCRIPTION 2",
    			"TEST MAIN DESCRIPTION 2", "TEST ADDITIONAL INFO 2", "TEST CATEGORY 2", "TEST PROGRAM LOGO 2");
    	programsRepository.save(program2);
    }
    
    @Test
    public void assignUserForProgramTest(){
        Programs programs = programsRepository.findById(1l).get();
        CodeHubUser codeHubUser = userRepository.findUserByUsername("user0");
        codeHubUserDetailsService.assignProgramsToUser(programs, codeHubUser);
    }
    
    @Test
    public void getProgramsByProgramTitleTest(){
    	log.info("***********STARTING getPrograms Tests");    
    	List<Programs> programs = programsRepository.findProgramsByProgramTitle("TEST PROGRAM TITLE 2");
    	for (Programs p: programs) {
    		log.info("PROGRAM : {}", p.toString());
        }
    }
    
    @Test
    public void getProgramsByPriceTest(){
    	List<Programs> programs = programsRepository.findProgramsByPrice("TEST PRICE 1");
    	for (Programs p: programs) {
    		log.info("PROGRAM : {}", p.toString());
        }
    }
    
    @Test
    public void getProgramsByCategoryTest(){
    	log.info("***********STARTING getPrograms Tests");    
    	List<Programs> programs = programsRepository.findProgramsByCategory("TEST CATEGORY 2");
    	for (Programs p: programs) {
    		log.info("PROGRAM : {}", p.toString());
        }
    }
}
