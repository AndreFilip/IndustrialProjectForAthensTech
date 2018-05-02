package gr.athtech.industrial.codehub.controllers;

import gr.athtech.industrial.codehub.model.Status;
import gr.athtech.industrial.codehub.repositories.StatusRepository;
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
@RequestMapping("/api/status")
public class StatusController {
	private static final Logger log = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Status>> getStatuses() {
        List<Status> statuses = new ArrayList<>();
        if(statusRepository.findAll() != null) {
            for(Status s: statusRepository.findAll()) {
                statuses.add(s);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(statuses);
    }
    @GetMapping(path = "/getStatusByName/{statusName}")
    public ResponseEntity<Status> getCountryByIsoCode(@PathVariable String statusName) {
        Status status = statusRepository.findStatusByName(statusName);
        return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(status);
    }
}
