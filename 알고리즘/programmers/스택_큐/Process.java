package 스택_큐;

import java.util.*;

public class Process {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int priority : priorities) {
            queue.add(priority);
        }
        Arrays.sort(priorities);
        int index = priorities.length - 1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == priorities[index - answer]) {
                answer++;
                if (location == 0) {
                    break;
                }
            } else {
                queue.add(current);
            }
            location = (location + queue.size() - 1) % queue.size();
        }
        return answer;
    }
}

