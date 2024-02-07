import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class WordStudy1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();

        Map<Character, Integer> charCounts = new HashMap<>();
        int maxCount = 0;
        char maxChar = '?';

        for (char ch : word.toCharArray()) {
            int count = charCounts.getOrDefault(ch, 0) + 1;
            charCounts.put(ch, count);
            if (count > maxCount) {
                maxCount = count;
                maxChar = ch;
            } else if (count == maxCount) {
                maxChar = '?';
            }
        }
        System.out.println(maxChar);
    }
}
