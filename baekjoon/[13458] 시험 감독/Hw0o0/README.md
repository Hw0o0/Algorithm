# [13458] 시험 감독

## :pushpin: **Algorithm**

알고리즘
- 수학
- 사칙연산
## :round_pushpin: **Logic**

 ```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestDirector13458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long total = 0;

        for (int i = 0; i < N; i++) {
            A[i] -= B;
            total += 1;

            if (A[i] > 0) {
                total += A[i] / C;
                if (A[i] % C > 0) {
                    total += 1;
                }
            }
        }
        System.out.println(total);
    }
}


 ```

- 각 시험장 N만큼 총 감독관이 오직 한명씩이라서 반복문 한번 돌아갈떄 마다 total을 +1 해주고 감독관 빠진 A[i] 값에 부 감독관이 감시 가능한 인원을 나눈 몫을 total에 더해주고 남는 인원이 있다면 부감독관을 한명 더 더해준다.
- ## :black_nib: **Review**

- 처음에 중첩 반복문으로 구현하다가 시간초과로 인해 코드 수정하는 시간이 소요된 것 말고는 대체로 쉽게 해결한 것 같다.