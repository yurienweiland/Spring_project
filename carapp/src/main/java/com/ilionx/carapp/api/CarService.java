package com.ilionx.carapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    //@Autowired
    //private Coureur maxVerstappen;

    //@Autowired
    //private Coureur lewisHamilton;
    @Autowired
    private CarRepository carRepository;

    public <S extends Car> S saveAndFlush(S entity) {
        return carRepository.saveAndFlush(entity);
    }

    public <S extends Car> List<S> findAll(Example<S> example) {
        return carRepository.findAll(example);
    }

    @Value("${companyName}")
    private String companyName;

    public List<Car> findAll() {

       // System.out.println("Er is een courier maxie: " + this.maxVerstappen.getName());
        // System.out.println("Er is een courier lewis: " + this.lewisHamilton.getName());

       // System.out.println("Onze company name is nu: " + this.companyName);

        return carRepository.findAll();
    }

    //public <S extends Car> S save(S entity) {
    //    return carRepository.save(entity);
    // }

    public Optional<Car> findById(Long aLong) {
        return carRepository.findById(aLong);
    }

    public long count() {
        return carRepository.count();
    }

    public void deleteById(Long aLong) {
        carRepository.deleteById(aLong);
    }

    public Optional<Car> updateById(long id, Car input) {
        Optional<Car> optionalCar = this.carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car target = optionalCar.get();
            target.setLicensePlate(input.getLicensePlate());
            target.setBrand(input.getBrand());
            target.setLicensePlate(input.getLicensePlate());

            this.carRepository.save(target);
        }
        return optionalCar;
    }

    @Transactional
    public Car save(Car car) {
        Car savedCar = this.carRepository.save(car);

        // this is to demo the consequences of rolling back a Transaction
        if ("rollback".equals(savedCar.getBrand())) {
            System.out.println(3 / 0); // results in an ArithmeticException

            // The car should not be saved/updated now!!!
        }

        return savedCar;
    }
    public List<Car> findByBrand(String merk) {
        return carRepository.findByBrand(merk);
    }

    public List<Car> findByBrandAndLicensePlate(String brand, String licensePlate) {
        return carRepository.findByBrandAndLicensePlate(brand, licensePlate);
    }

    public List<Car> findByMileageLessThanOrderByBrandAsc(double maxMileage) {
        return carRepository.findByMileageLessThanOrderByBrandAsc(maxMileage);
    }

    public Optional<Car> findByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }

}

