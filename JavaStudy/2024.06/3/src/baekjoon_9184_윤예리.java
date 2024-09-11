import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_9184_윤예리 {
    public static int[][][] dp = new int[21][21][21];
    public static int solution(int a, int b, int c) {
        if (a<=0 || b<=0 || c<=0) return 1;
        if (check(a, b, c) && dp[a][b][c] != 0) return dp[a][b][c];
        if (a>20 || b>20 || c>20) return dp[20][20][20] = solution(20, 20, 20);

        if (a<b && b<c) {
            return dp[a][b][c] = solution(a, b, c-1) + solution(a, b-1, c-1) - solution(a, b-1, c);
        } else {
            return dp[a][b][c] = solution(a-1, b, c) + solution(a-1, b-1, c) + solution(a-1, b, c-1) - solution(a-1, b-1, c-1);
        }
    }

    static boolean check(int a, int b, int c) {
        return 0<=a && a<=20 && 0<=b && b<=20 && 0<=c && c<=20;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a==-1 && b==-1 && c==-1) return;

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + solution(a, b, c));
        }
    }
}
