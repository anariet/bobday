package andrianov.dmitriy.test_app.repository;

import andrianov.dmitriy.test_app.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
