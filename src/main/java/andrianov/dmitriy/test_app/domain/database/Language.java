package andrianov.dmitriy.test_app.domain.database;

import andrianov.dmitriy.test_app.domain.database.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "languages", schema = "public")
public class Language implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "iso639_1")
    @JsonProperty("iso639_1")
    private String paramOne;
    @Column(name = "iso639_2")
    @JsonProperty("iso639_2")
    private String paramTwo;
    @Column(name = "name")
    private String name;
    @Column(name = "native_name")
    private String nativeName;
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

}
