package gr.athtech.industrial.codehub.controllers;

import gr.athtech.industrial.codehub.configurations.JwtTokenUtil;
import gr.athtech.industrial.codehub.pojos.AuthToken;
import gr.athtech.industrial.codehub.pojos.User;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import gr.athtech.industrial.codehub.services.CodeHubUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CodeHubUserDetailsService userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody User loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getEmail(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String userEmail = userRepository.findUserByEmail(loginUser.getEmail()).getEmail();
        final String token = jwtTokenUtil.generateToken(userEmail);
        return ResponseEntity.ok(new AuthToken(token));
    }

}