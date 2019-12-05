package andrianov.dmitriy.test_app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country", schema = "public")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @JsonProperty("topLevelDomain")
    @Column(name = "domains")
    @ElementCollection(targetClass = String.class)
    private List<String> domains;
    @Column(name = "population")
    private Long population;
    @Column(name = "latlng")
    @ElementCollection(targetClass = Double.class)
    private List<Double> latlng;
    @OneToMany(mappedBy = "country")
    private Set<Currency> currencies;
    @OneToMany(mappedBy = "country")
    private Set<Language> languages;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "translation_id", referencedColumnName = "id")
    private Translation translations;
    @Column(name = "flag")
    private String flag;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regional_block_id", referencedColumnName = "id")
    private RegionalBlock regionalBlock;
}
