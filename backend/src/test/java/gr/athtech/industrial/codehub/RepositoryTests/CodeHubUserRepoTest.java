package gr.athtech.industrial.codehub.RepositoryTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.Role;
import gr.athtech.industrial.codehub.model.Techstack;
import gr.athtech.industrial.codehub.repositories.RoleRepository;
import gr.athtech.industrial.codehub.repositories.TechstackRepository;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeHubUserRepoTest {
    private static final Logger log = LoggerFactory.getLogger(CodeHubUserRepoTest.class);

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TechstackRepository techstackRepository;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp(){
        Role adminRole = roleRepository.findRoleByName("admin");
        Role userRole = roleRepository.findRoleByName("user");
    }

    @Test
//    @Transactional
    public void saveTest() {
        log.info("TESTING techstack relations of UserRepository");
        CodeHubUser user = userRepository.findUserByUsername("user0");
        Set<Techstack> techstacks = new HashSet<Techstack>();
        for(Techstack techstack : techstackRepository.findAll()){
            techstacks.add(techstack);
        }
        user.setUserTechstack(techstacks);
        userRepository.save(user);
        log.info("USER UPDATED : {}", userRepository.findUserByUsername("user0"));

    }

    @Test
    public void getTechstackList(){
        for(Techstack t : techstackRepository.findAll()){
            log.info("TECHSTACK LIST : {}",t.toString());
        }
    }

    @Test
    public void getUserByEmailTest() {
    	CodeHubUser codeHubUser = userRepository.findUserByEmail("user0@user0.gr");
    	log.info("CODEHUB USER BY EMAIL : {}", codeHubUser.toString());
    }
    
    @Test
    public void getUserByUsernameTest() {
    	CodeHubUser codeHubUser = userRepository.findUserByUsername("user0");
    	log.info("CODEHUB USER BY USERNAME : {}", codeHubUser.toString());
    }
    
    @Test
    public void getUserByRoleTest() {
    	Role role = roleRepository.findRoleByName("candidate");
    	List<CodeHubUser> codeHubUsers = userRepository.findCodeHubUserByRole(role);
    	for (CodeHubUser chu: codeHubUsers){
    		log.info("USERS BY ROLE : {}", chu.toString());
    	}
    }
    
    @Test
    public void produceCodeHubUserJSON(){
        ObjectMapper mapper = new ObjectMapper();
        CodeHubUser codeHubUser = userRepository.findUserByUsername("user0");
        try {
            String jsonString = mapper.writeValueAsString(codeHubUser);
            log.info("JSON OF USER : {}", jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @After
    public void tearDown(){

    }

}
