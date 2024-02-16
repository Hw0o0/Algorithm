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
