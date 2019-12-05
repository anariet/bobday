package andrianov.dmitriy.test_app.domain.api;

import andrianov.dmitriy.test_app.domain.database.Translation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestTranslation {
    private String de;
    private String es;
    private String fr;
    private String ja;
    private String it;
    private String br;
    private String pt;
    private String nl;
    private String hr;
    private String fa;

    public RestTranslation(Translation translation){
        if(Objects.nonNull(translation)) {
            this.de = translation.getDe();
            this.es = translation.getEs();
            this.fr = translation.getFr();
            this.ja = translation.getJa();
            this.it = translation.getIt();
            this.br = translation.getBr();
            this.pt = translation.getPt();
            this.nl = translation.getNl();
            this.hr = translation.getHr();
            this.fa = translation.getFa();
        }
    }
}
