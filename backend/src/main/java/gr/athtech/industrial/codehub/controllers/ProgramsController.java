package gr.athtech.industrial.codehub.controllers;

import gr.athtech.industrial.codehub.model.Programs;
import gr.athtech.industrial.codehub.repositories.ProgramsRepository;
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
import java.util.List;


@RestController
@RequestMapping("/api/programs")
public class ProgramsController {
	private static final Logger log = LoggerFactory.getLogger(ProgramsController.class);

	@Autowired
	private ProgramsRepository programsRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/getAll")
    public ResponseEntity<List<Programs>> getPrograms() {
		 List<Programs> programs = new ArrayList<>();
		 if(programsRepository.findAll() != null) {
	            for(Programs r: programsRepository.findAll()) {
	                programs.add(r);
	            }
	        }
		 return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(programs);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
 	@GetMapping(path = "/getProgramsByProgramTitle/{programTitle}")
 	public ResponseEntity<List<Programs>> getProgramsByProgramTitle(@PathVariable String programTitle){
		List<Programs> programs = programsRepository.findProgramsByProgramTitle(programTitle);
 		if(programs.isEmpty()) {
 			//TODO: CHANGE RESPONSE WITH ERROR API IMPLEMENTATION
 			 return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(programs);
	}
 		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(programs);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getProgramsByCategory/{category}")
	public ResponseEntity<List<Programs>> getProgramsByCategory(@PathVariable String category){
		List<Programs> programs = programsRepository.findProgramsByCategory(category);
		if(programs.isEmpty()) {
			 //TODO: CHANGE RESPONSE WITH ERROR API IMPLEMENTATION
				 return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(programs);
			}
			return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(programs);
		    }
	
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getProgramsByPrice/{price}")
	public ResponseEntity<List<Programs>> getProgramsByPrice(@PathVariable String price){
		List<Programs> programs = programsRepository.findProgramsByPrice(price);
		if(programs.isEmpty()) {
			 //TODO: CHANGE RESPONSE WITH ERROR API IMPLEMENTATION
				 return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(programs);
			}
			return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(programs);
		    }
}