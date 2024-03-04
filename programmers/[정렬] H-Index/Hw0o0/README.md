# [정렬] H-Index

## :pushpin: **Algorithm**

알고리즘

- 정렬

## :round_pushpin: **Logic**

 ```java
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


 ```

- 먼저 citations를 정렬해주고, 반복문을 통해서 만약 citations의 인용 횟수와 논문의 수를 줄여주면서 논문의 수보다 높으면 answer++을 해주면 된다.
- ## :black_nib: **Review**

- 문제를 이해하는데 시간이 걸렸다. 그것외에 어려운 점은 없었던 것 같다.