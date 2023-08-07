import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Limits {

    private Rectangle rectangle;

    private Field field;

    public Limits (Field grid){

       field = grid;

       int x = field.rowToY(field.getRows());
       int y = field.columnToX(field.getCols());

       this.rectangle = new Rectangle(x, y, field.getCellSize(), field.getCellSize());

       show();

    }





    public void show() {
        this.rectangle.fill();
    }

    public void hide() {
        this.rectangle.delete();
    }




}
