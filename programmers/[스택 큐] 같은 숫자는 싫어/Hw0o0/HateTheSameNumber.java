import java.util.ArrayList;
import java.util.List;

public class HateTheSameNumber {

    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int a = 1; a < arr.length; a++) {
            if (list.get(list.size() - 1) != arr[a]) {
                list.add(arr[a]);
            }
        }
        int[] answer = new int[list.size()];
        int x = 0;
        for (int a : list) {
            answer[x] = a;
            x++;
        }
        return answer;
    }
}
