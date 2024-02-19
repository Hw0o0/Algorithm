package hash;

import java.util.HashMap;
import java.util.Map;

public class Costume {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String,Integer> costume = new HashMap<>();
            String type;

            for (int a = 0; a < clothes.length;a++) {
                type = clothes[a][1];

                if(costume.containsKey(type)){
                    costume.put(type,costume.getOrDefault(type,0)+1);
                }else{
                    costume.put(type,1);
                }
            }

            for(Map.Entry<String,Integer> c : costume.entrySet()){
                answer *= c.getValue()+1;
            }
            return answer-1;
        }
    }
}