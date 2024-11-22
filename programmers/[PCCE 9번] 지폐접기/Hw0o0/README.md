# [PCCP 1번] 분대 감기

## :pushpin: **Algorithm**

알고리즘

- 구현

## :round_pushpin: **Logic**

 ```java
import java.util.*;
public class FoldBill {
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        Arrays.sort(wallet);
        Arrays.sort(bill);

        while (!sizeCheck(wallet, bill)) {
            half(bill);
            answer++;
        }
        return answer;
    }

    private static void half(int[] bill) {
        if (bill[0] > bill[1]) {
            bill[0] /= 2;
        } else {
            bill[1] /= 2;
        }
    }
    private static boolean sizeCheck(int[] wallet, int[] bill) {
        Arrays.sort(wallet);
        Arrays.sort(bill);

        return bill[0] <= wallet[0] && bill[1] <= wallet[1];
    }
}


 ```

- 먼저 반복문을 돌려서 지갑에 지폐가 들어갈 때까지 해주고, 만약 지폐가 들어가지 않는다면 지폐를 접어주도록 하였다, 지폐를 접을때마다 answer 1회씩 늘려주었다.
- ## :black_nib: **Review**

- 천천히 읽으며 푸니까 다른 문제보다는 금방 해결한 것 같다