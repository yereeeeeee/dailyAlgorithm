import java.io.*;
import java.util.*;

public class baekjoon_16234_윤예리 {
    static int n, l, r;
    static int[][] arr;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bfs(i, j);
            }
        }

    }

    static void bfs(int x, int y) {
        boolean[][] visited = new boolean[n][n];
        Queue<Nation> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Nation(x, y));

        while (!q.isEmpty()) {
            Nation now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]) {
                    int tmp = Math.abs(arr[now.x][now.y] - arr[nx][ny]);
                    if (l <= tmp && tmp <= r) {
                        q.offer(new Nation(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        int total = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    total += arr[i][j];
                    num += 1;
                }
            }
        }
        if (num == 0) return;
        answer += 1;
        int value = (total/num);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    arr[i][j] = value;
                }
            }
        }

    }

    static class Nation{
        int x; int y;

        public Nation(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
