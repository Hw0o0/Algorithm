# [5073] 삼각형과 세 변

## :pushpin: **Algorithm**

알고리즘
- 수학
- 구현
- 기하학
## :round_pushpin: **Logic**

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Triangles5073 {

    public static class Triangle {

        Integer a;
        Integer b;
        Integer c;

        public Triangle(Integer a, Integer b, Integer c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public boolean isValid() {
            return a + b > c && b + c > a && c + a > b;
        }

        public String getType() {
            if (a.equals(b) && b.equals(c)) {
                return "Equilateral";
            } else if (a.equals(b) || b.equals(c) || c.equals(a)) {
                return "Isosceles";
            } else {
                return "Scalene";
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            Triangle triangle = new Triangle(a, b, c);
            if (triangle.isValid()) {
                System.out.println(triangle.getType());
            } else {
                System.out.println("Invalid");
            }
        }
    }
}


 ```

- 삼각형을 만들면서  첫번쨰 조건문을 통해서 0,0,0이 입력이되면 종료되게 한다.
- 두번째 조건문에서 삼각형의 조건을 충족하는지 판단한다. 그 결과가 참이면 3가지의 조건에 따라 출력값이 나오게 한다. 
- ## :black_nib: **Review**

- 출력값은 같은데 실패했다고해서 문제를 찾는데 시간을 소요한 것 빼고는 쉬웠다. 