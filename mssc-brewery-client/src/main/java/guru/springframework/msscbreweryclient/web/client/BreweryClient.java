package guru.springframework.msscbreweryclient.web.client;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.springframework.msscbreweryclient.web.model.BeerDto;

@Component
@ConfigurationProperties(prefix = "sfg.brewery" , ignoreUnknownFields = false)
public class BreweryClient {
	
	public final String BEER_URI_V1= "/api/v1/beers/";
	private String apihost;
	
	private RestTemplate restTemplate;
	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate= restTemplateBuilder.build();
	}
	
	public BeerDto getBeerById(UUID beerId) {
		return restTemplate.getForObject(
				apihost + BEER_URI_V1 + beerId, BeerDto.class);
	}

	public void setApiHost(String apiHost) {
		this.apihost = apiHost;
	}
	
	
	
	
	

}
