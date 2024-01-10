import java.util.Scanner;
public class StandOneLine1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = new int[n+1];
        for (int x = 1; x <= n; x++) {
            int sequence = sc.nextInt();
            for (int y = 1; y <= n; y++) {
                if (sequence == 0) {
                    if (result[y] == 0) {
                        result[y] = x;
                        break;
                    }
                } else if (result[y] == 0) {
                    sequence--;
                }
            }
        }
        for (int a = 1; a <= n; a++) {
            System.out.println(result[a]);
        }
    }
}
