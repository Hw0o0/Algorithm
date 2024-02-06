# [2512] 예산 오답 노트

## :pushpin: **Algorithm**

알고리즘
- 이분 탐색
- 매개 변수 탐색
## :round_pushpin: **Logic**

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Budget2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int total = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for (int a = 0; a < N; a++) {
            int requestBudget = Integer.parseInt(st.nextToken());
            list.add(requestBudget);
            total += requestBudget;
        }

        st = new StringTokenizer(br.readLine());
        int nationalBudget = Integer.parseInt(st.nextToken());
        Collections.sort(list);

        if (total < nationalBudget) {
            System.out.println(list.get(N - 1));
        } else {

            int start = 0;
            int end = list.get(N - 1);
            int result = 0;

            while (start <= end) {
                int mid = (start + end) / 2;
                int sto = 0;
                for (int num : list) {
                    if (num < mid) {
                        sto += num;
                    } else {
                        sto += mid;
                    }
                }
                if (sto > nationalBudget) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                    result = Math.max(result, mid);
                }
            }
            System.out.println(result);
        }
    }
}


 ```

- 먼저 지방의 수를 입력해주고 각 지방의 예산요청 requestBudget 을 입력해준다. 그리고 총 예산 nationalBudget을 입력해준다.
- 첫 for문에서 total 값을 구해준다. 만약 nationalBudget보다 total이 낮으면 배정된 예산들 중에서 최댓값을 뽑아낸다.
- nationalBudget이 total보다 크다면 이분 탐색을 활용해서 최댓값을 뽑아내면 된다.
- ## :black_nib: **Review**

- 먼저 출력 값이 나오도록 코드를 짰는데 틀렸다해서 뭐가 문제지 하다가 이분 탐색을 활용해서 코드를 작성하는거였다.
- 이분 탐색을 몰라서 이해하고 이진 탐색 알고리즘을 활용해 풀어보았더니 쉽게 풀었것 같다.