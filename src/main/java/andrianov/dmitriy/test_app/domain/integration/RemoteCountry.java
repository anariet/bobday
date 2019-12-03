package andrianov.dmitriy.test_app.domain.integration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteCountry {
    private String name;
    @JsonProperty("topLevelDomain")
    private List<String> domains;
    private Long population;
    private List<Double> latlng;
    private List<Currency> currencies;
    private List<Language> languages;
    private Translation translations;
    private String flag;
}
