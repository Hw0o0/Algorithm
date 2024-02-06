import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Budget2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int total = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for (int a = 0; a < N; a++) {
            int requestBudget = Integer.parseInt(st.nextToken());
            list.add(requestBudget);
            total += requestBudget;
            if (max < requestBudget) {
                max = requestBudget;
            }
        }

        st = new StringTokenizer(br.readLine());
        int countryBudget = Integer.parseInt(st.nextToken());

        if (total < countryBudget) {
            System.out.println(max);
        }
        else {
            Collections.sort(list);

            int start = 0;
            int end = list.get(N-1);
            int result = 0;

            while(start <= end){
                int mid = (start+end)/2;
                int sto = 0;
                for(int num : list){
                    if(num<mid){
                        sto+=num;
                    }else{
                        sto+=mid;
                    }
                }
                if(sto>countryBudget){
                    end = mid-1;
                }else{
                    start = mid+1;
                    result = Math.max(result,mid);
                }
            }
            System.out.println(result);
        }
    }
}
