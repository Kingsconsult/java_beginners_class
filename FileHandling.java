import java.io.BufferedReader;
// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandling {

    public static void main(String[] args) {
        

        String directoryPath = "C://Users//TEMITOPE//Desktop//EcoJava";
        String fileName = "ecobank.txt";

        String filePath = Paths.get(directoryPath, fileName).toString();

        deleteAFile(filePath);
        
        createAndWriteToFile();
        readFromAFile();
        
        System.out.println("File deleted");

        // System.out.println(filePath);
    }

    private static void createAndWriteToFile() {
        try {

            // File file = new File("bank.txt");
            FileWriter fileWriter = new FileWriter("ecobank.txt", true);
            fileWriter.write("\n");
            fileWriter.write("I am writing to a File");
            fileWriter.write("\n");
            fileWriter.write("I am writing the second content to a File");
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readFromAFile() {
        try (
                FileReader fileReader = new FileReader("ecobank.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("error reading from the file");
        }
    }

    private static void deleteAFile(String filePath) {
        Path path = Paths.get(filePath);
        try{
            Files.delete(path);
        // }catch (FileNotFoundException e) {
        //     System.out.println(e.getMessage());
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
