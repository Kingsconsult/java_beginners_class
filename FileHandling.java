import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandling {
    public static void main(String[] args) {
        
        String directoryPath = "C:/Users/kings/OneDrive/Documents/dev/Java";
        String fileName = "ecobankt.txt";
        
        String filePath = Paths.get(directoryPath, fileName).toString();
        deleteAFile(filePath);
        
        createAndWriteToFile();
        readFromAFile();
    }

    private static void createAndWriteToFile() {
        try {
            FileWriter fileWriter = new FileWriter("ecobankt.txt", true);
            fileWriter.write("\n");
            fileWriter.write("This is the second line");
            fileWriter.write("\n");
            fileWriter.write("The third line");
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readFromAFile() {
        try (FileReader fileReader = new FileReader("ecobankt.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("error reading from the file");
        }
    }

    private static void deleteAFile(String filePath) 
    {
        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }        
    } 
}
