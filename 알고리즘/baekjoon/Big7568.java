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
