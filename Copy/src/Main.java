import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public String read;
    public String write;
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("Resource/menu.txt");
        FileOutputStream outputStream = new FileOutputStream("Resource/NewMenu.txt");

            byte [] buffer = new byte[1024];
           int num;

            while ( (num = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, num);

            }
                inputStream.close();
                outputStream.close();
            }


        }




