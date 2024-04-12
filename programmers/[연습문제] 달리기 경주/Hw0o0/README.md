# [연습문제] 달리기 경주

## :pushpin: **Algorithm**

알고리즘

- 구현

## :round_pushpin: **Logic**

 ```java
import java.util.HashMap;

public class RunningRace {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }
        for (String calling : callings) {
            int index = playerMap.get(calling);
            if (index > 0) {
                String prePerson = players[index - 1];
                players[index - 1] = calling;
                players[index] = prePerson;

                playerMap.put(calling, index - 1);
                playerMap.put(prePerson, index);
            }
        }
        return players;
    }
}

 ```

- 먼저 시간 복잡도를 고려해서 for문을 통해 HashMap에 players[i]를 넣어준다
- for문을 통해서 calling된 Player의 인덱스 번호를 찾아서 순위를 변경해주고 밀려난 인덱스의 위치에 뒤쳐진 Player를 넣어준다.
- 그리고 다음 calling을 위해 playerMap에도 변경된 순서를 적용시켜준다.
- ## :black_nib: **Review**

- 처음에 시간복잡도를 신경 쓰지않고 제출했더니 시간 초과가 떠서 HashMap으로 변경하여서 풀었다.