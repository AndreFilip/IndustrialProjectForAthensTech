package gr.athtech.industrial.codehub.services;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.JobPosts;
import gr.athtech.industrial.codehub.model.Programs;
import gr.athtech.industrial.codehub.model.Role;
import gr.athtech.industrial.codehub.repositories.RoleRepository;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author George Lalas
 * @edit Panagiotis Kourempanas
 */
@Service("userService")
public class CodeHubUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CodeHubUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CodeHubUser user = userRepository.findUserByEmail(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return new User(user.getEmail(),user.getPassword(), true, true, true, true, authorities);
    }

    public int saveUser(CodeHubUser user, String roleName) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findRoleByName(roleName);
        if (role == null)
            return -1;
        user.setRole(role);
        try {
            userRepository.save(user);
            return 0;
        } catch(DataIntegrityViolationException exception) {
            if (exception.getRootCause().toString().contains("Duplicate entry"))
                return -2;
            else
                return -3;
        }
    }

    public boolean findUserByEmailAndPassword(String email, String password){
        CodeHubUser codeHubUser =userRepository.findUserByEmail(email);
        if(passwordEncoder.matches(password, codeHubUser.getPassword())){
            return true;
        }
        return false;
    }



    public List<CodeHubUser> getUsers() {
        List<CodeHubUser> users = new ArrayList<>();
        for (CodeHubUser user : userRepository.findAll())
            users.add(user);
        return users;
    }

    public void assignJobPostsToUser(JobPosts jobPosts, CodeHubUser user){
        Set<JobPosts> jobPostsSet =user.getJobPosts();
        if(jobPostsSet.contains(jobPosts)){
            log.info("User already registered for this job post!");
        }else {
            jobPostsSet.add(jobPosts);
            user.setJobPosts(jobPostsSet);
            userRepository.save(user);
        }
    }
    
    public void assignProgramsToUser(Programs programs, CodeHubUser user) {
    	Set<Programs> programsSet = user.getPrograms();
    	if(programsSet.contains(programs)) {
    		log.info("User already registered for this program!");
    	}else {
    		programsSet.add(programs);
    		user.setPrograms(programsSet);
    		userRepository.save(user);
    	}
    	
    }
}