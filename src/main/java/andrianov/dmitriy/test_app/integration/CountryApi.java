package andrianov.dmitriy.test_app.integration;

import andrianov.dmitriy.test_app.domain.integration.RemoteCountry;

import java.util.List;

public interface CountryApi {
    List<RemoteCountry> getAllCountries();
}
