package andrianov.dmitriy.test_app.util;

import andrianov.dmitriy.test_app.domain.api.RestCountry;
import andrianov.dmitriy.test_app.domain.database.Country;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utilities {

    public static List<RestCountry> convertCountries(List<Country> countryList){
        return !CollectionUtils.isEmpty(countryList) ?
                countryList.stream()
                        .map(RestCountry::new)
                        .collect(Collectors.toList()) :
                Collections.emptyList();
    }
}
