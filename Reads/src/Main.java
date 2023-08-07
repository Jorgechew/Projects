import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

       WordReader wordReader = new WordReader("Resource/menu.txt");


        for (String word : wordReader){
           System.out.println(word);
       }




    }
}