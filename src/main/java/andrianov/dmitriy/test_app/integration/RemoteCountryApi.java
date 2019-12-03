package andrianov.dmitriy.test_app.integration;

import andrianov.dmitriy.test_app.domain.integration.RemoteCountry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class RemoteCountryApi implements CountryApi {
    private final RestTemplate restTemplate;
    private @Value("${remote.country.url}") String host;
    private static final String ENDPOINT_GET_ALL_COUNTRIES="/rest/v2/all";

    @Override
    public List<RemoteCountry> getAllCountries() {
        try {
            RemoteCountry[] countries = restTemplate.getForObject(host + ENDPOINT_GET_ALL_COUNTRIES, RemoteCountry[].class);
            return Objects.nonNull(countries) ?
                    Arrays.asList(countries) : Collections.emptyList();
        } catch (HttpServerErrorException | HttpClientErrorException ex){
            log.error("error while getting countries from url={}, status code: {}",
                    host+ENDPOINT_GET_ALL_COUNTRIES, ex.getStatusCode());
            return Collections.emptyList();
        }

    }
}
