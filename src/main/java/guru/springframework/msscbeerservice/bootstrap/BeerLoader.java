package guru.springframework.msscbeerservice.bootstrap;


import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Viralata")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(337010000001L)
                    .price(new BigDecimal("10.00"))
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("RoberBier")
                    .beerStyle("APA")
                    .quantityToBrew(100)
                    .minOnHand(10)
                    .upc(337010000002L)
                    .price(new BigDecimal("11.40"))
                    .build());
        }
    }
}
