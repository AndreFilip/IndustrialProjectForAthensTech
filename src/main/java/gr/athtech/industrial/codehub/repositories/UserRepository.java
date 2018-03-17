package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findUserByEmail(String email);

    User findUserByUsername(String username);


}
