package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<CodeHubUser, Long> {

    CodeHubUser findUserByEmail(String email);

    CodeHubUser findUserByUsername(String username);


}
