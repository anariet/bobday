package andrianov.dmitriy.test_app.domain.api;

import andrianov.dmitriy.test_app.domain.database.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestCountry {
    private String name;
    private List<String> domains;
    private Long population;
    private List<Double> latlng;
    private Set<RestCurrency> currencies;
    private Set<RestLanguage> languages;
    private RestTranslation translations;
    private String flag;
    private RestRegionalBlock regionalBlock;

    public RestCountry(Country country){
        this.name=country.getName();
        this.domains=country.getDomains();
        this.population=country.getPopulation();
        this.latlng=country.getLatlng();
        this.currencies= !CollectionUtils.isEmpty(country.getCurrencies()) ?
                country.getCurrencies().stream()
                        .map(RestCurrency::new)
                        .collect(Collectors.toSet()) :
                new HashSet<>();
        this.languages=!CollectionUtils.isEmpty(country.getLanguages()) ?
                country.getLanguages().stream()
                        .map(RestLanguage::new)
                        .collect(Collectors.toSet()) :
                new HashSet<>();
        this.translations=new RestTranslation(country.getTranslations());
        this.flag=country.getFlag();
        this.regionalBlock=new RestRegionalBlock(country.getRegionalBlock());
    }
}
