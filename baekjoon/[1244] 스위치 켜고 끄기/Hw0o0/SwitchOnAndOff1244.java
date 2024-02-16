import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchOnAndOff1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchAmount = Integer.parseInt(br.readLine());
        int[] switchInfo = new int[switchAmount];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int a = 0; a < switchAmount; a++) {
            switchInfo[a] = Integer.parseInt(st.nextToken());
        }

        int personAmount = Integer.parseInt(br.readLine());

        for (int b = 0; b < personAmount; b++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                int index = num - 1;
                while (index < switchAmount) {
                    switchInfo[index] ^= 1;
                    index += num;
                }
            } else if (gender == 2) {
                int index = num - 1;
                switchInfo[index] ^= 1;

                int left = index - 1;
                int right = index + 1;
                while (left >= 0 && right < switchAmount && switchInfo[left] == switchInfo[right]) {
                    switchInfo[left] ^= 1;
                    switchInfo[right] ^= 1;
                    left--;
                    right++;
                }
            }
        }
        for (int d = 0; d < switchInfo.length; d++) {
            System.out.print(switchInfo[d] + " ");
            if ((d + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}