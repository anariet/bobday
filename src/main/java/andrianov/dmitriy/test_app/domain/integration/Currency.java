package andrianov.dmitriy.test_app.domain.integration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    private String code;
    private String name;
    private String symbol;
}
