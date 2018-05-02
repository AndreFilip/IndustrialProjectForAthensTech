package gr.athtech.industrial.codehub.controllers;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.pojos.User;
import gr.athtech.industrial.codehub.repositories.CountryRepository;
import gr.athtech.industrial.codehub.repositories.RoleRepository;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import gr.athtech.industrial.codehub.services.CodeHubUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/userService")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CodeHubUserDetailsService codeHubUserDetailsService;

    @PostMapping(path = "/register")
    public ResponseEntity<String> submitRegistration(@RequestBody User user) {
        log.debug("JSON RECEIVED: {}", user.toString());
        log.debug("ROLE : {} ", user.getRoleName());
        log.debug("COUNTRY : {}", user.getCountryIsoCode());
        CodeHubUser userToSave = new CodeHubUser();
        userToSave.setEmail(user.getEmail());
        userToSave.setUsername(user.getUsername());
        userToSave.setPassword(user.getPassword());
        userToSave.setRole(roleRepository.findRoleByName(user.getRoleName()));
        userToSave.setFirstName(user.getFirstName());
        userToSave.setLastName(user.getLastName());
        userToSave.setCountry(countryRepository.findCountryByIsoCode(user.getCountryIsoCode()));
        userToSave.setActive(user.getActive());
        userToSave.setDateCreated(new Date());
        userToSave.setLatestLogin(new Date());
        if(codeHubUserDetailsService.saveUser(userToSave, user.getRoleName()) == 0){
            return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body("Registration Completed");
        }else{
            return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body("Registration Failed");
        }
    }


    @GetMapping(path = "/getAll")
    public ResponseEntity<List<CodeHubUser>> getUsers() {
        List<CodeHubUser> userList = codeHubUserDetailsService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(userList);
    }

    //    @GetMapping(path = "/getAll")
//    public ResponseEntity<List<User>> getUsers() {
//        List<User> userList = new ArrayList<>();
//        for(CodeHubUser c: userRepository.findAll()) {
//            User user = new User(c.getEmail(), c.getUsername(), c.getPassword(), c.getRole().getName()
//                    , c.getFirstName(), c.getLastName(), c.getCountry().getIsoCode(), c.getActive(), c.getDateCreated()
//                    , c.getLatestLogin(), c.getPhoneNumber(), c.getUserStatus().getStage(), c.getInternalComments()
//                    , c.getCvPath(), c.getAvatarPath(), c.getLinkedinPath(), c.getStackOverflowPath(), c.getGitPath());
//            userList.add(user);
//        }
//        return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(userList);
//    }
}
