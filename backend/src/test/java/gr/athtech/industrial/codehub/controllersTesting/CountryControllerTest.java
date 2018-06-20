package gr.athtech.industrial.codehub.controllersTesting;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import gr.athtech.industrial.codehub.model.Country;
import gr.athtech.industrial.codehub.controllers.CountryController;
import gr.athtech.industrial.codehub.repositories.CountryRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(value = CountryController.class, secure = false)
public class CountryControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CountryRepository countryRepository;
	
	Country mockCountry = new Country("GR", "GREECE", "Greece", "GRC", "300", "30");
	
	String exampleCountryJson = "{\"isoCode\":\"GR\", \"nameCapital\":\"GREECE\", \"nameView\":\"Greece\", \"isoCode3\":\"GRC\", \"numCode\":\"30\"}";
	
	@Test
	public void getCountryByIsoCode() throws Exception {
		
		Mockito.when(countryRepository.findCountryByIsoCode(Mockito.anyString())).thenReturn(mockCountry);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("GR").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		String expected = "{isoCode:GR, nameCapital:GREECE, nameView:Greece, numCode:300, phoneCode:30}";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
