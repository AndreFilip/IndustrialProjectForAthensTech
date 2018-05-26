package gr.athtech.industrial.codehub.controllers;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.Techstack;
import gr.athtech.industrial.codehub.repositories.TechstackRepository;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/techstack")
public class TechStackController {
    private static final Logger log = LoggerFactory.getLogger(TechStackController.class);

    @Autowired
    private TechstackRepository techstackRepository;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Techstack>> getTechStacks() {
        List<Techstack> techstacks = new ArrayList<>();
            for(Techstack t: techstackRepository.findAll()) {
                techstacks.add(t);
            }
            log.debug("TECHSTACK LIST : {}", techstacks.toString());
        return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(techstacks);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getByStack/{stack}")
    public ResponseEntity<Techstack> getTechstackByStack(@PathVariable String stack) {
    	Techstack techstack = techstackRepository.findTechstackByStack(stack);
    	return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(techstack);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getStackOfUser/{username}")
    public ResponseEntity<Set<Techstack>> getTechStackForUser(@PathVariable("username") String username){
        CodeHubUser codeHubUser = userRepository.findUserByUsername(username);
        if(codeHubUser !=null){
            Set<Techstack> techstacks = codeHubUser.getUserTechstack();
            return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(techstacks);
        }else{
            log.info("USER {} doesn't exist!Return empty list", username);
            Set<Techstack> techstacks = new HashSet<>();
            return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(techstacks);
        }
    }
}
