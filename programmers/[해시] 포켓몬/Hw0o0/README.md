# [해시] 포켓몬

## :pushpin: **Algorithm**

알고리즘

- 해시

## :round_pushpin: **Logic**

 ```java
public class poketmon {

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


 ```

- 첫번째 반복문에서 nums에 중복된 값들을 걸러주어 poketmon에 넣어준다. 만약에 poketmon의 수가 필요 수보다 많다면 nums.length/2를 반환하고 아니면 그대로 answer을 반환한다
- ## :black_nib: **Review**

- 해시를 생각하지않고 풀었는데 해시를 썼다면 코드가 확실히 줄었을것 같다.