package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class BeerCommandLineRunner implements CommandLineRunner {

    private final BeerRepository repository;

    public BeerCommandLineRunner(BeerRepository repository) {
        // System.out.println("This is CommandLineRunner");
        this.repository = repository;
    }

    public boolean Test(){
        System.out.println(this.repository.count());
        return false;
    }

    @Override
    public void run(String... strings) throws Exception {
        // Top beers from https://www.beeradvocate.com/lists/top/
        System.out.print(this.Test());
        Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
                "Budweiser", "Coors Light", "PBR").forEach(name ->
                repository.save(new Beer(name))
        );
        // repository.findAll().forEach(System.out::println);
        // System.out.print(this.Test());
        // repository.deleteAll();;

       System.out.println( repository.count());
    }
}