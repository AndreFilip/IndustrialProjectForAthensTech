package gr.athtech.industrial.codehub.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/api/userService")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

//    @PostMapping(path = "/apply/{language}")
//    public ResponseEntity<String> submitApplication(@RequestPart("files[]") MultipartFile[] uploadFiles,
//                                                    @RequestPart("application") CypApplication application,
//                                                    HttpSession session) {
//        return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body("Application received successfully!");
//    }
}
