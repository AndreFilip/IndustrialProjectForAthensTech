package gr.athtech.industrial.codehub.controllersTesting;

import gr.athtech.industrial.codehub.controllers.RoleController;
import gr.athtech.industrial.codehub.model.Role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(RoleController.class)
public class RoleControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private RoleController roleController;
	
	@Test
	public void getAllRoles() throws Exception {
		Role role = new Role();
		role.setName("candidate");
		
		List<Role> roles = singletonList(role);
		
		given(roleController.getRoles()).willReturn(roles);
				
		mvc.perform(get("all").contentType(APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].name", is(role.getName())));
	}
}
