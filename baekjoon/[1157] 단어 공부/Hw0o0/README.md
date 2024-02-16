# [1157] 단어 공부 오답 노트

## :pushpin: **Algorithm**

알고리즘

- 구현
- 문자열

## :round_pushpin: **Logic**

- 수정 전

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class WordStudy1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = st.nextToken().toUpperCase();
        int sto = 0;
        String max = null;
        String[] list = word.split("");
        for (String ch : list) {
            if (Objects.equals(max, ch)) {
                continue;
            }
            if (sto == charCount(word, ch)) {
                max = "?";
            } else if (sto < charCount(word, ch)) {
                sto = charCount(word, ch);
                max = ch;
            }
        }
        System.out.println(max);
    }

    public static int charCount(String word, String ch) {
        return word.length() - word.replace(ch, "").length();
    }
}

 ```

- 수정 후

 ```java
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

 ```

수정 전

- 입력한 문자열을 대문자로 변환한 훟 문자를 놔눠서 배열에 넣어준다. 배열을 for문으로 돌리면서 max와 문자가 같으면 넘어가고 sto와 문자열 갯수가 같으면 max는 "?"를
  가진다.
- sto보다 문자의 수가 많으면 max는 for문의 현재 문자이고 sto는 charCount 메소드를 통해 단어의 길이에 문자열의 갯수를 넣어준다. 그리고 문자열이 가장 큰
  max 문자열을 출력해준다.
  수정 후
- word를 대문자로 변환 후 반복문을 통해 문자열의 갯수를 구하고, charCounts에 값을 더해준다. 만약 charCounts에 해당 문자열이 없다면 1로 만들어
  charCounts에 put해준다.
- 조건문을 통해서 문자열의 수가 가장 큰 수였던 문자열과 비교하여 크면 정보를 변경해주고, 만약 갯수가 같다면 maxChar만 "?"로 변경해준다.
- 그럼 원하는 최대 갯수를 가진 문자열을 찾을수 있다.
- ## :black_nib: **Review**

- 시간이 부족해 풀지 못했다.생각을 너무 많이 한것 같다.
- 막상 풀이를 보며 원래 코드를 수정하며 풀어보니 엄청 쉬운것이었다.
- 자바 기초와 메모리 사용량을 줄이는 방법도 좀 더 열심히 공부해야 될 필요를 느낀다.