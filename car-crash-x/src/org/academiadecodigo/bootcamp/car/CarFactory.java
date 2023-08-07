package org.academiadecodigo.bootcamp.car;


import org.academiadecodigo.bootcamp.grid.Grid;

/**
 * A factory of different types of Cars
 */
public class CarFactory {

    /**
     * Manufactures new random cars
     *
     * @return a newly instantiated car
     */
    public static Car getNewCar(Grid grid) {

        int random = (int) (Math.random() * CarType.values().length);
        CarType carType = CarType.values()[random];

        Car car;

        switch (carType) {
            case PORRAS:
                car = new Porras(grid.makeGridPosition(20,20));
            case MERDA:
                car = new Merda(grid.makeGridPosition(10,10));
                break;
            default:
                car = new Porras(grid.makeGridPosition());
        }

        return car;

    }

}
