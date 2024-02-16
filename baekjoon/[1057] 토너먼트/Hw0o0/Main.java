import java.util.Scanner;
public class Tournament1057 {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int round = 0;
            if(a > n || n < b || a == b){
                round = -1;
                System.out.print(round);
                return;
            }
            while (true) {
                if(a == b){
                    break;
                }
                a = a/2+a%2;
                b = b/2+b%2;
                round += 1;
            }
            System.out.print(round);
        }
    }
