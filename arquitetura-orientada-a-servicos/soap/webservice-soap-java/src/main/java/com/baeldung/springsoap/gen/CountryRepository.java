package com.baeldung.springsoap.gen;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {

	private static final Map<String, Country> countries = new HashMap<>();

	@PostConstruct
	public void initData() {
		Country country = new Country();
		country.setName("Brasil");
		country.setPopulation(1000);
		country.setCapital("Brasilia");
		country.setCurrency(Currency.REAL);
		countries.put("BR", country);

		Country uk = new Country();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);

		countries.put("UK", uk);

	}

	public Country findCountry(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return countries.get(name);
	}
}
