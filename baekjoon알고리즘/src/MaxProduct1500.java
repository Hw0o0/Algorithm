import java.util.Scanner;

public class MaxProduct1500 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        int S= 0;
        int K= 0;
        while(!check) {
             S = sc.nextInt();
             K = sc.nextInt();
            if (S <= 100 && S >= K) {
                check = true;
            }else {
                System.out.println("잘못된 입력 값입니다.");
            }
        }
        int share = S / K;
        int rest = S % K;
        long total = 1;
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
