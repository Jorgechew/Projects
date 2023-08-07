import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import static org.academiadecodigo.simplegraphics.graphics.Color.*;

public class Player implements KeyboardHandler {

    private static int CELLSIZE = 25;

    public Rectangle painted[];
    Rectangle rectangle;

    public Player() {
        rectangle = new Rectangle(10, 10, 25, 25);
        rectangle.setColor(RED);
        rectangle.fill();
        keyboardInit();

    }

    public void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        //Right key
        KeyboardEvent rightPress = new KeyboardEvent();
        rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightPress.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent leftPress = new KeyboardEvent();
        leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftPress.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent upPress = new KeyboardEvent();
        upPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upPress.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent downPress = new KeyboardEvent();
        downPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downPress.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent spacePress = new KeyboardEvent();
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacePress.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent deletePress = new KeyboardEvent();
        deletePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        deletePress.setKey(KeyboardEvent.KEY_D);


        keyboard.addEventListener(rightPress);
        keyboard.addEventListener(leftPress);
        keyboard.addEventListener(upPress);
        keyboard.addEventListener(downPress);
        keyboard.addEventListener(spacePress);
        keyboard.addEventListener(deletePress);


    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                System.out.println("moving right");
                if (rectangle.getX() < 500 - CELLSIZE) {

                    rectangle.translate(25, 0);
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                System.out.println("moving left");
                if (rectangle.getX() > CELLSIZE) {
                    rectangle.translate(-25, 0);
                }
                break;

            case KeyboardEvent.KEY_UP:
                System.out.println("moving up");
                if (rectangle.getY() > CELLSIZE) {
                    rectangle.translate(0, -25);
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                System.out.println("moving down");
                if (rectangle.getY() < 500 - CELLSIZE) {
                    rectangle.translate(0, 25);
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                System.out.println("PAINT");
                Rectangle painted = new Rectangle(rectangle.getX(), rectangle.getY(), CELLSIZE,CELLSIZE);
                painted.setColor(RED);
                painted.draw();
                painted.fill();



                Rectangle painted1 = new Rectangle(rectangle.getX(), rectangle.getY(), CELLSIZE,CELLSIZE);
                painted1.setColor(BLACK);
                painted1.draw();
                


                break;

            case KeyboardEvent.KEY_D:
                System.out.println("DELETE");
                Rectangle delete = new Rectangle(rectangle.getX(), rectangle.getY(), CELLSIZE,CELLSIZE);
                delete.setColor(WHITE);
                delete.fill();


                System.out.println("DELETE");
                Rectangle delete1 = new Rectangle(rectangle.getX(), rectangle.getY(), CELLSIZE,CELLSIZE);
                delete1.setColor(BLACK);
                delete1.draw();
                break;

            case KeyboardEvent.KEY_P:
                    System.out.println("DELETE");
                    Rectangle changeColor= new Rectangle(rectangle.getX(), rectangle.getY(), CELLSIZE,CELLSIZE);
                    changeColor.setColor(WHITE);
                    changeColor.fill();

        }



    }




    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        //I don't want to use this one right now.
    }
}
