import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NthLargestNumber2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> sortGraph = new ArrayList<>();
        for(int a = 0; a < N; a++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int b = 0; b < N; b++){
                sortGraph.add(Integer.valueOf(st.nextToken()));
            }
        }
        Collections.sort(sortGraph,Collections.reverseOrder());
        System.out.println(sortGraph.get(N-1));
    }
}
