import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    private String directory;
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Properties properties = new Properties();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("config.properties"));
            properties.load(reader);
            directory = properties.getProperty("data");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}