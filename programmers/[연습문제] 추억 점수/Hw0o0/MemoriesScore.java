import java.util.*;

public class MemoriesScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        Map<String,Integer> person = new HashMap<>();

        for(int a = 0; a < name.length; a++){
            person.put(name[a],yearning[a]);
        }
        for(int b = 0; b < photo.length; b++){
            int x = 0;
            for(int c = 0; c< photo[b].length; c++){
                if(person.containsKey(photo[b][c])){
                    x+=person.get(photo[b][c]);
                }
            }
            answer.add(x);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
