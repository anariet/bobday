package andrianov.dmitriy.test_app.domain.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {
    @JsonProperty("iso639_1")
    private String paramOne;
    @JsonProperty("iso639_2")
    private String paramTwo;
    private String name;
    private String nativeName;

}
