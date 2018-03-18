package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author George Lalas
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    Role findRoleByName(String name);
}
