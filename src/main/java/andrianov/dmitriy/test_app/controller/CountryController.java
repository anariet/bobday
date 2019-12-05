package andrianov.dmitriy.test_app.controller;

import andrianov.dmitriy.test_app.domain.api.RestCountry;
import andrianov.dmitriy.test_app.domain.database.Country;
import andrianov.dmitriy.test_app.service.CountryService;
import andrianov.dmitriy.test_app.util.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/get_all")
    public ResponseEntity<List<RestCountry>> getCountries(){
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(Utilities.convertCountries(countries));
    }

    @GetMapping("/remove_all")
    public ResponseEntity<?> removeCountries(){
        countryService.removeAllCountries();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/get_by")
    public ResponseEntity<List<RestCountry>> getCountriesByName(@RequestParam(required = false) String name,
                                                                @RequestParam(required = false, name = "domain") String pattern){
        List<Country> countries;
        if(Objects.nonNull(name)) {
            countries = countryService.getCountriesByName(name);
            return ResponseEntity.ok(Utilities.convertCountries(countries));
        } else if(Objects.nonNull(pattern)) {
            countries = countryService.getCountriesByDomainLike(pattern);
            return ResponseEntity.ok(Utilities.convertCountries(countries));
        } else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
