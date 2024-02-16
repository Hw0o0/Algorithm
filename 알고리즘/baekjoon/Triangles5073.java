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
