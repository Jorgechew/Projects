import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        FileManager fileManager = new FileManager();

        try {
            FileManager.login();
        } catch (NotEnoughPermissionsException ex) {
            System.out.println(ex.getMessage()); // prints the exception message
        }

        try{
            FileManager.logout();
        } catch (NotEnoughPermissionsException ex) {
            System.out.println(ex.getMessage()); // prints the exception message
        }

        try{
            FileManager.getFile();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage()); // prints the exception message
        }

        try{
            FileManager.createFile();
        } catch (NotEnoughSpaceException ex) {
            System.out.println(ex.getMessage()); // prints the exception message
        }
    }
}