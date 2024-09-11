import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_13305_윤예리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] distance = new int[n-1];
        for (int i=0; i<n-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int[] cost = new int[n];
        for (int i=0; i<n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long total_cost = 0;
        // python에서 float('inf') == java에서 Integer.MAX_VALUE
        long min_cost = Integer.MAX_VALUE;
        for (int i=0; i<n-1; i++){
            min_cost = Math.min(min_cost, cost[i]);
            total_cost += (min_cost * distance[i]);
        }
        System.out.println(total_cost);
    }
}
