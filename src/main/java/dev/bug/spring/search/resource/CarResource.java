package dev.bug.spring.search.resource;

import com.sipios.springsearch.anotation.SearchSpec;
import dev.bug.spring.search.model.Car;
import dev.bug.spring.search.service.CarService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarResource {

    private final CarService carService;

    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> findByCriteria(@SearchSpec Specification<Car> specification) {
        return carService.findSpecs(specification);
    }
}
