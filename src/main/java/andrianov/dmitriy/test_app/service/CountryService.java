package andrianov.dmitriy.test_app.service;

import andrianov.dmitriy.test_app.domain.database.Country;
import andrianov.dmitriy.test_app.integration.RemoteCountryApi;
import andrianov.dmitriy.test_app.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;
    private final RemoteCountryApi api;
    private static final String PERCENT_SYMBOL = "%";

    @PostConstruct
    public void init(){
        countryRepository.deleteAll();
        log.info("all countries removed from database.");
        List<Country> countries = api.getAllCountries();
        countryRepository.saveAll(countries);
        log.info("saved {} new countries.", countries.size());
    }

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public void removeAllCountries(){
        countryRepository.deleteAll();
    }

    public List<Country> getCountriesByName(String name){
        return countryRepository.findCountriesByNameIgnoreCase(name);
    }

    public List<Country> getCountriesByDomainLike(String domain){
        return countryRepository.findByDomainsLike(String.format("%s%s%s", PERCENT_SYMBOL, domain, PERCENT_SYMBOL));
    }


}
