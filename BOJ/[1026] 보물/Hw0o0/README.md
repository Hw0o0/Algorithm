# [1026] 보물

## :pushpin: **Algorithm**

알고리즘
- 수학
- 그리디 알고리즘
- 정렬
## :round_pushpin: **Logic**

 ```java
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Treasure1026 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = 0;
        int[] x = new int[N];
        int[] y = new int[N];

        for(int a = 0; a < N; a++){
            x[a] = sc.nextInt();
        }
        for(int b = 0; b < N; b++){
            y[b] = sc.nextInt();
        }
        Arrays.sort(x);
        int[] z = Arrays.stream(y).boxed().sorted(Collections.reverseOrder())
            .mapToInt(Integer :: intValue).toArray();

        for(int a = 0; a < N; a++){
            S += x[a] * z[a];
        }
        System.out.println(S);
    }
}



 ```

- x 배열을 낮은 순으로 정렬해주고, y 배열을 높은 순으로 배열해서 각 Index번호끼리 곱하여 모든 값을 더하면 최소값인 S가 나온다.
- ## :black_nib: **Review**

- 자바 배열 기초에 대해 조금 더 공부할 필요가 있다고 생각한다.