import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_7562_윤예리 {
    public static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int L, r, c, point_r, point_c;
    public static int[][] arr;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc=1; tc<T+1; tc++) {
            L = Integer.parseInt(br.readLine());
            arr = new int[L][L];
            visited = new boolean[L][L];

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr[r][c] = 1;

            st = new StringTokenizer(br.readLine());
            point_r = Integer.parseInt(st.nextToken());
            point_c = Integer.parseInt(st.nextToken());

            bfs();
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            if (x==point_r && y==point_c) {
                System.out.println(arr[x][y]-1);
                return;
            }

            for (int d = 0; d<8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx>=0 && nx<L && ny>=0 && ny<L && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    arr[nx][ny] = arr[x][y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
