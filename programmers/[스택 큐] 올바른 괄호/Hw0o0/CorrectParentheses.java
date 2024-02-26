import java.util.*;

public class CorrectParentheses {

    boolean solution(String s) {
        int openCnt = 0;
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            queue.add(c);
        }

        while (!queue.isEmpty()) {
            char word = queue.poll();
            if (word == '(') {
                openCnt++;
            } else {
                if (openCnt == 0) {
                    return false;
                }
                openCnt--;
            }
        }

        return openCnt == 0;
    }
}