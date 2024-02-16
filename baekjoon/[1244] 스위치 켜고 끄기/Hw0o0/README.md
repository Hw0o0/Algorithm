~~# [1244] 스위치 켜고 끄기 오답 노트

## :pushpin: **Algorithm**

알고리즘

- 구현
- 시뮬레이션

## :round_pushpin: **Logic**

수정 전

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchOnAndOff1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchAmount = Integer.parseInt(br.readLine());
        int jender, num;
        int[] switchInfo = new int[switchAmount];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int a = 0; a < switchAmount; a++) {
            switchInfo[a] = Integer.parseInt(st.nextToken());
        }

        int personAmount = Integer.parseInt(br.readLine());

        for (int b = 0; b < personAmount; b++) {
            st = new StringTokenizer(br.readLine());
            jender = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());
            int cnt = 1;

            if (jender == 1) {
                for (int c = 0; c < switchAmount; c++) {
                    if ((c + 1) % num == 0) {
                        if (switchInfo[c] == 0) {
                            switchInfo[c] = 1;
                        } else if (switchInfo[c] == 1) {
                            switchInfo[c] = 0;
                        }
                    }
                }
            }
            if (jender == 2) {
                num -= 1;
                if (switchInfo[num] == 0) {
                    switchInfo[num] = 1;
                } else if (switchInfo[num] == 1) {
                    switchInfo[num] = 0;
                }

                while (num - cnt >= 0 && num + cnt < switchAmount) {
                    if (switchInfo[num + cnt] == switchInfo[num - cnt]) {
                        if (switchInfo[num + cnt] == 0) {
                            switchInfo[num + cnt] = 1;
                            switchInfo[num - cnt] = 1;
                        } else if (switchInfo[num - cnt] == 1) {
                            switchInfo[num + cnt] = 0;
                            switchInfo[num - cnt] = 0;
                        }
                        cnt++;
                    }
                }
            }
        }
        for (int d = 0; d < switchInfo.length; d++) {
            System.out.print(switchInfo[d] + " ");
            if ((d + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}
 ```

## :round_pushpin: **Logic**

수정 후

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchOnAndOff1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchAmount = Integer.parseInt(br.readLine());
        int[] switchInfo = new int[switchAmount];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int a = 0; a < switchAmount; a++) {
            switchInfo[a] = Integer.parseInt(st.nextToken());
        }

        int personAmount = Integer.parseInt(br.readLine());

        for (int b = 0; b < personAmount; b++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                int index = num - 1;
                while (index < switchAmount) {
                    switchInfo[index] ^= 1;
                    index += num;
                }
            } else if (gender == 2) {
                int index = num - 1;
                switchInfo[index] ^= 1;

                int left = index - 1;
                int right = index + 1;
                while (left >= 0 && right < switchAmount && switchInfo[left] == switchInfo[right]) {
                    switchInfo[left] ^= 1;
                    switchInfo[right] ^= 1;
                    left--;
                    right++;
                }
            }
        }
        for (int d = 0; d < switchInfo.length; d++) {
            System.out.print(switchInfo[d] + " ");
            if ((d + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}

 ```

- 코드의 수를 먼저 받고 반복문을 통해 코드의 값들을 받아준다.그리고 사람들의 수를 입력받고 그 사람의 성별과 정수를 받는다.
- 받은 값으로 남자일떄와 여자일떄를 나누고 남자일땐 입력받은 수의 배수일떄의 값을 반전시켜주고 여자일때 입력받은 수의 인덱스 수와 전과 후의 값과 같으면 수를 전환 시켜주고 또
  다음 전과 후가 같으면 또 전환시켜준다.
- 그리고 모든 결과가 끝나면 출력을해주는데 20개의 값이 출력되면 다음 칸으로 출력되게 해준다.
- ## :black_nib: **Review**
- 문제를 구현하는데 시간이 조금 들었다.그렇게 문제를 구현를 하고나니 시간초과 떄문에 수정한다고 시간을 많이 소요했다.
- 이 문제를 구현할떄 xor연산자 ^을 사용해도 된다든 것을 알았다. xor연산자 ^은 너무 생소해서 사용해본적이 없었다.
- 자바의 기초 공부를 더 해야겠다고 한번 더 생각하게 된 문제같다.~~ 
