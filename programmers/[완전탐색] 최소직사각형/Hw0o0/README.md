# [완전탐색] 최소직사각형

## :pushpin: **Algorithm**

알고리즘

- 완전탐색

## :round_pushpin: **Logic**

 ```java
import java.util.*;

public class MinimumRectangle {

    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;

        for (int a = 0; a < sizes.length; a++) {
            Arrays.sort(sizes[a]);
        }

        for (int a = 0; a < sizes.length; a++) {
            if (height < sizes[a][0]) {
                height = sizes[a][0];
            }

            if (width < sizes[a][1]) {
                width = sizes[a][1];
            }
        }

        return width * height;
    }
}


 ```

- 먼저 sizes의 값들을 정렬 시켜주고, 반복문을 통해서 가로와 세로의 값중 각각 가장 높은 값을 구하고 그 값을 곱해주면 원하는 결과값을 얻을수 있다.
- ## :black_nib: **Review**

- 이번 문제는 금방 해결한것 같다.