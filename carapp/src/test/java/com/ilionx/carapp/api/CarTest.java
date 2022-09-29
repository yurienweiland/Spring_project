package com.ilionx.carapp.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CarTest {

    private Car car;

    @Test
    public void testGetSetBrand() {

        car = new Car();
        car.setBrand("Mercedes");

        assertEquals("Mercedes", car.getBrand());
    }


}
