package gr.athtech.industrial.codehub.RepositoryTests;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.Country;
import gr.athtech.industrial.codehub.repositories.CountryRepository;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import gr.athtech.industrial.codehub.services.CodeHubUserDetailsService;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryRepoTests {
	 private static final Logger log = LoggerFactory.getLogger(CodeHubUserRepoTest.class);

	 @Autowired
	    private CountryRepository countryRepository;
	    @Autowired
	    private CodeHubUserDetailsService codeHubUserDetailsService;
	    @Autowired
	    private UserRepository userRepository;

	    @Test
	    public void getCountryByIsoCodeTest(){
	    	log.info("***********STARTING getCountry Tests");
	    	Country country = countryRepository.findCountryByIsoCode("GR");
	    	log.info("Country : {}", country.toString());
	    	}
	    
	    @Test
	    public void getCountryByIsoCode3Test(){
	    	Country country = countryRepository.findCountryByIsoCode3("BEL");
	    	log.info("Country : {}", country.toString());
	    	}
	    
	    @Test
	    public void getCountryByPhoneCodeTest(){
	    	Country country = countryRepository.findCountryByPhoneCode("93");
	    	log.info("Country : {}", country.toString());
	    	}
	    
	    @Test
	    public void getCountryByNumCodeTest(){
	    	Country country = countryRepository.findCountryByNumCode("12");
	    	log.info("Country : {}", country.toString());
	    	}
	    
	    @Test
	    public void getCountryByNameVIewTest(){
	    	Country country = countryRepository.findCountryByNameView("Angola");
	    	log.info("Country : {}", country.toString());
	    	}
	    
	    @Test
	    public void getCountryByNameCapitalTest(){
	    	Country country = countryRepository.findCountryByNameCapital("AUSTRIA");
	    	log.info("Country : {}", country.toString());
	    	}
}