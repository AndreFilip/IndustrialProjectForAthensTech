package gr.athtech.industrial.codehub.RepositoryTests;

import gr.athtech.industrial.codehub.model.Status;
import gr.athtech.industrial.codehub.repositories.StatusRepository;
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
public class StatusRepoTest {
	private static final Logger log = LoggerFactory.getLogger(StatusRepoTest.class);
    @Autowired
    private StatusRepository statusRepository;

    @Before
    public void setUp(){

    }

    @Test
   
    public void saveTest() {
        log.info("TESTING save() of StatusRepository");
        Status testStatus = new Status("TestStatus");
        try {
            log.info("Saving a new Status : TestStatus...");
            statusRepository.save(testStatus);
        }catch(Exception e){
            //capturing any exception...
            log.info("Something went wrong : {}", e.getMessage());
        }
        
    }
    
    @Test
    public void getStatusByNameTest() {
    	Status status = statusRepository.findStatusByName("Interview");
    	log.info("Status : {}", status.toString());
	}

    @After
    public void tearDown(){

    }
}
