import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class WarehousePolygon2304 {

    public static class LH {
        int L;
        int H;

        public LH(int L, int H) {
            this.L = L;
            this.H = H;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int area = 0;
        LH[] list = new LH[N];

        for (int a = 0; a < N; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[a] = new LH(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(list, Comparator.comparingInt(LH -> LH.L));

        int maxH = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (list[i].H > maxH) {
                maxH = list[i].H;
                maxIndex = i;
            }
        }

        int tempH = list[0].H;
        for (int i = 1; i <= maxIndex; i++) {
            if (list[i].H > tempH) {
                area += (list[i].L - list[i-1].L) * tempH;
                tempH = list[i].H;
            } else {
                area += (list[i].L - list[i-1].L) * tempH;
            }
        }

        tempH = list[N-1].H;
        for (int i = N - 2; i >= maxIndex; i--) {
            if (list[i].H > tempH) {
                area += (list[i+1].L - list[i].L) * tempH;
                tempH = list[i].H;
            } else {
                area += (list[i+1].L - list[i].L) * tempH;
            }
        }

        area += maxH;
        System.out.println(area);
    }
}
