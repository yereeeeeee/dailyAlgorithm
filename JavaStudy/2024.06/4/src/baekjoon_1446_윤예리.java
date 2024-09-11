import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;

public class baekjoon_1446_윤예리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<Path> path = new ArrayList<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (to>d) continue;
            if (to-from <= dist) continue;
            path.add(new Path(from, to, dist));
        }

        Collections.sort(path, new Comparator<Path>() {
            public int compare(Path o1, Path o2) {
                if (o1.from == o2.from) return Integer.compare(o1.to, o2.to);
                return Integer.compare(o1.from, o2.from);
            }
        });

        int move = 0;
        int[] dp = new int[d+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        int idx = 0;
        while (move < d) {
            if (idx < path.size()) {
                Path sp = path.get(idx);
                if (move == sp.from) {
                    dp[sp.to] = Math.min(dp[move] + sp.dist, dp[sp.to]);
                    idx++;
                } else {
                    dp[move + 1] = Math.min(dp[move + 1], dp[move] + 1);
                    move++;
                }
            } else {
                dp[move+1] = Math.min(dp[move+1], dp[move]+1);
                move++;
            }
        }
        System.out.println(dp[d]);
    }

    static class Path {
        int from, to, dist;
        public Path(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

}
