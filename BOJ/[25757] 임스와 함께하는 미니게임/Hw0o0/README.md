# [25757] 임스와 함께하는 미니게임

## :pushpin: **Algorithm**

알고리즘
- 자료 구조
- 문자열
- 해시를 사용한 집합과 맵
## :round_pushpin: **Logic**

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MinigamewithEames25757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> names = new HashSet<>();

        for (int a = 0; a < N; a++) {
            st = new StringTokenizer(br.readLine());
            names.add(st.nextToken());
        }
        switch (game) {
            case "Y":
                System.out.println(names.size());
                break;
            case "F":
                System.out.println(names.size()/2);
                break;
            case "O":
                System.out.println(names.size()/3);
                break;
        }
    }
}


 ```

- 임스와 한번 같이 플레이한 사람과는 다시 플레이가 되지 않으니까 hashset으로 같은 이름이 들어오면 중복 제거해주고,names에 들어온 사람을 자신을 뺀 나머지 플레이 가능 인원으로 나누어주면 임스의 최대 게임 플레이 횟수를 구할수 있다.
- ## :black_nib: **Review**

- 계속 코딩 테스트를 풀다보니 어떤 자료구조를 사용해야할지 조금씩 감이 잡히는 것 같다.