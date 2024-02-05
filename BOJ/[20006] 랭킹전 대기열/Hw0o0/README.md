# [20006] 랭킹전 대기열

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class RankedQueue20006 {

    static class Player {

        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Player> playerList = new ArrayList<>(); // 플레이어의 정보들
        int roomCount = P / M;                   // 방의 갯수
        if (P % M != 0) {
            roomCount += 1;
        }
        List<List<Player>> room = new ArrayList<>();
        for (int i = 0; i < roomCount; i++) {
            room.add(new ArrayList<>());
        }
        for (int a = 0; a < P - 1; a++) {
            st = new StringTokenizer(br.readLine());
            int player = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            playerList.add(new Player(player, nickname));
        }

        int leader = playerList.get(0).level, cnt = 1;
        room.get(0).add(playerList.get(0));
        for (int b = 0; b < P; b++) {
            if (leader - 10 > playerList.get(b).level || leader + 10 < playerList.get(b).level) {
                room.get(cnt).add(playerList.get(b));
                leader = playerList.get(b).level;
                playerList.remove(b);
                P--;
                cnt++;
            }
        }
        for (Player player : playerList) {
            for (int c = 0; c < M; c++) {
                if (room.get(c).get(0) != null && room.get(c).get(0).level + 10 <= player.level
                    && player.level >= room.get(c).get(0).level - 10) {
                    room.get(c).add(player);
                }
            }
        }
        for (int d = 0; d < roomCount; d++) {
            if (room.get(d).size() == M) {
                System.out.println("Started!\n");
            } else {
                System.out.println("Waiting!\n");
            }
            for (int e = 0; e < M; e++) {
                System.out.println(room.get(d).get(e).level + room.get(d).get(e).nickname);
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class RankedQueue20006 {

    static class Player implements Comparable<Player> {

        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player player) {
            return this.nickname.compareTo(player.nickname);
        }
    }

    static class Room {

        int level;
        List<Player> group;

        public Room(int level) {
            this.level = level;
            this.group = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();
        for (int a = 0; a < P; a++) {
            st = new StringTokenizer(br.readLine());

            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            boolean checked = false;
            for (int b = 0; b < rooms.size(); b++) {
                Room currentRoom = rooms.get(b);
                int levelCheck = Math.abs(currentRoom.level - level);

                if (currentRoom.group.size() >= M) {
                    continue;
                }
                if (levelCheck <= 10) {
                    currentRoom.group.add(new Player(level, nickname));
                    checked = true;
                    break;
                }
            }
            if (checked == false) {
                Room newRoom = new Room(level);
                newRoom.group.add(new Player(level, nickname));
                rooms.add(newRoom);
            }
        }
        for (int c = 0; c < rooms.size(); c++) {
            Room currentRoom = rooms.get(c);
            if (currentRoom.group.size() >= M) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            Collections.sort(currentRoom.group);

            for (int d = 0; d < currentRoom.group.size(); d++) {
                Player player = currentRoom.group.get(d);
                System.out.println(player.level + " " + player.nickname);
            }
        }
    }
}


 ```

- Player를 만들자말자 level에 맞는 룸의 입장을 시킨다. 첫 if문에서 룸의 인원수가 다 채워졌는지 확인한다
- 두번째 if문에서는 room의 level 제한에 알맞는지 확인해준다. 만약에 제한에 걸리지 않는다면 room에 입장 시킨다 그리고 방의 입장이 가능하다고 checked의 상태를
  true로 변경해준다.
- 만약 방의 인원 수가 다 찼다면 방을 하나 더 생성해준다.
- 그리고 room의 size를 통해 인원 수가 다 채워졌다면 started!를 출력해주고 그렇지 않다면 waiting!을 출력해준다.
- Comparable을 통해서 Person의 nickname에 기준으로 정렬을 시켰다. 그리고 방의 인원수를 순서대로 출력해준다.
- ## :black_nib: **Review**

- 로직을 너무 어렵게 생각을 해서 구현하는데 시간이 많이 소요되어서 시간 안에 구현하지 못했다.
- 자바 기초를 확실히 다시 해야될 필요를 느꼈다.