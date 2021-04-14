package com.tea.modules.design.builder.components;


import com.tea.modules.design.builder.cars.Car;

/**
 * @author Liutx
 * @date 2021/1/18 22:26
 * @Description
 */
public class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel() {
        System.out.println("Fuel level: " + car);
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }
}
