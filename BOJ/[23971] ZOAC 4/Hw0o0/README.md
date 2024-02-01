# [23971] ZOAC 4

## :pushpin: **Algorithm**

알고리즘

- 수학
- 사칙연산

## :round_pushpin: **Logic**

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZOACFour23971 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int height = (h - 1) / (n + 1) + 1;
    int width = (w - 1) / (m + 1) + 1;

    System.out.println(height * width);
  }
}

 ```
- 간격을 지키면서 앉을수 있는 행을 수를 구하고 간격을 지키면 행에 앉을수 있는 수를 구해서 곱해주면 최대 수용 참가자를 구할 수 있습니다.
- ## :black_nib: **Review**
- 로직을 구현하는데까지 적지 않은 시간을 소요를 한 것 같다.