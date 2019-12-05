package andrianov.dmitriy.test_app.domain.api;

import andrianov.dmitriy.test_app.domain.database.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestCurrency {
    private String code;
    private String name;
    private String symbol;

    public RestCurrency(Currency currency){
        if(Objects.nonNull(currency)) {
            this.code = currency.getCode();
            this.name = currency.getName();
            this.symbol = currency.getSymbol();
        }
    }
}
