package andrianov.dmitriy.test_app.domain.integration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionalBlock {
    private String acronym;
    private String name;
    private List<String> otherAcronyms;
    private List<String> otherNames;
}
