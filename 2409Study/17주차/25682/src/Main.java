import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                board[i][j] = tmp[j];
            }
        }

        System.out.println(Math.min(cnt('B'), cnt('W')));

    }

    static int cnt(char c) {
        int cnt = Integer.MAX_VALUE;
        int value;
        int[][] sum = new int[n+1][m+1]; // 누적합 계산

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // i+j가 짝수이면 value는 color랑 같을 때 0 다를 때 1
                if ((i+j) % 2 == 0) value = board[i][j] != c ? 1 : 0;
                // i+j가 홀수이면 value는 color랑 같을 때 1 다를 때 0
                else value = board[i][j] == c ? 1 : 0;

                //
                sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] - sum[i][j] + value;
            }
        }

        for (int i = 1; i <= n-k+1 ; i++) {
            for (int j = 1; j <= m-k+1 ; j++) {
                cnt = Math.min(cnt, sum[i+k-1][j+k-1] - sum[i+k-1][j-1] - sum[i-1][j+k-1] + sum[i-1][j-1]);
            }
        }

        return cnt;
    }
}