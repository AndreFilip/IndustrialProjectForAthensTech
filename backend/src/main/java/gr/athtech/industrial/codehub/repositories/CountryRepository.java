package gr.athtech.industrial.codehub.repositories;

import gr.athtech.industrial.codehub.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author George Lalas
 * @edit Panagiotis Kourempanas
 */
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

    Country findCountryByIsoCode(String isoCode);
    Country findCountryByIsoCode3(String isoCode3);
    Country findCountryByPhoneCode(String phoneCode);
    Country findCountryByNumCode(String numCode);
    Country findCountryByNameView(String nameView);
    Country findCountryByNameCapital(String nameCapital);
    
}
