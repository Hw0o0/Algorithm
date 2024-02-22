import java.util.*;

public class BestAlbums {
    class Solution {

        public int[] solution(String[] genres, int[] plays) {
            Map<String, Integer> album = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                album.put(genres[i], album.getOrDefault(genres[i], 0) + plays[i]);
            }
            ArrayList<String> type = new ArrayList<>();
            for (String key : album.keySet()) {
                type.add(key);
            }

            Collections.sort(type, (o1, o2) -> album.get(o2) - album.get(o1));

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < type.size(); i++) {
                String g = type.get(i);

                int max = 0;
                int first = -1;
                for (int j = 0; j < genres.length; j++) {
                    if (g.equals(genres[j]) && max < plays[j]) {
                        max = plays[j];
                        first = j;
                    }
                }

                max = 0;
                int second = -1;
                for (int j = 0; j < genres.length; j++) {
                    if (g.equals(genres[j]) && max < plays[j] && j != first) {
                        max = plays[j];
                        second = j;
                    }
                }

                list.add(first);
                if (second >= 0) {
                    list.add(second);
                }


            }

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }

            return result;
        }
    }

}
