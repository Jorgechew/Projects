package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public class CarFactory {



    public static  Car getNewCar() {

        int col = (int)Math.random()* Field.getWidth();
        int row = (int) Math.random() * Field.getHeight();


        Car fiat = new Fiat(new Position(0000,000));
        //Car mustang = new Mustang((new Position(0001,001));


         return fiat;
        // return mustang;
    }
}
