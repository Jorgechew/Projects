package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.position.GridPosition;

/**
 * Mustang is a fast and reliable car
 */
public class Porras extends Car {

    public final static int SPEED = 3;

    /**
     * Constructs a brand new Mustang
     *
     * @param pos the position of the car in the grid
     */
    public Porras(GridPosition pos) {
        super(pos, CarType.PORRAS);
    }

    /**
     * @see Car#move()
     */
    @Override
    public void move() {

        accelerate(chooseDirection(), Porras.SPEED);

    }
}
