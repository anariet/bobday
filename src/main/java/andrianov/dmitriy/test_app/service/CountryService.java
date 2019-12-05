package andrianov.dmitriy.test_app.service;

import andrianov.dmitriy.test_app.domain.Country;
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

    @PostConstruct
    public void init(){
        countryRepository.deleteAll();
        log.info("all countries removed from database.");
        List<Country> countries = api.getAllCountries();
        countryRepository.saveAll(countries);
        log.info("saved {} new countries.", countries.size());
    }
}
