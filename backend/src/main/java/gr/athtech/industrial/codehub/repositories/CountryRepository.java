package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author George Lalas
 */
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

    Country findCountryByIsoCode(String isoCode);

}
