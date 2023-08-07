package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridColor;

/**
 * Different types of cars
 */
public enum CarType {


    MERDA(GridColor.GREEN),
    PORRAS(GridColor.RED);

    private GridColor color;

    /**
     * Constructor of Car Types
     * @param color The car type color
     */
    CarType(GridColor color) {
        this.color = color;
    }

    public GridColor getColor() {

        return this.color;

    }
}
