package gr.athtech.industrial.codehub.controllers;

import gr.athtech.industrial.codehub.model.Country;
import gr.athtech.industrial.codehub.repositories.CountryRepository;
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
@RequestMapping("/api/country")
public class CountryController {
    private static final Logger log = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping(path = "/getByIsoCode/{isoCode}")
    public ResponseEntity<Country> getCountryByIsoCode(@PathVariable String isoCode) {
        Country country = countryRepository.findCountryByIsoCode(isoCode);
        return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(country);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Country>> getCountries() {
        List<Country> countries = new ArrayList<>();
        if(countryRepository.findAll() != null) {
            for(Country c: countryRepository.findAll()) {
                countries.add(c);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(countries);
    }

}
