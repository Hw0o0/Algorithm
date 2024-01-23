# [1927] 최소 힙

## :pushpin: **Algorithm**

알고리즘
- 자료 구조
- 우선순위 큐
## :round_pushpin: **Logic**

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinimumHip1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int a = 0; a < N; a++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.add(x);
            }
        }
        System.out.println(sb);
    }
}



 ```

- 연산의 개수인 N 값을 넣어주고 반복문을 통해 N만큼 배열에 자연수 x를 넣고, 그와 동시에 x가 0이라면 배열에서 가장 작은 수를 출력후 배열에서 제거하고,0이 아니라면 배열에 x를 추가해준다. 
- ## :black_nib: **Review**
- 값을 출력하는것은 쉬운데, 시간을 단축하는것에 시간이 소요됐다.