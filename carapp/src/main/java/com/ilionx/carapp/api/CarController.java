package com.ilionx.carapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<Iterable<Car>> list() {
        return ResponseEntity.ok(carRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car car) {
        return ResponseEntity.ok(this.carService.save(car));
    }
    @GetMapping("brand/{brand}")
    public ResponseEntity<List<Car>> findByBrand(@PathVariable("brand") String merk) {
        return ResponseEntity.ok(this.carService.findByBrand(merk));
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> findById(@PathVariable long id) {
        Optional<Car> optionalCar = this.carRepository.findById(id);
        if(optionalCar.isPresent()) {
            return ResponseEntity.ok(optionalCar.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("merk/{Brand}")
    public ResponseEntity<List<Car>> findbyBrand(@PathVariable String Brand){
        List<Car> cars = this.carRepository.findByBrand(Brand);

            return ResponseEntity.ok(cars);


    }



    @PutMapping("{id}")
    public ResponseEntity<Car> updateById(@PathVariable long id, @RequestBody Car source) {
        Optional<Car> optionalBeer = this.carRepository.findById(id);
        if(optionalBeer.isPresent()) {
            Car target = optionalBeer.get();
            target.setBrand(source.getBrand());
            target.setLicensePlate(source.getLicensePlate());
            target.setMileage(source.getMileage());

            return ResponseEntity.ok(this.carRepository.save(target));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Car> deleteById(@PathVariable long id) {
        Optional<Car> optionalCar = this.carService.findById(id);
        if (optionalCar.isPresent()) {
            this.carService.deleteById(id);

            return ResponseEntity.noContent().build();
        } else {

            return ResponseEntity.notFound().build();
        }
    }



}

