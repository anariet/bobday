package andrianov.dmitriy.test_app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "translation", schema = "public")
public class Translation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "de")
    private String de;
    @Column(name = "es")
    private String es;
    @Column(name = "fr")
    private String fr;
    @Column(name = "ja")
    private String ja;
    @Column(name = "it")
    private String it;
    @Column(name = "br")
    private String br;
    @Column(name = "pt")
    private String pt;
    @Column(name = "nl")
    private String nl;
    @Column(name = "hr")
    private String hr;
    @Column(name = "fa")
    private String fa;
    @OneToOne(mappedBy = "translations")
    private Country country;
}
