package 완전탐색;

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
