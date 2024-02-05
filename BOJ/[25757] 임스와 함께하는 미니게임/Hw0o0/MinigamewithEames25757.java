import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MinigamewithEames25757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> names = new HashSet<>();

        for (int a = 0; a < N; a++) {
            st = new StringTokenizer(br.readLine());
            names.add(st.nextToken());
        }
        switch (game) {
            case "Y":
                System.out.println(names.size());
                break;
            case "F":
                System.out.println(names.size()/2);
                break;
            case "O":
                System.out.println(names.size()/3);
                break;
        }
    }
}
