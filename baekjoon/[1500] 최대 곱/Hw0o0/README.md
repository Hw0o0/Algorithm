# [1500] 최대 곱

## :pushpin: **Algorithm**

알고리즘
- 수학
## :round_pushpin: **Logic**

 ```java
import java.util.Scanner;

public class MaxProduct1500 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        int S= 0;
        int K= 0;
        while(!check) {
            S = sc.nextInt();
            K = sc.nextInt();
            if (S <= 100 && S >= K) {
                check = true;
            }else {
                System.out.println("잘못된 입력 값입니다.");
            }
        }
        int share = S / K;
        int rest = S % K;
        long total = 1;
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
- 로직엔 문제가 없는데 계속 틀렸다고 해서 시간을 많이 소요했는데 알고보니 예외처리를 안해서 틀린거였다. 문제를 항상 잘 읽어야 될거같다.