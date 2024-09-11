import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_14501_윤예리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        StringTokenizer st;
        int[][] schedule = new int[n][2];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i=n-1; i>=0; i--) {
            if (i + schedule[i][0] > n) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], schedule[i][1] + dp[i+schedule[i][0]]);
            }
        }
        System.out.println(dp[0]);
    }
}
