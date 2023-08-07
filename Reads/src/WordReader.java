import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class WordReader implements Iterable<String> {

    public String file;

    public WordReader(String file){
        this.file = file;
    }
    public String WReader( String file) throws IOException {

        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);

        String line = "";
        String result = "";

        while((line = bReader.readLine()) != null) {
            result += line + "\n";
        }

    bReader.close();

    return result;

    }


    @Override
    public Iterator<String> iterator() {

        return new WordIterator();
    }
    private class WordIterator implements Iterator<String> {
        private BufferedReader reader;
        private String currentWord;

        public WordIterator() {
            try {
                reader = new BufferedReader(new FileReader("Resource/menu.txt"));
                currentWord = reader.readLine();
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao ler");
            }
        }

        @Override
        public boolean hasNext() {
            return currentWord != null;
        }

        @Override
        public String next() {
            String word = currentWord;

            try {
                currentWord = reader.readLine();
                if (currentWord == null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Wrong way ");
            }
            return word;

        }
    }

   /* public WordReader (String file){
        this.file = file;

    }|*/




}
