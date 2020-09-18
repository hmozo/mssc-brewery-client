package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.BeerDto;

//Integration test
@SpringBootTest
public class BreweryClientTest {

	@Autowired
	BreweryClient breweryClient;
	
	@Test
	void getBeerById() {
		BeerDto beerDto= breweryClient.getBeerById(UUID.randomUUID());
		
		assertNotNull(beerDto);
	}
	
	@Test
	void postBeer() {
		BeerDto beerDto= BeerDto.builder().beerName("new Beer").build();
		
		URI uri= breweryClient.postBeer(beerDto);
		
		assertNotNull(uri);
	}
	
	@Test
	void putBeer() {
		BeerDto beerDto= BeerDto.builder().id(UUID.randomUUID()).beerName("Beer updated").build();
		breweryClient.putBeer(beerDto.getId(), beerDto);		
	}
	
	@Test
	void deleteBeer() {
		BeerDto beerDto= BeerDto.builder().id(UUID.randomUUID()).build();
		breweryClient.deleteBeer(beerDto.getId());
		
	}
}
