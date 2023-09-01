package org.academiadecodigo.carcrash.field;


public class Position {

    private int col;
    private int row;

    public Position(int col, int row) {
        this.col= (int)(Math.random()* Field.getWidth());
        this.row=(int)(Math.random() * Field.getHeight());
    }
    public int getCol() {

        return col;
    }


    public int getRow() {

        return row;
    }
}