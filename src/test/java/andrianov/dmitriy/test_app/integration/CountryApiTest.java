package andrianov.dmitriy.test_app.integration;

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
public class CountryApiTest {
    @Autowired CountryApi countryApi;

    @Test
    public void getAndSerializeTest() {
        List<Country> list = countryApi.getAllCountries();
        Assert.assertNotNull(list);
    }
}
