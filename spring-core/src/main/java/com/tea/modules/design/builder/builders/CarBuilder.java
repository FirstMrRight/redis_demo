package com.tea.modules.design.builder.builders;


import com.tea.modules.design.builder.cars.Car;
import com.tea.modules.design.builder.cars.CarType;
import com.tea.modules.design.builder.components.Engine;
import com.tea.modules.design.builder.components.GPSNavigator;
import com.tea.modules.design.builder.components.Transmission;
import com.tea.modules.design.builder.components.TripComputer;

/**
 * @author Liutx
 * @date 2021/1/19 21:46
 * @Description
 */
public class CarBuilder implements Builder {

    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;


    @Override
    public void setCarType(CarType type) {
        this.type = type;
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

    /**
     * 构建结果对象
     * @return
     */
    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
