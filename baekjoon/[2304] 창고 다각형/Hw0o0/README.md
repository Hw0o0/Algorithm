# [2304] 창고 다각형 오답 노트

## :pushpin: **Algorithm**

알고리즘
- 자료 구조
- 브루트포스 알고리즘
- 스택
## :round_pushpin: **Logic**
수정 전 
 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class WarehousePolygon2304 {

    public static class LH {
        int L;
        int H;

        public LH(int L, int H) {
            this.L = L;
            this.H = H;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int area = 0, width = 0, height = 0;
        LH[] list = new LH[N - 1];
        for (int a = 0; a < N - 1; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[a] = new LH(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(list, Comparator.comparingInt(LH -> LH.L));

        for (int b = 0; b < N-1; b++) {
            if (height > list[b].H) {
                if(list[N-2].H == list[b].H){
                    area += height + (list[b].L-width) * list[b].H;
                }
                continue;
            }
            if (height != list[b].H) {
                area += (list[b].L - width) * height;
            }
            width = list[b].L;
            height = list[b].H;
        }
        System.out.println("\n" + area);
    }
}
 ```
## :round_pushpin: **Logic**
수정 후
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class WarehousePolygon2304 {

    public static class LH {
        int L;
        int H;

        public LH(int L, int H) {
            this.L = L;
            this.H = H;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int area = 0;
        LH[] list = new LH[N];

        for (int a = 0; a < N; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[a] = new LH(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(list, Comparator.comparingInt(LH -> LH.L));

        int maxH = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (list[i].H > maxH) {
                maxH = list[i].H;
                maxIndex = i;
            }
        }

        int tempH = list[0].H;
        for (int i = 1; i <= maxIndex; i++) {
            if (list[i].H > tempH) {
                area += (list[i].L - list[i-1].L) * tempH;
                tempH = list[i].H;
            } else {
                area += (list[i].L - list[i-1].L) * tempH;
            }
        }

        tempH = list[N-1].H;
        for (int i = N - 2; i >= maxIndex; i--) {
            if (list[i].H > tempH) {
                area += (list[i+1].L - list[i].L) * tempH;
                tempH = list[i].H;
            } else {
                area += (list[i+1].L - list[i].L) * tempH;
            }
        }

        area += maxH;
        System.out.println(area);
    }
}

 ```
- 제일 높이가 높은 수를 찾고 높은 수를 기준점을 잡아서 왼쪽과 오른쪽에서 차례대로 면적을 구하는데 첫 for문에서는 왼쪽에서부터 현재의 높이가 이전의 높이보다 높다면 현재의 위치와 이전의 위치와의 차이를 구한 후 높이를 곱해준다.하지만 현재 위치가 이전의 높이보다 낮다면 이전의 현재 위치와 이전의 위치 차를 구한 후 높이와 곱해준다.
- 두번째 for문은 오른쪽에서부터 높이가 높은 수를 기준으로 잡아 첫 for문처럼 면적을 더 해간다. 그리고 제일 높은 수를 더해준다. 그러면 구하고 싶은 총 면적의 값이 나온다
- ## :black_nib: **Review**

- 처음에 리스트를 정렬시키고 왼쪽에서부터 끝까지 면적을 구하면서 총 면적을 구하려하였는데 생각할 예외가 더 많았다.
- 아직 부족한 점이 많은걸 느꼈고, 조금 더 다양한 관점에서 보고 생각했던 시간이었다.