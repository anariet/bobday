package andrianov.dmitriy.test_app.domain.database;

import andrianov.dmitriy.test_app.domain.database.Country;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "regional_block", schema = "public")
public class RegionalBlock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "acronym")
    private String acronym;
    @Column(name = "name")
    private String name;
    @Column(name = "other_acronyms")
    @ElementCollection(targetClass = String.class)
    private List<String> otherAcronyms;
    @Column(name = "other_names")
    @ElementCollection(targetClass = String.class)
    private List<String> otherNames;
    @OneToOne(mappedBy = "regionalBlock")
    private Country country;
}
