package gr.athtech.industrial.codehub.services;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.Role;
import gr.athtech.industrial.codehub.repositories.RoleRepository;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        CodeHubUser user = userRepository.findUserByUsername(username);
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


    public List<CodeHubUser> getUsers() {
        List<CodeHubUser> users = new ArrayList<>();
        for (CodeHubUser user : userRepository.findAll())
            users.add(user);
        return users;
    }
}