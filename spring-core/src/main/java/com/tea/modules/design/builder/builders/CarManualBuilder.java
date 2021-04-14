package com.tea.modules.design.builder.builders;


import com.tea.modules.design.builder.cars.CarType;
import com.tea.modules.design.builder.cars.Manual;
import com.tea.modules.design.builder.components.Engine;
import com.tea.modules.design.builder.components.GPSNavigator;
import com.tea.modules.design.builder.components.Transmission;
import com.tea.modules.design.builder.components.TripComputer;

/**
 * @author Liutx
 * @date 2021/1/19 21:59
 * @Description Unlike other creational patterns, Builder can construct unrelated products,which don't have the common interface.
 * In this case we build a user manual for a car, using the same steps as we built a car.
 * This allows to produce manuals for specific car models,
 * configured with different features.
 * 根据说明书构建对象
 */
public class CarManualBuilder implements Builder {
    private CarType carType;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Manual getResult() {
        return new Manual(carType, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
