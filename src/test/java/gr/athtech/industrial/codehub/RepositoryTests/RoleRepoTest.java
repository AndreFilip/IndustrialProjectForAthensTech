package gr.athtech.industrial.codehub.RepositoryTests;

import gr.athtech.industrial.codehub.model.Role;
import gr.athtech.industrial.codehub.repositories.RoleRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepoTest {
    private static final Logger log = LoggerFactory.getLogger(RoleRepoTest.class);
    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void setUp(){

    }

    @Test
    @Transactional
    public void saveTest() {
        log.info("TESTING save() of RoleRepository");
        Role testRole = new Role("TestRole");
        try {
            log.info("Saving a new Role : TestRole...");
            roleRepository.save(testRole);
        }catch(Exception e){
            //capturing any exception...
            log.info("Something went wrong : {}", e.getMessage());
        }


    }

    @After
    public void tearDown(){

    }
}
