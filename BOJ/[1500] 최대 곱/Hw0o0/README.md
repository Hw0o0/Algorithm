# [1500] 최대 곱

## :pushpin: **Algorithm**

알고리즘
- 수학
## :round_pushpin: **Logic**

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxProduct1500 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int share = S / K;
        int rest = S % K, total = 1;
        for (int a = 1; a <= K; a++) {
            if(a<=rest){
                total*=(share+1);
            }else{
                total*=share;
            }
        }
        System.out.println(total);
    }
}

 ```

- 먼저 S를 K등분으로 나누고 남는 rest 만큼 for문을 통해 share 값마다 1씩 더하고 최대 곱을 계산한다.그리고 남은 share도 곱해준다;
- ## :black_nib: **Review**

- 쉬운 알고리즘에도 불구하고 알고리즘을 너무 어렵게 생각해서 시간을 오래 사용한 것 같다.