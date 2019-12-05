package andrianov.dmitriy.test_app.domain.database;

import andrianov.dmitriy.test_app.domain.database.Country;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "currency", schema = "public")
public class Currency implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "symbol")
    private String symbol;
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
