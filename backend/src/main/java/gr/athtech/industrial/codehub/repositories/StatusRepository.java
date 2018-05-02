package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.Status;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StatusRepository extends PagingAndSortingRepository<Status, Long> {

    Status findStatusByName(String name);
}
