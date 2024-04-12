package 연습문제;

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
