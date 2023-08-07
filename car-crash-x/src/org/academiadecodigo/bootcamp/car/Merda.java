package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.position.GridPosition;

/**
 * Mustang is a fast and reliable car
 */
public class Merda extends Car {

    public final static int SPEED = 3;

    /**
     * Constructs a brand new Mustang
     *
     * @param pos the position of the car in the grid
     */
    public Merda(GridPosition pos) {
        super(pos, CarType.MERDA);
    }

    /**
     * @see Car#move()
     */
    @Override
    public void move() {

        accelerate(chooseDirection(), Merda.SPEED);

    }
}
