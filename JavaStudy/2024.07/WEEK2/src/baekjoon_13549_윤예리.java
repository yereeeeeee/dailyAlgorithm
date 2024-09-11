import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon_13549_윤예리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == 0) {
            if (k==0) System.out.println(0);
            else System.out.println(solution(n, k) + 1);
        } else System.out.println(solution(n, k));
    }


    static int[] dp = new int[100001];
    static int solution(int a, int b) {
        Deque<Integer> q = new LinkedList<>();

        if (a == 0) q.offer(1);
        else q.offer(a);

        while (!q.isEmpty()) {
            int x = q.pollFirst();

            if (x == b) return dp[x];

            for (int nx : new int[] {x-1, x+1, x*2}) {
                if (0 <= nx && nx< 100001 && dp[nx] == 0) {
                    if (nx == x*2){
                        dp[nx] = dp[x];
                        q.offerFirst(nx);
                    }
                    else {
                        dp[nx] = dp[x] + 1;
                        q.offer(nx);
                    }
                }
            }
        }
        return dp[a];
    }
}
