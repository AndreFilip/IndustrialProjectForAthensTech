package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.JobPosts;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author George Lalas
 */
public interface JobPostsRepository extends PagingAndSortingRepository<JobPosts, Long> {
}
