package 정렬;

import java.util.*;

public class KthNumber {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int a = 0; a < commands.length; a++) {
            int x = 0;
            int start = commands[a][0] - 1;
            int end = commands[a][1] - 1;
            int check = commands[a][2] - 1;
            int[] sto = new int[end - start + 1];
            for (int b = 0; b < array.length; b++) {
                if (start <= b && b <= end) {
                    sto[x] = array[b];
                    x++;
                }
            }
            Arrays.sort(sto);
            answer[a] = sto[check];
        }
        return answer;
    }
}