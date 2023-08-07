import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    private int PADDING = 10;
    private int cols = 500;
    private int rows = 500;

    private int cellSize = 25;



    private Rectangle rectangle;


    public Field() {

        rectangle = new Rectangle(PADDING, PADDING, cols , rows );
        rectangle.setColor(Color.CYAN);
        rectangle.draw();


        int horizontal = 35;
        int vertical = 35;

        for (int i = 0; (i < 20); i++) {
            Line line1 = new Line(vertical, 10, vertical, 510);
            Line line2 = new Line(10, horizontal, 510, horizontal);
            line1.draw();
            line2.draw();

            vertical = vertical + 25;
            horizontal = horizontal + 25;


        }
    }

        public int getCellSize() {
            return cellSize;
        }

        public int getCols() {
            return this.cols;
        }

        public int getRows() {
            return this.rows;
        }

    public int rowToY(int row) {
        return PADDING + cellSize * row;
    }

    public int columnToX(int column) {
        return PADDING + cellSize * column;
    }


}


