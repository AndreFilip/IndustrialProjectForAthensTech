package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.Techstack;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author George Lalas
 * @edit Panagiotis Kourempanas
 */
public interface TechstackRepository extends PagingAndSortingRepository<Techstack, Long> {

	Techstack findTechstackByStack(String stack);
}
