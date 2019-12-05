package andrianov.dmitriy.test_app.domain.api;

import andrianov.dmitriy.test_app.domain.database.Language;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestLanguage {
    @JsonProperty("iso639_1")
    private String isoOne;
    @JsonProperty("iso639_2")
    private String isoTwo;
    private String name;
    private String nativeName;

    public RestLanguage(Language language){
        if(Objects.nonNull(language)) {
            this.isoOne = language.getParamOne();
            this.isoTwo = language.getParamTwo();
            this.name = language.getName();
            this.nativeName = language.getNativeName();
        }
    }
}
