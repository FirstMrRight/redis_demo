package com.tea.modules.design.builder.components;

/**
 * @author Liutx
 * @date 2021/1/18 22:21
 * @Description 产品特征2
 */
public class GPSNavigator {
    private String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }

    /**
     * 有参构造方法
     * @param manualRoute
     */
    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}
