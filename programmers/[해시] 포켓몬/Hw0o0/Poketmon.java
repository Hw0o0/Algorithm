public class Poketmon {

    public int solution(int[] nums) {
        int answer = 0;
        int[] poketmon = new int[nums.length];

        for (int a = 0; a < nums.length; a++) {
            boolean check = false;
            for (int b = 0; b < poketmon.length; b++) {
                if (nums[a] == poketmon[b]) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                poketmon[answer] = nums[a];
                answer++;
            }
        }
        if (answer > nums.length / 2) {
            answer = nums.length / 2;
        }
        return answer;
    }
}
