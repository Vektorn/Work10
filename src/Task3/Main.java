package Task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        readWords();
    }
    private static void readWords() throws IOException {
        String text = new String(Files.readAllBytes(Path.of("src/Files/words.txt")));
        text = text.replaceAll("\r\n", " ");
        HashMap<String, Integer> wordsStat = new HashMap<>();

        String[] words = text.split(" ");
        for (String word : words) {
            if (!word.isBlank())
                wordsStat.put(word, wordsStat.getOrDefault(word, 0) + 1);
        }
        for (var entry: wordsStat.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
