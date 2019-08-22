package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class BeerController {
    private BeerRepository repository;

    public BeerController(BeerRepository repository) {
        System.out.println("This is Controller Class");
        this.repository = repository;
    }

    @GetMapping("/good-beers")
    public Collection<Beer> goodBeers() {
        System.out.println(repository);
        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
                
    }

    @RequestMapping("/add_beers")
    public int addBeers(@RequestParam String beerid) {

        System.out.println(beerid);
        repository.save(new Beer(beerid));
        return 1;
                
    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
    }
}