package dev.bug.spring.search.service;

import dev.bug.spring.search.model.Car;
import dev.bug.spring.search.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findSpecs(Specification<Car> specification) {
        return carRepository.findAll(Specification.where(specification));
    }
}
