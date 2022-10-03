package com.ilionx.carapp.model;

import jdk.jfr.DataAmount;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    private String licensePlate;
    private int mileage;
    private String brand;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;


    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", mileage=" + mileage +
                ", brand='" + brand + '\'' +
                ", id=" + id +
                '}';
    }
}
