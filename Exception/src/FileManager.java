import java.io.FileNotFoundException;

public class FileManager  {
    public boolean login;

    public boolean logout;

    public void login() throws NotEnoughPermissionsException {
        if(login != false) {
            System.out.println("Great Sucess!!!");
            throw new NotEnoughPermissionsException();
            }
    }

    public void logout() throws NotEnoughPermissionsException {
        if (logout != true) {
            System.out.println("LOGOUT");
            throw new NotEnoughPermissionsException();
        }
    }
    public File getFile(String file) throws FileNotFoundException {
        return null;
    }

    public void createFile(String file,int n) throws NotEnoughSpaceException {
         File[] files = new File[n];

         for(int i = 0; i < files.length; i++){
             String fileName = file + '-' + i;
             files[i] = new File(file);
             System.out.println("File "+ fileName + "created. ");
         }
    }

    public boolean isLogin() {
        return login;
    }

    public boolean isLogout() {
        return logout;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public void setLogout(boolean logout) {
        this.logout = logout;
    }
}
