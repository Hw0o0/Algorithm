# [정렬] K번째수

## :pushpin: **Algorithm**

알고리즘

- 정렬

## :round_pushpin: **Logic**

 ```java
import java.util.*;

public class KthNumber {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int a = 0; a < commands.length; a++) {
            int x = 0;
            int i = commands[a][0] - 1;
            int j = commands[a][1] - 1;
            int k = commands[a][2] - 1;
            int[] sto = new int[j - i + 1];
            for (int b = 0; b < array.length; b++) {
                if (i <= b && b <= j) {
                    sto[x] = array[b];
                    x++;
                }
            }
            Arrays.sort(sto);
            answer[a] = sto[k];
        }
        return answer;
    }
}

 ```

- 반복문을 통해서 먼저 i번째부터 j번째까지의 값들을 변수에 담아주고,안에 반복문을 하나 더 생성해서 array에서 원하는 순서를 뽑아서 임시저장소인 sto에 저장시켜준다.
- 그리고 sto를 정렬시킨 후 배열안에서 찾고싶었던 k번째 자리의 값들을 answer에 저장시켜준다.
- ## :black_nib: **Review**

- 이전의 알고리즘들을 풀면서 정렬을 자주 사용해봐서 이번 문제는 쉽게 풀었던 것 같다.