# [탐욕법] 체육복

## :pushpin: **Algorithm**

알고리즘

- Greedy

## :round_pushpin: **Logic**

 ```java
import java.util.*;

public class gymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        for (int l : lost) {
            lostList.add(l);
        }
        for (int r : reserve) {
            reserveList.add(r);
        }


        //자기 체육복 잃어버렸는데 자기 여유복 있을 경우
        List<Integer> filteredLostList = new ArrayList<>();
        for (int lostStu : lostList) {
            if (reserveList.contains(lostStu)) {
                reserveList.remove(Integer.valueOf(lostStu)); //여유분 제거
            } else {
                filteredLostList.add(lostStu); // 여유분 없으면 잃어버린 학생으로 바꿈
            }
        }

        Collections.sort(filteredLostList);
        // 체육복이 없지만, 앞과 뒤 자리에 여분의 체육복을 빌린 경우
        int lend = 0;
        for (int lostStu : filteredLostList) {
            if (reserveList.contains(lostStu - 1)) {
                reserveList.remove(Integer.valueOf(lostStu - 1));
                lend++;
            } else if (reserveList.contains(lostStu + 1)) {
                reserveList.remove(Integer.valueOf(lostStu + 1));
                lend++;
            }
        }

        return n - filteredLostList.size() + lend;
    }
}


 ```

- 먼저 배열을 저가 자주 사용하던 ArrayList로 바꾸었고, 먼저 체육복을 잃어 버렸지만, 자신의 여유복이 있을경우를 먼저 처리해주었고, 조건문을 통해서 체육복을 잃어버린 학생들만 모을 List를 하나 더 선언해주었습니다.
- 이제 번호 순서대로 빌릴 수 있도록 정렬을 해주었고, 자신의 앞,뒤 자리의 여유 체육복을 소지한 번호에게 빌릴 경우를 구현하였다 
- 조건문을 통해서 빌릴 조건이 만족헀다면, 해당 여유복을 빌렸으므로 lend의 수를 늘려주고, reserve리스트에서 빌려준 학생 번호를 제거해줍니다.
- 그렇게 나온 전체 인원수에 체육복을 잃어버린 학생의 수를 -해주고, 여유복을 빌려준 수를 +해주어 체육복을 소지한 전체 갯수를 구하였습니다. 
- ## :black_nib: **Review**

- 이 문제는 테스트 케이스는 성공하는데, 자꾸 13,14번에서 실패하였다. 결국 찾지못해서 도움을 받아 성공시켰다. 그 이유는 filteredLostList의 앞 번호 순서로 빌리도록 하여야하는데 그렇지 않아 실패가 발생하였습니다. 이 문제를 풀면서 느낌점은 문제를 세밀하게 천천히 봐야겠다라고 느꼈습니다.