import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxProduct1500 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int share = S / K;
        int rest = S % K, total = 1;
        for (int a = 1; a <= K; a++) {
            if(a<=rest){
                total*=(share+1);
            }else{
                total*=share;
            }
        }
        System.out.println(total);
    }
}
