package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<CodeHubUser, Long> {

    CodeHubUser findUserByEmail(String email);

    List<CodeHubUser> findCodeHubUserByRole(Role role);

    CodeHubUser findUserByUsername(String username);


}
