package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.Programs;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
*
* @author Panagiotis Kourempanas
*/

public interface ProgramsRepository extends PagingAndSortingRepository<Programs, Long> {
	List<Programs> findProgramsByProgramTitle(String programTitle);
	List<Programs> findProgramsByCategory(String category);
	// find with price under certain amount
	List<Programs> findProgramsByPrice(String price);
}
