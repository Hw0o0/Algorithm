# [7568] 덩치

## :pushpin: **Algorithm**

알고리즘

- 구현
- 브루트포스 알고리즘

## :round_pushpin: **Logic**

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Big7568 {

    public static class Person {

        Integer weight;
        Integer height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int personCnt = Integer.parseInt(br.readLine());
        List<Person> personList = new ArrayList<>();
        int[] rank = new int[personCnt];

        for (int a = 0; a < personCnt; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            personList.add(new Person(weight, height));
        }
        int b = 0;
        while (b < personCnt) {
            int cnt = 1;
            for (Person person : personList) {
                if (personList.get(b).weight < person.weight
                    && personList.get(b).height < person.height) {
                    cnt++;
                }
            }
            rank[b] = cnt;
            b++;
        }
        for (int c = 0; c < personCnt; c++) {
            System.out.print(rank[c] + " ");
        }
    }
}

 ```

- 먼저 사람 수를 입력받고 입력 받은 수를 사용해서 반복문으로 사람들의 키와 몸무게를 받아서 리스트에 담아준다.
- 사람들의 정보를 가진 리스트를 가지고 자신보다 키가 크고, 몸무게가 더 나가는 수를 구해서 등수를 정해준다.
- 그리고 등수를 배열 rank에 저장시켜서 출력해준다.
- ## :black_nib: **Review**

- 문제를 제대로 이해하지않고,출력 값만 보고 풀다가 시간이 많이 소요되었다.
- 앞으로 문제를 먼저 제대로 이해하고 해결해야겠다.