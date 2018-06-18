package gr.athtech.industrial.codehub.controllers;

import gr.athtech.industrial.codehub.configurations.JwtTokenUtil;
import gr.athtech.industrial.codehub.pojos.AuthToken;
import gr.athtech.industrial.codehub.pojos.User;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import gr.athtech.industrial.codehub.services.CodeHubUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/token")
public class AuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CodeHubUserDetailsService userService;
    @Autowired
    private UserRepository userRepository;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/generate-token")
    public ResponseEntity register(@RequestBody User loginUser) throws AuthenticationException {
        log.info("LOGIN DETAILS : {} {}", loginUser.getEmail(), loginUser.getPassword());
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getEmail(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String userEmail = userRepository.findUserByEmail(loginUser.getEmail()).getEmail();
        final String token = jwtTokenUtil.generateToken(userEmail);
        log.info("TOKEN GENERATED: {}", token);
        return ResponseEntity.ok(new AuthToken(token));
    }

}