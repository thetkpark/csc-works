import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> wordList = processFile(br -> {
            ArrayList<String> words = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : line.split(" ")) {
                    if (word.trim().equals("")) continue;
                    words.add(word.trim());
                }
            }
            return words;
        });

        Comparator<String> comp = (Comparator.comparingInt(String::length));
        wordList.sort(comp.reversed());
        System.out.println(wordList.get(0));
    }

    public static List<String> processFile(BufferedReaderProcessor p) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("call_of_the_wild.txt"));
        return p.process(br);
    }
}

@FunctionalInterface
interface BufferedReaderProcessor {
    List<String> process(BufferedReader b) throws IOException;
}
