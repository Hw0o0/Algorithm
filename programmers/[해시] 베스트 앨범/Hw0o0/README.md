# [해시] 베스트 앨범 오답 노트

## :pushpin: **Algorithm**

알고리즘

- 해시

## :round_pushpin: **Logic**

- 수정 전

 ```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbums {

  class Solution {

    public static class Album implements Comparable<Album> {

      String genres;
      Integer play;

      public Album(String genres, Integer play) {
        this.genres = genres;
        this.play = play;
      }

      @Override
      public int compareTo(Album a) {
        return this.play.compareTo(a.play);
      }
    }

    public int[] solution(String[] genres, int[] plays) {
      String type;
      Integer play;
      HashMap<String, List<Integer>> typeAlbum = new HashMap<>();
      HashMap<String, Integer> album = new HashMap<>();
      HashMap<Integer, Integer> result = new HashMap<>();

      for (int a = 0; a < genres.length; a++) {
        type = genres[a];
        play = plays[a];

        List<Integer> list = typeAlbum.getOrDefault(type, new ArrayList<>());
        list.add(play);
        typeAlbum.put(type, list);

        if (album.containsKey(type)) {
          album.put(type, album.get(type) + play);
        } else {
          album.put(type, play);
        }
      }

      List<String> rank = new ArrayList<>(album.keySet());
      rank.sort((value1, value2) -> album.get(value2).compareTo(album.get(value1)));

      int x = 0;
      for (String albumKey : rank) {
        List<Integer> sto = typeAlbum.get(albumKey);
        sto.sort(Comparator.reverseOrder());

        if (sto.size() == 1) {
          result.put(x, sto.get(0));
          x++;
        } else if (sto.size() >= 2) {
          result.put(x, sto.get(0));
          result.put(x + 1, sto.get(1));
          x += (sto.size() + 1);
        }
      }

      int y = 0;
      int[] answer = new int[result.size()];

      for (int b = 0; b < plays.length; b++) {
        if (!result.containsValue(plays[b])) {
          continue;
        }

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
          if (plays[b] == entry.getValue()) {
            answer[y] = entry.getKey();
            y++;
          }
        }
      }
      return answer;
    }

  }

}


 ```

- 수정 후

 ```java
import java.util.*;
class Solution {
  public int[] solution(String[] genres, int[] plays) {
    Map<String, Integer> album = new HashMap<>();
    for(int i=0;i<genres.length;i++){
      album.put(genres[i],album.getOrDefault(genres[i],0)+plays[i]);
    }
    ArrayList<String> type = new ArrayList<>();
    for(String key : album.keySet()){
      type.add(key);
    }

    Collections.sort(type,(o1,o2)->album.get(o2)-album.get(o1));

    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0;i<type.size();i++){
      String g = type.get(i);

      int max = 0;
      int first = -1;
      for(int j=0;j<genres.length;j++){
        if(g.equals(genres[j])&&max<plays[j]){
          max=plays[j];
          first =j;
        }
      }


      max = 0;
      int second = -1;
      for(int j=0;j<genres.length;j++){
        if(g.equals(genres[j]) && max < plays[j] && j != first){
          max = plays[j];
          second = j;
        }
      }

      list.add(first);
      if(second >=0) list.add(second);


    }

    int[] result = new int[list.size()];
    for(int i=0;i<list.size();i++){
      result[i] = list.get(i);
    }

    return result;
  }
}

 ```

- 먼저 장르별로 재생횟수가 많은 것을 구별한다.
- 그리고 구별한 hashMap을 통해서 재생많은수 별로 정렬을 해준다.
- 장르별 재생횟수가 높은 2개의 노래를 찾아서 다른 리스트에 순서에 맞게 저장해준다.
- plays의 인덱스 순으로 몇번째 순위인지를 결과로 나타내면 된다.
- ## :black_nib: **Review**
- 머리로만 생각해서 코드를 짜려니까 너무 머리가 복잡한 것 같다.
- 수정 전과 수정 후의 코드 로직은 같은데 코드의 가독성 차이가 너무나고 아직도 시간초과를 해결하기에 너무 어려운것 같다.