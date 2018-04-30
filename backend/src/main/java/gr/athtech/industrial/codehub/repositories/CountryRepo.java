package gr.athtech.industrial.codehub.repositories;


import gr.athtech.industrial.codehub.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepo extends PagingAndSortingRepository<Country, Long> {

    Country findCountryByIsoCode(String isoCode);

}
