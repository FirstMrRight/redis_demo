package com.tea.modules.design.builder.builders;

import com.tea.modules.design.builder.cars.CarType;
import com.tea.modules.design.builder.components.Engine;
import com.tea.modules.design.builder.components.GPSNavigator;
import com.tea.modules.design.builder.components.Transmission;
import com.tea.modules.design.builder.components.TripComputer;

/**
 * @author Liu-PC
 * @Description Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    /**
     * 汽车类型
     * @param carType
     */
    void setCarType(CarType carType);

    /**
     * 构建座位
     * @param seats
     */
    void setSeats(int seats);

    /**
     * 制造引擎
     * @param engine
     */
    void setEngine(Engine engine);

    /**
     * 制造变速箱
     * @param transmission
     */
    void setTransmission(Transmission transmission);

    /**
     * 制造行车电脑
     * @param tripComputer
     */
    void setTripComputer(TripComputer tripComputer);

    /**
     * 制造GPS
     * @param gpsNavigator
     */
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
