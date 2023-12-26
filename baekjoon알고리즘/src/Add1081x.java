import java.util.Scanner;

public class Add1081x {
    public static long calculate(int cnt,int div, int num) {
        long total=0;
        while (div >= cnt) {

            if (num / div != 0) {
                total = num / div + total;
                num = num % div;
            }
            if (num < 10) {
                total = total + num;
                break;
            }
            div = div / 10;
        }
        return total;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt=10;long x=0;

        int a = sc.nextInt(),b = Integer.parseInt(String.valueOf(sc.nextInt()));
        while(a<=b){
            int num = a;
            int div=1000000000;
            x = x+calculate(cnt,div,num);
            a++;
        }
        System.out.println(x);
    }
}
        //for(int x = a/max; 0 <= x; x--){
//        int y = a-(x*max);  // 나머지
//            x+=total;
//                    if(y%(max/10) !=0){ //나눴을때 0이 아니면 진입
//
//                    }
//                    share = num/10;//몫
//                    rest = num%10; //나머지
//                    add = share+rest;
//                    total =add+total;
//                    a++;