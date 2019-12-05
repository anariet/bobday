package andrianov.dmitriy.test_app.integration;

import andrianov.dmitriy.test_app.domain.Country;

import java.util.List;

public interface CountryApi {
    List<Country> getAllCountries();
}
