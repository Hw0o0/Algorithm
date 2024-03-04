import java.util.*;

public class H_Index {

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int a = 0; a < citations.length; a++) {
            if (citations.length - a <= citations[a]) {
                answer++;
            }
        }
        return answer;
    }
}
