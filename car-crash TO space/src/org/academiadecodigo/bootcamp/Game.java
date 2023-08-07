package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.car.MainChar;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridColor;

/**
 * The game logic
 */
public class Game {


    /**
     * Graphical Car field
     */
    private Grid grid;

    /**
     * Container of Cars
     */
    private Car[] cars;

    /**
     * Animation delay
     */
    private int delay;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    /**
     * Number of cars to manufacture
     */
    private int manufacturedCars = 20;


    /**
     * Constructs a new game
     * @param gridType which grid type to use
     * @param cols number of columns in the grid
     * @param rows number of rows in the grid
     * @param delay animation delay
     */
    public Game(Grid grid, int cols, int rows, int delay) {



    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        boolean keyboardSupport = grid instanceof SimpleGfxGrid;

        grid.init();


        if (keyboardSupport) {
            MainChar mainChar = new MainChar(grid.makeGridPosition());
            mainChar.getPos().setColor(GridColor.MAGENTA);
           // mainChar.setCollisionDetector(collisionDetector);

        }


        }

    }

