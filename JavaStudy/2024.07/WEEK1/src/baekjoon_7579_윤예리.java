import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_7579_윤예리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] memory = new int[n+1];
        for (int i = 1; i <= n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] cost = new int[n+1];
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
        }

        int[][] dp = new int[sum][n+1];
        for (int j=1; j<n+1; j++) {
            for (int i = 0; i < sum; i++) {
                if (i>=cost[j]) dp[i][j] = Math.max(memory[j] + dp[i-cost[j]][j-1], dp[i][j-1]);
                else dp[i][j] = dp[i][j-1];

            }
        }

        for (int i = 0; i < sum; i++) {
            if (dp[i][n] >= m) {
                System.out.println(i);
                break;
            }
        }
    }
}
