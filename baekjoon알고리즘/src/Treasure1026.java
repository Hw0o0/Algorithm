import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Treasure1026 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = 0;
        int[] x = new int[N];
        int[] y = new int[N];

        for(int a = 0; a < N; a++){
            x[a] = sc.nextInt();
        }
        for(int b = 0; b < N; b++){
            y[b] = sc.nextInt();
        }
        Arrays.sort(x);
        int[] z = Arrays.stream(y).boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer :: intValue).toArray();

        for(int a = 0; a < N; a++){
            S += x[a] * z[a];
        }
        System.out.println(S);
    }
}
