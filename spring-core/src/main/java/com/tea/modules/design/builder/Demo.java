package com.tea.modules.design.builder;


import com.tea.modules.design.builder.builders.CarBuilder;
import com.tea.modules.design.builder.builders.CarManualBuilder;
import com.tea.modules.design.builder.cars.Car;
import com.tea.modules.design.builder.cars.Manual;
import com.tea.modules.design.builder.director.Director;

/**
 * @author Liutx
 * @date 2021/1/19 22:19
 * @Description execute Demo
 */
public class Demo {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.constructCityCar(builder);
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
