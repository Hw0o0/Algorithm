package 탐욕법_Greedy;
import java.util.*;
public class gymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        for (int l : lost) {
            lostList.add(l);
        }
        for (int r : reserve) {
            reserveList.add(r);
        }


        //자기 체육복 잃어버렸는데 자기 여유복 있을경우
        List<Integer> filteredLostList = new ArrayList<>();
        for (int lostStu : lostList) {
            if (reserveList.contains(lostStu)) {
                reserveList.remove(Integer.valueOf(lostStu)); //여유분 제거
            } else {
                filteredLostList.add(lostStu); // 여유분 없으면 잃어버린 학생으로 바꿈
            }
        }

        Collections.sort(filteredLostList);
        // 체육복이 없지만, 앞과 뒤 자리에 여분의 체육복을 빌린 경우
        int lend = 0;
        for (int lostStu : filteredLostList) {
            if (reserveList.contains(lostStu - 1)) {
                reserveList.remove(Integer.valueOf(lostStu - 1));
                lend++;
            } else if (reserveList.contains(lostStu + 1)) {
                reserveList.remove(Integer.valueOf(lostStu + 1));
                lend++;
            }
        }

        return n - filteredLostList.size() + lend;
    }
}
