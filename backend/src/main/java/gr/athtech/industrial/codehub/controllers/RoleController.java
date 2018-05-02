package gr.athtech.industrial.codehub.controllers;

import gr.athtech.industrial.codehub.model.Role;
import gr.athtech.industrial.codehub.repositories.RoleRepository;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Role>> getRoles() {
        List<Role> roles = new ArrayList<>();
        if(roleRepository.findAll() != null) {
            for(Role r: roleRepository.findAll()) {
                roles.add(r);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(roles);
    }

    @GetMapping(path = "/getRoleByName/{roleName}")
    public ResponseEntity<Role> getCountryByIsoCode(@PathVariable String roleName) {
        Role role = roleRepository.findRoleByName(roleName);
        return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(role);
    }
}