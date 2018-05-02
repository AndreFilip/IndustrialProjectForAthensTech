package gr.athtech.industrial.codehub.ServicesTest;

import gr.athtech.industrial.codehub.RepositoryTests.CodeHubUserRepoTest;
import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.repositories.RoleRepository;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import gr.athtech.industrial.codehub.repositories.UserStatusRepository;
import gr.athtech.industrial.codehub.services.UserStatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStatusServiceTests {
    private static final Logger log = LoggerFactory.getLogger(CodeHubUserRepoTest.class);

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserStatusRepository userStatusRepository;
    @Autowired
    private UserStatusService userStatusService;

    @Test
    public void userStatusChangeTest(){
        log.info("TESTING changeUserStatus()....");
        CodeHubUser user = userRepository.findUserByUsername("user0");
        userStatusService.changeUserStatus(user, "Stage2", "admin");

    }

}
