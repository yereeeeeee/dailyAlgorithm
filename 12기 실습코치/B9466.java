import java.io.*;
import java.util.*;

public class B9466 {
    static int n, cnt;
    static int[] link;
    static boolean[] visited, isSearchEnd;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            link = new int[n+1];
            visited = new boolean[n+1];
            isSearchEnd = new boolean[n+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n+1; i++) {
                int from = i;
                int to = Integer.parseInt(st.nextToken());

                link[from] = to;
            }
            cnt = 0;
            for (int i = 1; i < n+1; i++) {
                dfs(i);
            }
            System.out.println(n-cnt);
        }
    }

    static void dfs(int pos) {
        visited[pos] = true;
        int nxt = link[pos];
        if (!visited[nxt]) dfs(nxt);
        else {
            if (!isSearchEnd[nxt]) {
                cnt++;
                while (nxt != pos) {
                    cnt++;
                    nxt = link[nxt];
                }
            }
        }

        isSearchEnd[pos] = true;
    }
}
