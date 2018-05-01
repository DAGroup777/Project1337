package com.october.praytest.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class IdeaController {
    private IdeaRepository repository;

    public IdeaController(IdeaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/idea-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Idea> coolCars() {
        return repository.findAll().stream()
                .filter(this::isCool)
                .collect(Collectors.toList());
    }

    private boolean isCool(Idea car) {
        return !car.getName().equals("Aristocratic") &&
                !car.getName().equals("Economic") &&
                !car.getName().equals("Naval") &&
                !car.getName().equals("Plutocratic");
    }
}
