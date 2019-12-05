package andrianov.dmitriy.test_app.service;

import andrianov.dmitriy.test_app.domain.database.Country;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CountryServiceTest {
    @Autowired CountryService countryService;
    private static final String AFGHANISTAN = "afghanistan";
    private static final String DOMAIN_PATTERN = ".a";

    @Test
    public void getCountriesByName() {
        List<Country> result = countryService.getCountriesByName(AFGHANISTAN);
        Assert.assertNotNull("result will not be empty!", result);
        Assert.assertEquals("method should return right country",
                result.get(0).getName().toLowerCase(), AFGHANISTAN);
    }

    @Test
    public void getCountriesByDomainLike() {
        List<Country> result = countryService.getCountriesByDomainLike(DOMAIN_PATTERN);
        Assert.assertNotNull("result will not be empty!", result);
    }
}
