package com.baeldung.springsoap.gen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

//@Endpoint – registers the class with Spring WS as a Web Service Endpoint
@Endpoint
public class CountryEndpoint {
 
    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";
 
    private CountryRepository countryRepository;
 
    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
 
    //@PayloadRoot – defines the handler method according to the namespace and localPart attributes
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload //@ResponsePayload – indicates that this method returns a value to be mapped to the response payload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) { 
    	//@RequestPayload – indicates that this method accepts a parameter to be mapped from the incoming request

        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
 
        return response;
    }
}
