# [2075] N번쨰 가장 큰 수

## :pushpin: **Algorithm**

알고리즘
- 자료 구조
- 정렬
- 우선순위 큐
## :round_pushpin: **Logic**

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NthLargestNumber2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> sortGraph = new ArrayList<>();
        for(int a = 0; a < N; a++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int b = 0; b < N; b++){
                sortGraph.add(Integer.valueOf(st.nextToken()));
            }
        }
        Collections.sort(sortGraph,Collections.reverseOrder());
        System.out.println(sortGraph.get(N-1));
    }
}


 ```

-  N*N의 표에 채울 숫자들을 반복문을 통해서 넣어주고, 그 값들을 정렬시켜서 N-1번째의 값을 뽑아내면 정답이 나온다.
## :black_nib: **Review**

- 값을 찾는건 쉬웠는데 시간 초과를 해결하는데 시간을 많이 사용했다.