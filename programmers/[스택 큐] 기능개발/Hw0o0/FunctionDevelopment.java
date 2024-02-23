import java.util.*;

public class FunctionDevelopment {
    public static int takeTime(int remainingPercent, int speed) {
        int takeTime = 0;
        int currentPercent = 100 - remainingPercent;
        if (speed == 1) {
            takeTime = remainingPercent;
        } else {
            while (currentPercent < 100) {
                currentPercent += speed;
                takeTime++;
            }
        }
        return takeTime;
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> function = new ArrayList<>();
        for (int a = 0; a < progresses.length; a++) {
            int cnt = 1;
            int remainingPercent = 100 - progresses[a];
            int takeTime = takeTime(remainingPercent, speeds[a]);
            for (int b = a + 1; b < progresses.length; b++) {
                int nextRemainingPercent = 100 - progresses[b];
                int nextTakeTime = takeTime(nextRemainingPercent, speeds[b]);
                if (takeTime > nextTakeTime) {
                    cnt++;
                } else {
                    break;
                }
            }
            function.add(cnt);
            a += (cnt - 1);
        }

        int[] answer = new int[function.size()];
        for (int c = 0; c < function.size(); c++) {
            answer[c] = function.get(c);
        }
        return answer;
    }
}
