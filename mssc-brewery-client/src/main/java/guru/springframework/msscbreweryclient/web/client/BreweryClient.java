package guru.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.springframework.msscbreweryclient.web.model.BeerDto;

@Component
@ConfigurationProperties(prefix = "sfg.brewery" , ignoreUnknownFields = false)
public class BreweryClient {
	
	private String apihost;
	public final String BEER_PATH_V1= "/api/v1/beers/";
	
	private RestTemplate restTemplate;
	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate= restTemplateBuilder.build();
	}
	
	public BeerDto getBeerById(UUID beerId) {
		return restTemplate.getForObject(
				apihost + BEER_PATH_V1 + beerId, BeerDto.class);
	}
	
	public URI postBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
	}
	
	public void putBeer(UUID beerId, BeerDto beerDto) {
		restTemplate.put(apihost + BEER_PATH_V1 + beerId, beerDto);
	}
	
	public void deleteBeer(UUID beerId) {
		restTemplate.delete(apihost + BEER_PATH_V1 + beerId);
	}

	public void setApiHost(String apiHost) {
		this.apihost = apiHost;
	}
	
	
	
	
	

}
