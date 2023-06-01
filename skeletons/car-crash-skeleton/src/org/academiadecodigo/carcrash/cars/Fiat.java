package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Fiat extends Car {

    public Fiat(Position pos){
        super(CarType.FIAT,pos);
    }

    public String toString() {
    return "F";
    }
}
