# [1138] 한 줄로 서기

## :pushpin: **Algorithm**

알고리즘
- 구현
## :round_pushpin: **Logic**

 ```java
import java.util.Scanner;
public class StandOneLine1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = new int[n+1];
        for (int x = 1; x <= n; x++) {
            int sequence = sc.nextInt();
            for (int y = 1; y <= n; y++) {
                if (sequence == 0) {
                    if (result[y] == 0) {
                        result[y] = x;
                        break;
                    }
                } 
                else if (result[y] == 0) {
                    sequence--;
                }
            }
        }
        for (int a = 1; a <= n; a++) {
            System.out.println(result[a]);
        }
    }
}


 ```

- 먼저 n명의 사람 수를 정하고, 첫 반복문을 통해 사람들의 순서를 정해준다. 두번쨰 반복문을 통해서 사람들을 자신의 순서에 맞게 세운다.
- 두번째 반복문에서 if(sequence == 0)이고 if(result[y] == 0)은 내 앞에 나보다 키가 큰 사람이 없다면 바로 그 자리에 세운다.
- else if(result[y]==0)에서 sequence--를 해주어서 앞에 if(sequence == 0)이 만족할 수 있도록 하여 자신의 키에 맞는 자리에 앉을 수있게 해주었다. 
## :black_nib: **Review**

- 배열의 기초에 대해 다시 공부할 필요를 느꼈다.
- 상황에 따라 필요한 컬렌션이 무엇인지를 몰라서 시간이 많이 소요되었던 것 같다.