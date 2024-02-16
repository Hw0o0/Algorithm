import java.util.Scanner;

public class SugarDelivery2839 {
    public static void main(String[] args) { //최대한 적은 봉지의 수를 가져가는것이 문제.
        Scanner sc = new Scanner(System.in);

        int bag = sc.nextInt(); //N킬로그램을 배달
        int totalBag;
        // 5kg
        int bigRest = bag%5; // 나머지
        int bigShare = bag/5; //몫
        // 3kg
        int smallShare = bag%3; //  나머지
        int smallRest = bag/3; //몫

        if (bigRest == 0){ // 5키로로 딱 나눠질때
            System.out.println(bigShare);
            return;
        }
        else if(bigRest !=0 ||smallShare!=0) {
            for (int x = bigShare; 0 <= x; x--) {
                int y = bag - (x * 5);
                if (y % 3 == 0) {
                    totalBag = x + y / 3;
                    System.out.println(totalBag);
                    return;
                }
            }
        }
        else if(smallShare == 0){ // 3키로로 딱 나눠질때
            System.out.println(smallRest);
            return;
        }
        System.out.println(-1);
    }
}

//    int shortShare = bigRest / 3; // 5키로 나누고 남은 나머지에 3키로로 나눠서 맟춰 나온 3키로 봉지 수
//    int longShare = bigRest / 3; // 3키로 나누고 남은 나머지에 5키로로 나눠서 맟춰 나온 5로 봉지 수

//        else if(smallShare%5==0){ // 3키로하고 남은거 5키로 딱 맞음
//            totalBag = smallRest+longShare;
//            System.out.println(totalBag);
//            return;
//        }
