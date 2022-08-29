package Task1;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static void readFile() throws FileNotFoundException {
        BufferedReader bufferedReader;
        try {
            FileReader fileReader = new FileReader("src/Files/Task1.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                Pattern pattern_1 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\) \\d{3}-\\d{4}");
                if (pattern_1.matcher(line).find()) {
                    System.out.println(line);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Exception during reading file. " + ex);
        }
    }
}
