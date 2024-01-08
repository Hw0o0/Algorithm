# [1057] 토너먼트

## :pushpin: **Algorithm**

알고리즘
- 수학
- 브루트포스 알고리즘
## :round_pushpin: **Logic**

 ```java
import java.util.Scanner;
public class Tournament1057 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int round = 0;
        if(a > n || n < b || a == b){
            round = -1;
            System.out.print(round);
            return;
        }
        while (true) {
            if(a == b){
                break;
            }
            a = a/2+a%2;
            b = b/2+b%2;
            round += 1;
        }
        System.out.print(round);
    }
}


 ```

- a,b가 무조건 이긴다는 가정하에 a/2를 나누어 몫과 나머지를 더하고,b도 같은 방법으로 해준다.
- 만약 a,b가 n보다 큰 값을 가지거나 a,b가 같은 값을 가지면 게임을 종료시킨다.
- 만약 a와 b 값이 같아질 때까지 라운드 수를 올려준다. a와 b가 같아 될떄 라운드 수를 멈추면 a와 b가 대결하는 라운드의 수를 알 수 있다.
- ## :black_nib: **Review**

- 모든 조건별로 if문을 만들 생각을 해서 시간을 많이 소요했다.