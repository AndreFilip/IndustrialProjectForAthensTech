package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.UserStatus;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author George Lalas
 */
public interface UserStatusRepository extends PagingAndSortingRepository<UserStatus, Long> {
    UserStatus findUserStatusByCodeHubUser(CodeHubUser user);
}
