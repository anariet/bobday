package andrianov.dmitriy.test_app.domain.api;

import andrianov.dmitriy.test_app.domain.database.RegionalBlock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestRegionalBlock {
    private String acronym;
    private String name;
    private List<String> otherAcronyms;
    private List<String> otherNames;

    public RestRegionalBlock(RegionalBlock regionalBlock){
        if(Objects.nonNull(regionalBlock)) {
            this.acronym = regionalBlock.getAcronym();
            this.name = regionalBlock.getName();
            this.otherAcronyms = regionalBlock.getOtherAcronyms();
            this.otherNames = regionalBlock.getOtherNames();
        }
    }
}
