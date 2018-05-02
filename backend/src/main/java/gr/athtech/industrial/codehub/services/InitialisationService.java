package gr.athtech.industrial.codehub.services;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.Country;
import gr.athtech.industrial.codehub.model.Role;
import gr.athtech.industrial.codehub.repositories.CountryRepo;
import gr.athtech.industrial.codehub.repositories.RoleRepository;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author George Lalas
 */
@Component
public class InitialisationService implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger log = LoggerFactory.getLogger(InitialisationService.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    CountryRepo countryRepository;

    @Value("${default.admin.email}")
    String defaultAdminEmail;
    @Value("${default.admin.username}")
    String defaultAdminUsername;
    @Value("${default.admin.password}")
    String defaultAdminPassword;
    @Value("${default.user0.email}")
    private String defaultUser0email;
    @Value("${default.user0.password}")
    private String defaultUser0Password;
    @Value("${default.user0.username}")
    private String defaultUser0Username;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Role role = roleRepository.findRoleByName("admin");
        Country country = countryRepository.findCountryByIsoCode("GR");
        Date creationDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        log.info("******InitialisationService Started******");
        log.info("****Populating Database with Admin and user!******");
        log.info("***CREATION DATE : {}", dateFormat.format(creationDate));
        List<CodeHubUser> admins = userRepository.findCodeHubUserByRole(role);
        if (admins == null || admins.size() == 0) {
            // No admin user, create default
            CodeHubUser admin = new CodeHubUser();
            admin.setFirstName("Admin");
            admin.setLastName("Adminopoulos");
            admin.setUsername(defaultAdminUsername);
            admin.setEmail(defaultAdminEmail);
            admin.setPassword(passwordEncoder.encode(defaultAdminPassword));
            admin.setRole(role);
            admin.setCountry(country);
            admin.setDateCreated(creationDate);
            admin.setActive(true);
            admin.setLatestLogin(creationDate);
            userRepository.save(admin);
        }
        role = roleRepository.findRoleByName("user");
        if(userRepository.findCodeHubUserByRole(role).size() == 0) {
            log.info("There are no users registered yet!Initialising a user");
            CodeHubUser user = new CodeHubUser();
            user.setFirstName("User");
            user.setLastName("Useridis");
            user.setUsername(defaultUser0Username);
            user.setPassword(passwordEncoder.encode(defaultUser0Username));
            user.setEmail(defaultUser0email);
            user.setRole(role);
            user.setCountry(country);
            user.setDateCreated(creationDate);
            user.setActive(true);
            user.setLatestLogin(creationDate);
            userRepository.save(user);
        }
        log.info("******InitialisationService Ended******");
    }
}
