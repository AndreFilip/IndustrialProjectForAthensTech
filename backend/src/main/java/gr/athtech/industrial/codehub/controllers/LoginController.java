//package gr.athtech.industrial.codehub.controllers;
//
//import gr.athtech.industrial.codehub.pojos.User;
//import gr.athtech.industrial.codehub.services.CodeHubUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class LoginController {
//
//    private final CodeHubUserDetailsService userService;
//
//    @Autowired
//    public LoginController(CodeHubUserDetailsService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping(
//            value = "/login",
//            method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> login(@RequestBody User user) {
//        if (StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())) {
//            return new ResponseEntity<>(new User(), HttpStatus.OK);
//        }
//        if (!userService.findUserByEmailAndPassword(user.getEmail(), user.getPassword())){
//            return new ResponseEntity<>(new User(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(userService.loadUserByUsername(user.getEmail()), HttpStatus.OK);
//    }
//}