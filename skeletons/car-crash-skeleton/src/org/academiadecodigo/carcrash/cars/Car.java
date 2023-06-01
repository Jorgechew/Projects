package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

abstract  public class Car {

    /** The position of the car on the grid */
    private Position pos;

    private CarType carType;

    private String Newcar;
    private boolean crashed;

    public Car(CarType carType, Position pos){
        this.carType = carType;
        this.pos = pos;

    }
    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return false;
    }

    public void move() {
        int cols = getPos().getCol();
        int rows = getPos().getRow();

        int move = (int) (Math.random() * 4);
        getPos();
        switch (move) {
            case 0: cols ++;

        }
        pos = new Position(cols,rows);
    }
}
