package PCCE;
import java.util.*;
public class FoldBill {
        public static int solution(int[] wallet, int[] bill) {
            int answer = 0;

            Arrays.sort(wallet);
            Arrays.sort(bill);

            while (!sizeCheck(wallet, bill)) {
                half(bill);
                answer++;
            }
            return answer;
        }

        private static void half(int[] bill) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
        }
        private static boolean sizeCheck(int[] wallet, int[] bill) {
            Arrays.sort(wallet);
            Arrays.sort(bill);

            return bill[0] <= wallet[0] && bill[1] <= wallet[1];
        }
    }
