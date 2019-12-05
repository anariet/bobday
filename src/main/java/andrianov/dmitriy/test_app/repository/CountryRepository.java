package andrianov.dmitriy.test_app.repository;

import andrianov.dmitriy.test_app.domain.database.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findCountriesByNameIgnoreCase(String name);
    List<Country> findByDomainsLike(String pattern);
}
